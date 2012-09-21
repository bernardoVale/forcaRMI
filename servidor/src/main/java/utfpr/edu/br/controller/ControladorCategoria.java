package utfpr.edu.br.controller;

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.model.bean.Categoria;

/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 15:14
 */
public interface ControladorCategoria {
   public RetornoValidacao salvar(Categoria c);
}