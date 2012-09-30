package utfpr.edu.br.presenter;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 28/09/12
 * Time: 21:14
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.rmi.RMIClient;

import java.rmi.RemoteException;

/**
 * @author Bernardo Vale
 */
public class MyThread extends Thread{
    public int count;
    protected JogadorDTO jogadorDTO;
    protected RetornoValidacao rv;

    public MyThread(JogadorDTO jogadorDTO) {
        count = 0;
        this.jogadorDTO = jogadorDTO;
        rv = new RetornoValidacao("Start");
        start();
    }

    public void run() {
        try {
            do {
                rv = RMIClient.getInstance().provider().retornaAdversario(jogadorDTO);
                Thread.sleep(1500);
            } while (!rv.isOk());
        } catch (InterruptedException exc) {
            System.out.println("MyThread interrupted.");
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public synchronized JogadorDTO getAdversario(){
       return (JogadorDTO) rv.getObjeto();
    }
}
