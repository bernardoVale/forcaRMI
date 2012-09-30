package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 28/09/12
 * Time: 19:55
 */

import utfpr.edu.br.rmi.RMIClient;

import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class AdversarioThread implements Runnable{
    private Thread t;
    protected boolean keepCalm = true;
    private int cont=0;
    public AdversarioThread() {
        t = new Thread(this);
        t.start();
    }

    public synchronized void setKeepCalm(boolean keepCalm) {
        this.keepCalm = keepCalm;
    }

    public synchronized boolean isKeepCalm() {
        return keepCalm;
    }
    @Override
    public void run() {
        while (isKeepCalm()){
            try {
                cont++;
                RMIClient.getInstance().provider().mensagem("Bernardo");
                t.sleep(1000);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
    public int getCont(){
        return cont;
    }
}
