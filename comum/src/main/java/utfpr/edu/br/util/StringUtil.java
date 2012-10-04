package utfpr.edu.br.util;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 22:25
 */

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Metodo que verifica se existe a letra na palavra
     * @param letra  Letra que o jogador enviou
     * @param palavra Palavra que esta sendo jogada
     * @return Lista com todas as posicoes, ou nenhuma, em que a letra
     * consta na palavra
     */
    public static List<Integer> posicoesIguais(String letra,String palavra){
         List<Integer> posicoes = null;
         char [] letras = palavra.toUpperCase().toCharArray();
         char [] letraChute = letra.toUpperCase().toCharArray();//E uma letra, entao vou comparar sempre na posicao 0
         for(int i=0;i<letras.length;i++){
             if(letras[i]==letraChute[0]){//Se sao iguais eu armazeno a posicao
                 if(posicoes==null){
                 //inicializo o arraylist. Faço isso para o posicoes dar null se o cara errou a letra
                     posicoes = new ArrayList<Integer>();
                 }
                posicoes.add(i);
             }
         }
        return posicoes;
    }

}
