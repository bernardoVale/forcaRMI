package utfpr.edu.br.presenter.template;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 05/10/12
 * Time: 20:07
 */

import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.presenter.JogoPresenter;

import java.util.List;

/**
 * @author Bernardo Vale
 */

public abstract class EfetuarJogadaTemplate{
    protected List<Integer> posicoes;
    protected JogoAtivoDTO jogo;
    protected JogoPresenter presenter;
    protected String token;          //O Texto que esta no JTFEnviar
    protected PalavraDTO palavraAtual;    //palavra que estamos brincando
    //boleano para ver se acertou ou errou a palavra. Atualizado no preEfetuar
    protected boolean acertou;

    public void efetuarJogada(JogoPresenter presenter){
        this.jogo = presenter.getView().dadosJogo();
        this.presenter = presenter;
        preEfetuarJogada();
        passarVez();
        mudarPalavraPopulada();
        adicionarErro();
        adicionarLetrasErradas();
    }
    public JogoAtivoDTO getJogo(){
        return jogo;
    }
    /**
     * Todas as classes concetras precisam desse metodo, e todas elas os fazem da mesma formma
     * entao eu faço ele na classe abstrada mesmo.
     */
    protected void passarVez(){
        jogo.getJogador1().setMeuTurno(
                !jogo.getJogador1().isMeuTurno()
        );
        jogo.getJogador2().setMeuTurno(
                !jogo.getJogador2().isMeuTurno()
        );
    }


    protected abstract void preEfetuarJogada();
    protected abstract void mudarPalavraPopulada();
    protected abstract void adicionarErro();
    protected abstract void adicionarLetrasErradas();
}
