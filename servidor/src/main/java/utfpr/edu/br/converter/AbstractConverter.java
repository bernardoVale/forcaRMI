package utfpr.edu.br.converter;

import utfpr.edu.br.dto.DTO;
import utfpr.edu.br.model.bean.IBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter Abstrato.
 *
 * @author Carlos A Becker
 */
public abstract class AbstractConverter<B extends IBean, D extends DTO> {

  /**
   * Converte de DTO para Bean.
   * @param dto a ser convertido.
   * @return Bean pronto para uso, não gerenciado.
   */
  public abstract B toBean(D dto);

  /**
   * Converte de bean para DTO
   * @param bean a ser convertido
   * @return DTO pronto para uso.
   */
  public abstract D toDTO(B bean);

  /**
   * Converte uma lista de beans para uma lista de DTOs
   *
   * @param beans a serem convertidos
   * @return lista pronta para uso
   */
  public List<D> toDTOList(List<B> beans) {
    List<D> dtos = new ArrayList<D>();
    for (B bean : beans) {
      dtos.add(toDTO(bean));
    }
    return dtos;
  }

  /**
   * Converte uma lista de DTOS para uma lista de Beans
   *
   * @param dtos a serem convertidos
   * @return lista de Beans pronta para uso. Beans não gerenciados.
   */
  public List<B> toBeanList(List<D> dtos) {
    List<B> beans = new ArrayList<B>();
    for (D dto : dtos) {
      beans.add(toBean(dto));
    }
    return beans;
  }

}
