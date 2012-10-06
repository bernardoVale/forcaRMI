package utfpr.edu.br.presenter.strategy;

import utfpr.edu.br.dto.JogoAtivoDTO;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 05/10/12
 * Time: 19:51
 */
public interface JogadaStrategy {

    public JogoAtivoDTO efetuarJogada(JogoAtivoDTO jogo);

}