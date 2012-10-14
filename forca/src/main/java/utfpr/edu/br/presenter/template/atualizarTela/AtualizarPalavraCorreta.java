package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 13/10/12
 * Time: 13:47
 */

/**
 * @author Bernardo Vale
 */
public class AtualizarPalavraCorreta extends AtualizarTelaTemplate{
    @Override
    protected void atualizarPlacar() {
        presenter.atualizarPlacar(atual);
    }

    @Override
    protected void atualizarLetrasErradas() {
        presenter.atualizarLetrasErrada();
    }

    @Override
    protected void atualizarPalavraPopulada() {
        presenter.popularNovaPalavra();
    }
    @Override
    protected void atualizarForca() {
        presenter.atualizarForca(atual);
    }
}
