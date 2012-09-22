package utfpr.edu.br;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 16/09/12
 * Time: 19:58
 */

import utfpr.edu.br.converter.JogadorConverter;
import utfpr.edu.br.inject.Getinjector;
import utfpr.edu.br.model.bean.Jogador;
import utfpr.edu.br.model.dao.JogadorDao;

/**
 * @author Bernardo Vale
 */
public class Teste {
    public static void main(String[] args) {
        //Getinjector.getInstance().getInstance(JogadorDao.class).save(new Jogador("joao"));
        Jogador j = Getinjector.getInstance().getInstance(JogadorDao.class).findByNome("joao");
        JogadorConverter cv = new JogadorConverter();
        System.out.println(cv.toDTO(j).toString());
    }
}
