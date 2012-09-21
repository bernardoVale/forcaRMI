package utfpr.edu.br.rmi;

import utfpr.edu.br.RmiProvider;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 20:29
 */
public class RMIClient {
    private static RMIClient ourInstance;
    private static String ip;
    private static RmiProvider provider;

    public static final RMIClient getInstance() throws RemoteException{
        if(ourInstance == null)
        {
            ourInstance = new RMIClient();
            try {
                provider = (RmiProvider) Naming.lookup("rmi://localhost:1099/ForcaRMIService");
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                JOptionPane.showMessageDialog(null,"Problemas na conexão, tente novamente!",
                        "Erro",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        return ourInstance;
    }

    private RMIClient() {

    }

    public String getIp() {
        //todo Arrumar isso daqui para pegar o ip do server
        return "localhost";
    }
    public RmiProvider provider() {
        return provider;
    }
}
