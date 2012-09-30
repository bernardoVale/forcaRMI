package utfpr.edu.br.controller;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 23/09/12
 * Time: 11:22
 */

import utfpr.edu.br.RetornoValidacao;
import utfpr.edu.br.converter.AbstractConverter;
import utfpr.edu.br.dto.DTO;
import utfpr.edu.br.model.bean.IBean;
import utfpr.edu.br.model.dao.AbstractDao;
import utfpr.edu.br.util.Erros;

import javax.persistence.NoResultException;

/**
 * @author Bernardo Vale
 */
public abstract class AbstractControlador<T extends IBean,O extends DTO, D extends AbstractDao<T>>
{
    private final D dao;
    private final Class<T> clazz;
    private final AbstractConverter<T,O> converter;

    /**
     * Mesmo caso do Dao, tem que tirar o clazz e colocar a classe manualmente
     * @param dao
     * @param clazz
     * @param converter
     */
    public AbstractControlador(D dao, Class<T> clazz, AbstractConverter<T, O> converter) {
        this.dao = dao;
        this.clazz = clazz;
        this.converter = converter;
    }
    public RetornoValidacao findByKey(String key,String keyValue){
        try{
            return new RetornoValidacao(converter.toDTO(dao.findByKeyAtribute(key,keyValue)));
        }
        catch (NoResultException e){
            e.printStackTrace();
            return new RetornoValidacao(Erros.DADOSNAOENCONTRADOS.nome());
        }catch (Exception e){
            e.printStackTrace();
            return new RetornoValidacao(Erros.PERSISTENCIA.nome());
        }
    }

    /**
     * Retorna o dto do camarada passando o id
     * @param id
     * @return
     */
    public RetornoValidacao findById(Long id){
        try{
            return new RetornoValidacao(converter.toDTO(dao.findByID(id)));
        }
        catch (NoResultException e){
            System.out.println("NoResult");
            return new RetornoValidacao(Erros.DADOSNAOENCONTRADOS.nome());
        }catch (Exception e){
            System.out.println("NoResultexxx");
            e.printStackTrace();
            return new RetornoValidacao(Erros.PERSISTENCIA.nome());
        }
    }
    /**
     * Salva um objeto e commita.
     *
     * @param bean
     */
    public RetornoValidacao save(T bean)
    {
        try
        {
            return new RetornoValidacao(converter.toDTO(dao.save(bean)));

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new RetornoValidacao(Erros.PERSISTENCIA.nome());
    }
    public RetornoValidacao lista(){
        try{
            return new RetornoValidacao(converter.toDTOList(dao.findAll()));
        }catch (Exception e){
            return new RetornoValidacao(Erros.PERSISTENCIA.nome());
        }
    }
}
