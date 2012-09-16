package utfpr.edu.br;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RmiProvider provider;
        try {
            provider = (RmiProvider) Naming.lookup("rmi://localhost:1099/ForcaRMIService");
            System.out.println(provider.mensagem("Filho da puta viadinho"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
