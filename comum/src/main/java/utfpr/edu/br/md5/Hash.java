package utfpr.edu.br.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitaria para gerar hash md5 de arquivos a fim de garntir a integridade
 */
public class Hash {


    public static String getMd5(File file) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            InputStream is = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int read = 0;

            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            is.close();
            return bigInt.toString(16);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Não foi possível processar o arquivo para MD5", e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
