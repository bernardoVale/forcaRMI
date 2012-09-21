package utfpr.edu.br.util;

public enum Configuracoes
{
	@ValorDefault("FORCA")
	NOME_BANCO("nomeBanco"),
	
	@ValorDefault("postgres")
	USUARIO_BANCO("usuarioBanco"),
	
	@ValorDefault("postgres")
	SENHA_BANCO("senhaBanco"),
	
	@ValorDefault("localhost")
	HOST_BANCO("hostBanco"),
	
	@ValorDefault("org.hibernate.dialect.PostgreSQLDialect")
	HIBERNATE_DIALECT("hibernate.dialect"),
	
	@ValorDefault("org.postgresql.Driver")
	HIBERNATE_CONNECTION_DRIVER_CLASS("hibernate.connection.driver_class"),
	
	@ValorDefault("5432")
	PORTA_BANCO("portaBanco"),

    @ValorDefault("nao")
    VERSAO_FREE("versaoFree");
	
	private String nome;
	
	private Configuracoes(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome()
	{
		return nome;
	}
}