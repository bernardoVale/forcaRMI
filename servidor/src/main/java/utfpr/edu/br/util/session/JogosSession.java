package utfpr.edu.br.util.session;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 01/10/12
 * Time: 13:42
 */

import utfpr.edu.br.dto.JogoAtivoDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class JogosSession {
private static List<JogoAtivoDTO> jogos;

        public static List<JogoAtivoDTO> getJogos() {
            if(jogos==null){
                jogos = new ArrayList<JogoAtivoDTO>();
            }
            return jogos;
        }
        private JogosSession() {
        }
}
