package utfpr.edu.br.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.MissingResourceException;
import java.util.Properties;

public class ForcaRMIPropriedades {

	public static final String FORCA_PROPERTIES = "/sistema.properties";

	private Properties properties = null;
	private String arquivoProperties = null;
	private static ForcaRMIPropriedades instance;
	
	
	private ForcaRMIPropriedades(){
	}
	
	
	public static final synchronized ForcaRMIPropriedades getInstance()
	{
		if(instance == null)
		{
			instance = new ForcaRMIPropriedades();
			instance.setProperties(new Properties());
			instance.setArquivoProperties(FORCA_PROPERTIES);
			try
			{
				InputStream input = ForcaRMIPropriedades.class.getResourceAsStream(instance.getArquivoProperties());
				instance.getProperties().load(input);
				instance.verificarPropriedades();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/**
	 * Verifica as propriedades setando um valor padrão caso elas sejam nulas.
	 * 
	 * TODA propriedade deve ter um if implementado, senão pode dar nullpointer em outras partes da aplicação.
	 */
	private void verificarPropriedades() throws Exception
	{
		Class<?> clazz = Configuracoes.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields)
		{
			if(field.isAnnotationPresent(ValorDefault.class))
			{
				try
				{
					Configuracoes conf = Configuracoes.valueOf(field.getName());
					if(get(conf) == null)
						set(conf, field.getAnnotation(ValorDefault.class).value());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Método privado. Retorna o valor de uma propriedade.
	 */
	private String getString(String key)
	{
		try
		{
			return properties.getProperty(key);
		}
		catch(MissingResourceException e)
		{
			e.printStackTrace();
			return '!' + key + '!';
		}
	}
	
	/**
	 * Retorna o valor inteiro de uma propriedade.
	 * 
	 * @param configuracao
	 * @return o valor inteiro relativo a propriedade passada. Se houver problema na conversão para int retorna 0.
	 */
	public int getInt(Configuracoes configuracao)
	{
		int num = 0;
		try
		{
			num = Integer.parseInt(getString(configuracao.getNome()));
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
		return num;
	}
	
	
	/**
	 * Método publico e estatico que chama o metodo para pegar o valor de uma propriedade.
	 */
	public String get(Configuracoes configuracao)
	{
		return getString(configuracao.getNome());
	}
	
	/**
	 * Método privado. Seta um valor a uma propriedade.
	 */
	private void setProperty(String key, String value) throws Exception
	{

        try{
        properties.setProperty(key, value);
		
		FileOutputStream fos = new FileOutputStream(arquivoProperties);
		
		properties.store(fos, null);
		fos.close();
        }catch (FileNotFoundException e){
            System.out.println("Arquivo de properties nao encontrado");
        }
	}
	
	/**
	 * Metodo publico e estatico, que chama outro metodo para setar um valor a uma configuração nas propriedades.
	 */
	public void set(Configuracoes configuracao, String valor) throws Exception
	{
		setProperty(configuracao.getNome(), valor);
	}
	
	public Properties getProperties()
	{
		return properties;
	}
	
	public void setProperties(Properties properties)
	{
		this.properties = properties;
	}
	
	public String getArquivoProperties()
	{
		return arquivoProperties;
	}
	
	public void setArquivoProperties(String arquivoProperties)
	{
		this.arquivoProperties = arquivoProperties;
	}
	
	@Override
	public String toString()
	{
		return "TestePropriedades [arquivoProperties=" + arquivoProperties + "]";
	}
	
}
