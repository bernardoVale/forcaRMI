package utfpr.edu.br.presenter.template.efetuarJogada;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 05/10/12
 * Time: 20:07
 */

import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.dto.PalavraDTO;
import utfpr.edu.br.presenter.JogoPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */

public abstract class EfetuarJogadaTemplate{
    protected int atual; //1=Jogador1 2=Jogador2
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
        pegaJogadorAtual();
        preEfetuarJogada();
        passarVez();
        mudarPalavraPopulada();
        adicionarErro();
        adicionarLetrasErradas();
        atualizarPontuacao();
        verificaVitoria();
        verificaDerrota();
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
    //Verica qual jogador no JogoAtivoDTO e o jogador que esta na tela
    protected void pegaJogadorAtual(){
        if(jogo.getJogador1().getJogador().getId().equals(presenter.getView().jogador().getId())){
            atual = 1;
        }else{
            atual = 2;
        }
    }
    protected void atualizarPontuacao(){
       presenter.atualizarPlacar(atual);
    }


    /**
     * Jogador acertou a palavra, limparemos agora os dados remanentes da ultima partida
     */
    protected void limparDadosJogo() {
        jogo.getJogador1().setQuantidadeErros(0);
        jogo.getJogador2().setQuantidadeErros(0);
        jogo.setLetrasErradas(new ArrayList<String>());
        presenter.atualizarForca(atual);
        presenter.atualizarLetrasErrada();
    }

    protected abstract void preEfetuarJogada();
    protected abstract void mudarPalavraPopulada();
    protected abstract void adicionarErro();
    protected abstract void adicionarLetrasErradas();
    protected abstract void verificaVitoria();
    protected abstract void verificaDerrota();
}
