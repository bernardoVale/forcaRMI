package utfpr.edu.br.util.session;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 13:42
 */

import utfpr.edu.br.dto.JogoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class JogosSession {
private static List<JogoDTO> jogos;

        public static List<JogoDTO> getJogos() {
            if(jogos==null){
                jogos = new ArrayList<JogoDTO>();
            }
            return jogos;
        }
        private JogosSession() {
        }
}
