package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 08/10/12
 * Time: 10:39
 */

/**
 * @author Bernardo Vale
 */
public class AtualizarLetrasCorretas extends AtualizarTelaTemplate{

    @Override
    protected void atualizarPlacar() {
        presenter.atualizarPlacar(atual);
    }

    @Override
    protected void atualizarLetrasErradas() {
        //o cara acertou, se liga!
    }

    @Override
    protected void atualizarPalavraPopulada() {
       presenter.popularPalavraNovamente(presenter.getView().dadosJogo().getPalavraAtualPopulada());

    }

    @Override
    protected void atualizarForca() {
        //se acertastes como vou atualizar forca?
    }
}
