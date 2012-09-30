package utfpr.edu.br;

import java.io.Serializable;

/**
 * Classe de retorno para todas as requisições que necessitam resposta de validação
 *
 * @author Bernardo Vale
 */
public class RetornoValidacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean ok;
    private String erro;
    private String md5;
    private Object objeto;

    public RetornoValidacao(boolean ok, String erro) {
        super();
        this.ok = ok;
        this.setErro(erro);
    }
    public RetornoValidacao(boolean ok, String erro,Object objeto) {
        super();
        this.ok = ok;
        this.setErro(erro);
        this.objeto = objeto;
    }

    /**
     * Construtor para quando nenhum erro é encontrado.
     * Ok = true
     */
    public RetornoValidacao() {
        this.ok = true;
    }

    /**
     * Construtor para setar o ok sem precisar de setar uma String de erro
     * @param ok
     */
    public RetornoValidacao(boolean ok){
        this.ok = ok;
    }
    /**
     * seta os erros e automaticamente seta o boolean "ok" para false;
     */
    public RetornoValidacao(String erro) {
        this.setErro(erro);
        this.ok = false;
    }

    public RetornoValidacao(Object objeto) {
        this.objeto = objeto;
        this.ok = true;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getStream() {
        return md5;
    }

    public void setStream(String md5) {
        this.md5 = md5;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}