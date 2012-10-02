package utfpr.edu.br.util;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 22:25
 */

import java.text.Normalizer;

import java.util.regex.Pattern;

/**
 * @author Bernardo Vale
 */
public class StringUtil {
    //String palavra = "éêÉÊ";            //Maiusculo:201-202 Minusculo:233-234
    //String palavra = "àáâãÀÁÂÃ";        //Maiusculo:192-195 Minusculo:224-227
    //String palavra = "íÍ";             //Maiusculo:205 Minusculo:237
    //String palavra = "óôõÓÔÕ";           //Maiusculo:211-213 Minusculo:243-245
    //String palavra = "úÚ";                 //Maiusculo:218 Minusculo:250
  public static String letrasEspeciais = "àáâãÀÁÂÃéêÉÊíÍóôõÓÔÕúÚ";

    public StringUtil() {
    }

    /**
     * Passa uma string e a retorna sem acentos e o caralho alado
     * @param s
     * @return
     */
    public static String mascararTexto(String s) {
        String temp = Normalizer.normalize(s, java.text.Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

}
