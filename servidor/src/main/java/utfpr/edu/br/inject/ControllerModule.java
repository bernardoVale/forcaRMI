package utfpr.edu.br.inject;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 13/09/12
 * Time: 10:32
 */

import com.google.inject.AbstractModule;
import utfpr.edu.br.controller.ControladorCategoria;
import utfpr.edu.br.controller.ControladorJogador;
import utfpr.edu.br.controller.ControladorJogo;

/**
 * @author Bernardo Vale
 * Modulo onde dou bind nos controladores
 */
public class ControllerModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(ControladorCategoria.class);
        bind(ControladorJogo.class);
        bind(ControladorJogador.class);
    }
}
