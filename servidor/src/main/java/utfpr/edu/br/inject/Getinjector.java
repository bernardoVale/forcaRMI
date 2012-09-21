package utfpr.edu.br.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 18:30
 */
public class Getinjector {
    protected static Getinjector ourInstance = new Getinjector();
    protected static Injector injector;

    public static Injector getInstance() {
        if(injector==null){
            //Cria DI para todos os modulos do Guice
            injector = Guice.createInjector(new JpaPersistModule("forcaRMI"), new ControllerModule());
            //Essa classe starta o servico do JPA, aqui inicia o banco!
            injector.getInstance(AppInitializer.class);
        }
        return injector;
    }
}
