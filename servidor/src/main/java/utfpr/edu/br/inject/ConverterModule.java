package utfpr.edu.br.inject;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 21/09/12
 * Time: 20:52
 */

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import utfpr.edu.br.converter.AbstractConverter;
import utfpr.edu.br.converter.CategoriaConverter;
import utfpr.edu.br.converter.JogadorConverter;
import utfpr.edu.br.converter.JogoConverter;
import utfpr.edu.br.dto.CategoriaDTO;
import utfpr.edu.br.dto.JogadorDTO;
import utfpr.edu.br.dto.JogoDTO;
import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.Jogador;
import utfpr.edu.br.model.bean.Jogo;

/**
 * @author Bernardo Vale
 */
public class ConverterModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(new TypeLiteral<AbstractConverter<Jogador,JogadorDTO>>(){
        }).to(JogadorConverter.class);
        bind(new TypeLiteral<AbstractConverter<Jogo,JogoDTO>>(){
        }).to(JogoConverter.class);
        bind(new TypeLiteral<AbstractConverter<Categoria,CategoriaDTO>>(){
        }).to(CategoriaConverter.class);

    }
}
