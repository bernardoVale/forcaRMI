package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 19:39
 */

import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoAtivoDTO;
import utfpr.edu.br.presenter.template.atualizarTela.AtualizarLetrasCorretas;
import utfpr.edu.br.presenter.template.atualizarTela.AtualizarLetrasErradas;
import utfpr.edu.br.presenter.template.atualizarTela.AtualizarTelaTemplate;
import utfpr.edu.br.presenter.worker.AguardarTurno;
import utfpr.edu.br.presenter.worker.BuscarDadosJogo;
import utfpr.edu.br.presenter.worker.FindAdversario;
import utfpr.edu.br.util.GetImagemForca;
import utfpr.edu.br.view.action.MascararTextoActionListener;
import utfpr.edu.br.view.action.RealizarJogadaActionListener;
import utfpr.edu.br.view.telas.jogo.JogoView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernardo Vale
 */
public class JogoPresenter {
    private JogoView jogoView;

    public JogoPresenter() {
    }

    public void createView(JogadorDTO jogador) {
        this.setUpViewListeners();
        jogoView.packAndShow(jogador);
        moldarTelaInicial();
        aguardarAdversario();
    }
    /**
     * Metodo inicial da tela, onde o jogador aguarda o oponente
     */
    public void moldarTelaInicial(){
        jogoView.P1_nome().setText(jogoView.jogador().getNome());
        jogoView.lbPontuacaoP1().setVisible(false);
        jogoView.lbPontuacaoP2().setVisible(false);
        jogoView.pLetrasErradas().setVisible(false);
        jogoView.lbX().setVisible(false);
        jogoView.lbCarregando().setVisible(true);
        jogoView.lbPlacar().setBounds(370, 74, 288, 73);
        jogoView.lbPlacar().setText("Aguardando Oponente...");
        jogoView.lbPlacar().setFont(new Font("Tahoma", 0, 23));
        jogoView.pEnviar().setVisible(false);
    }
    public void aguardarAdversario(){
        FindAdversario f = new FindAdversario(jogoView,this);
        try {
            f.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void buscarDadosDoJogo() {
        BuscarDadosJogo worker = new BuscarDadosJogo(jogoView,this);
        try {
            worker.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public void aguardarTurno(){
        getView().pEnviar().setVisible(false);
        AguardarTurno worker = new AguardarTurno(this);
        try{
            worker.execute();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void verificarTurno(){
        if(getView().dadosJogo().getJogador1().getJogador().getId().equals(getView().jogador().getId())){
            if(!getView().dadosJogo().getJogador1().isMeuTurno()){
                aguardarTurno();
            }
        }else {
            if(!getView().dadosJogo().getJogador2().isMeuTurno()){
               aguardarTurno();
            }
        }
    }
    //Adiciona os listeners
    public void setUpViewListeners() {
        jogoView.addChutarLetraListener(new RealizarJogadaActionListener(this));
        jogoView.addMascaraTextoListener(new MascararTextoActionListener(this));
    }

    public JogoView getView() {
        return jogoView;
    }

    public void setJogoView(JogoView jogoView) {
        this.jogoView = jogoView;
    }

    public void atualizaPosicoesPalavra(List<Integer> posicoes,String letra){
        int cont = 0;
        List<JLabel> letrasLabel = new ArrayList<JLabel>();
        for(int j=0;j<jogoView.palavraAtualPopulada().size();j++){
            //Verifica se tem asterisco, se n tiver tem q deixar com estava,ou seja, add de novo
            if(jogoView.palavraAtualPopulada().get(j).getText().contains("*")){
                //verifica em todas os encontros da letra se e igual a posicao que esta na palavra
                for(int i=0;i<posicoes.size();i++){
                    //se for igual adiciona naquele lugar a letra
                    if(posicoes.get(i)==j){
                        //Agora verifica se tem acento
                        JLabel letraNova = new JLabel();
                        letraNova.setFont(new Font("Tahoma",0,50));
                        letraNova.setText("<html><u>"+pegaLetraNaoMascarada(j)+"</u><html>");
                        letrasLabel.add(letraNova);
                    }else{
                        //Esse contador serve para verificar se
                        cont++;
                    }
                }
            }else {
                letrasLabel.add(jogoView.palavraAtualPopulada().get(j));
            }
            if(cont==posicoes.size()){
                JLabel letraNova = new JLabel();    //adiciona asterisco
                letraNova.setFont(new Font("Tahoma",0,50));
                letraNova.setText("<html><u>*</u><html>");
                letrasLabel.add(letraNova);
            }
            cont = 0;
        }
        //Pede para adicionar novamente uma lista de labels no painel palavra
        popularPalavraNovamente(letrasLabel);
    }

    /**
     * Jogador ja acertou a palavra. So populo a palavra sem a mascara no JPanel!
     */
    public void atualizaPalavraCerta(){
        List<JLabel> letrasLabel = new ArrayList<JLabel>();
        char[] array = jogoView.palavras().get(jogoView.rodadaAtual()-1).getNome()
                .toUpperCase().toCharArray();
        for(int j=0;j<jogoView.palavraAtualPopulada().size();j++){
            JLabel letraNova = new JLabel();
            letraNova.setFont(new Font("Tahoma",0,50));
            letraNova.setText("<html><u>"+array[j]+"</u><html>");
            letrasLabel.add(letraNova);
        }
        popularPalavraNovamente(letrasLabel);
    }
    public void popularPalavraNovamente(List<JLabel> letrasLabel){
        //Remove tudo e atualiza a tela
        jogoView.pLetras().removeAll();
        jogoView.pLetras().revalidate();
        jogoView.root().validate();
        //For que adiciona tudo de novo e atualiza a tela
        for (JLabel jLabel : letrasLabel) {
            System.out.println(jLabel.getText());
             jogoView.pLetras().add(jLabel);
             jogoView.pLetras().revalidate();
             jogoView.root().validate();
        }
        //Atualiza a lista para a proxima letra ;)
        jogoView.setPalavraAtualPopulada(letrasLabel);
    }

    /**
     * Metodo que pega a letra nao mascarada, em caso de acentos esse metodo teve de ser implementado
     * @param posicao Local no qual se encontra a letra                                                  new FlowLayout(FlowLayout.CENTER, 5, 5)
     * @return   Letra nao mascarada
     */
    private String pegaLetraNaoMascarada(int posicao) {
        String letraNaoMascarada =
                jogoView.palavras().get(jogoView.rodadaAtual()-1).getNome().substring(posicao, posicao+1);
        System.out.println("Mascarada:"+letraNaoMascarada);
        return letraNaoMascarada.toUpperCase();
    }

    public void atualizarTela(JogoAtivoDTO atualizado) {
        AtualizarTelaTemplate t = null;
        if(!atualizado.getLetrasErradas().equals(jogoView.dadosJogo().getLetrasErradas())){
            t = new AtualizarLetrasErradas();

        }else{
            if(!atualizado.getPalavraAtualPopulada().equals(jogoView.dadosJogo().getPalavraAtualPopulada())){
                t = new AtualizarLetrasCorretas();
            }
        }
        jogoView.setDadosJogo(atualizado);
        jogoView = t.atualizarTela(this);
    }
    public void atualizarForca(int atual){
        if(atual==1){
            getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                    getView().dadosJogo().getJogador1().getQuantidadeErros()
            ));
            getView().lbErroJogador2().setIcon(new GetImagemForca().getImagem(
                    getView().dadosJogo().getJogador2().getQuantidadeErros()
            ));
        }else{
            getView().lbErroJogador1().setIcon(new GetImagemForca().getImagem(
                    getView().dadosJogo().getJogador2().getQuantidadeErros()
            ));
            getView().lbErroJogador2().setIcon(new GetImagemForca().getImagem(
                    getView().dadosJogo().getJogador1().getQuantidadeErros()
            ));
        }
        getView().pJogador1().revalidate();
        getView().pJogador2().revalidate();
        getView().root().validate();
    }
    /*
    * Atualiza o painel de letras erradas mediante ao JogoAtivoDTO
     */
    public void atualizarLetrasErrada() {
        List<String> pErradas = getView().dadosJogo().getLetrasErradas();
        //Remove tudo e atualiza a tela
        jogoView.pLetrasErradas().removeAll();
        jogoView.pLetrasErradas().revalidate();
        jogoView.root().validate();
        for(int i=0;i< pErradas.size();i++){
          JLabel letra = new JLabel(pErradas.get(i));
          letra.setFont(new Font("SansSerif", Font.BOLD, 73));
          jogoView.pLetrasErradas().add(letra);
          jogoView.pLetrasErradas().revalidate();
          jogoView.root().validate();
        }
    }
}
