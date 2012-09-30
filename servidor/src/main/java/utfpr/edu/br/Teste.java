package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.dao.JogadoresDoJogoDao;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        Long adversario = 0L;
        JogadoresDoJogoDao dao =  Getinjector.getInstance().getInstance(JogadoresDoJogoDao.class);
        adversario = dao.idAdversario(35L,1L);
        if(adversario==0){
            System.out.println("coco");
        }else{
            System.out.println("Ad"+adversario);
        }
    }

}
