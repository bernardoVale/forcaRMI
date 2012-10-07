package utfpr.edu.br.util;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 07/10/12
 * Time: 18:39
 */
public class GetImagemForca {

    public ImageIcon getImagem(int erros){
        ImageIcon retorno = new ImageIcon(getClass().getResource("/erro_0.png"));
        switch (erros){
            case 0:
                retorno = new ImageIcon(getClass().getResource("/erro_0.png"));
                break;
            case 1:
                retorno = new ImageIcon(getClass().getResource("/erro_1.png"));
                break;
            case 2:
                retorno = new ImageIcon(getClass().getResource("/erro_2.png"));
                break;
            case 3:
                retorno = new ImageIcon(getClass().getResource("/erro_3.png"));
                break;
            case 4:
                retorno = new ImageIcon(getClass().getResource("/erro_4.png"));
                break;
            case 5:
                retorno = new ImageIcon(getClass().getResource("/erro_5.png"));
                break;
        }
        return  retorno;
    }

}
