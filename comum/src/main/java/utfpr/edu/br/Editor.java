package utfpr.edu.br;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Singleton responsavel por adicionar log's da aplicação de imprimir no console
 * 
 * @author Bernardo Vale
 *
 */
public class Editor implements Serializable{
	

	private static final long serialVersionUID = 1L;

	/**
	 * String Builder que armazena os "log's" em forma de texto formatado de toda a aplicação
	 */
	public StringBuilder str;
	
	private static Editor instance;
	
	private Editor(){
		str = new StringBuilder();
	}
	
	public static final Editor getInstance(){
	
		if(instance == null)
		{
			instance = new Editor();
		}
		return instance;
	}

	/**
	 * Metodo responsavel por adicionar log's ao buffer de logs ja existente
	 *
     * @param str
	 */
	public void add(String str) {
		this.str.append("["+getHorario()+"]>> " + str + "\n");
	}
	
	
	/**
	 * Retorna o buffer de todos os logs para o console
	 * 
	 * @return log's
	 */
	public String getStr() {
		return str.toString();
	}

    /**
     * Retorna o horario do log
     *
     * @return horario
     */
    public String getHorario(){
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        return format.format(Calendar.getInstance().getTime());
    }
		
}
