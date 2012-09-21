package utfpr.edu.br.inject;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 18:11
 */

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * @author Bernardo Vale
 * Classe para iniciar todos os servicos da aplicacao,no meu caso so o eclipselink
 */
public class AppInitializer {
    @Inject
    AppInitializer(PersistService persistenceService) {
        // start JPA
        persistenceService.start();
    }
}
