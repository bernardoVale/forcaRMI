package utfpr.edu.br.rmi;

import utfpr.edu.br.RmiProvider;
import utfpr.edu.br.util.Properties;
import utfpr.edu.br.view.ServidorView;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Servidor {

    private Registry registry;
    private static final int PORTA = 1099;
    public void inicia() {
        try {
            RmiProvider provider = new RmiProviderImpl();
            registry = LocateRegistry.createRegistry(PORTA);
            registry.rebind("ForcaRMIService", provider);
            ServidorView.addLog("Servidor executando servico " + Properties.SERVICO.nome() + " na porta " + PORTA);

            /*RetornoValidacao r = provider.autenticarJogador("Tiao Bengalao", Md5.MD5("Tiao Bengalao"));

            if(r.isOk()){
                ServidorView.addLog("Jogador inserido!");
            }else{
                ServidorView.addLog(r.getErro());
            } */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
