package utfpr.edu.br.spring;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 27/09/12
 * Time: 20:16
 */

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Singleton que me devolve a instancia do fabricador de beans do SpringFramework
 * @author Bernardo Vale
 */
public class SpringFactory {

    private static BeanFactory factory;

    public static BeanFactory getFactory(){
         if(factory==null){
             factory = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
         }
         return factory;
    }
}
