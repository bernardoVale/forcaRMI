package utfpr.edu.br.presenter.template.atualizarTela;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 14/10/12
 * Time: 18:18
 */

/**
 * @author Bernardo Vale
 */
public class AtualizarPalavraErrada extends AtualizarTelaTemplate{
    @Override
    protected void atualizarPlacar() {
        presenter.atualizarPlacar(atual);
    }

    @Override
    protected void atualizarLetrasErradas() {

    }

    @Override
    protected void atualizarPalavraPopulada() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void atualizarForca() {
        presenter.atualizarForca(atual);
    }
}
