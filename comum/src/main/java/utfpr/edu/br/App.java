package utfpr.edu.br;

import utfpr.edu.br.md5.Md5;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        try {
            String mensagem = "Coco gelado";
            String criptografado = Md5.MD5(mensagem);
            String mensagem2 = "Coco gelado";
            String criptografado2 = Md5.MD5(mensagem2);
            if(mensagem.equals(mensagem2)&&criptografado.equals(criptografado2)){
                System.out.println("Alegria");
            }else{
                System.out.println("Triste ;(");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
