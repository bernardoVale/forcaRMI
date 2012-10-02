package utfpr.edu.br;

import utfpr.edu.br.util.StringUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //String palavra = "éêÉÊ";            //Maiusculo:201-202 Minusculo:233-234
        //String palavra = "àáâãÀÁÂÃ";        //Maiusculo:192-195 Minusculo:224-227
        //String palavra = "íÍ";             //Maiusculo:205 Minusculo:237
        //String palavra = "óôõÓÔÕ";           //Maiusculo:211-213 Minusculo:243-245
        //String palavra = "úÚ";                 //Maiusculo:218 Minusculo:250
        String palavra = "àáâãÀÁÂÃéêÉÊíÍóôõÓÔÕúÚ";
        String palavraMascarada = "";
        char[] palavraArray = palavra.toCharArray();
        System.out.println(StringUtil.mascararTexto(palavra));

    }
}
