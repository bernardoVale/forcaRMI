package utfpr.edu.br.util.session;

import utfpr.edu.br.dto.JogadorDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 26/09/12
 * Time: 17:16
 */
public class JogadoresSession {
    private static JogadoresSession ourInstance = new JogadoresSession();
    private static List<JogadorDTO> jogadores;

    public static List<JogadorDTO> getJogadores() {
        if(jogadores==null){
            jogadores = new ArrayList<JogadorDTO>();
        }
        return jogadores;
    }
    private JogadoresSession() {
    }
}
