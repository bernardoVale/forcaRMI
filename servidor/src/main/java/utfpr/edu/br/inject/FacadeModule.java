package utfpr.edu.br.inject;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 23/09/12
 * Time: 14:05
 */

import com.google.inject.AbstractModule;
import utfpr.edu.br.facade.*;

/**
 * @author Bernardo Vale
 */
public class FacadeModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(JogadorFacade.class).to(JogadorFacadeImpl.class);
        bind(JogoFacade.class).to(JogoFacadeImpl.class);
        bind(PalavraFacade.class).to(PalavraFacadeImpl.class);
    }
}
