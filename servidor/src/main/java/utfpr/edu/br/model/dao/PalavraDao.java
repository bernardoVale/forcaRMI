package utfpr.edu.br.model.dao;/**
 * Created with IntelliJ IDEA.
 * User: bernardo
 * Date: 19/09/12
 * Time: 20:09
 */

import utfpr.edu.br.model.bean.Categoria;
import utfpr.edu.br.model.bean.Palavra;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bernardo Vale
 */
public class PalavraDao extends AbstractDao<Palavra>{

    @Inject
    public PalavraDao(Provider<EntityManager> emp) {
        super(emp,Palavra.class);
    }

    /**
     * Retorna uma lista de palavras que constam num determinado Jogo
     * @param jogo_id O Jogo em questao
     * @return  A lista
     */
    public List<Palavra> getPalavrasDoJogo(Long jogo_id){
        return em().createQuery("Select p from Palavra p,PalavrasDoJogo pj where p.id=pj.id.palavra_id" +
                " and pj.id.jogo_id=?1",Palavra.class).setParameter(1,jogo_id).getResultList();
    }
    /**
     * Me retorna um Array de palavra que serao usadas num determinado jogo.
     * obs: As palavras NUNCA se repetiram naquele jogo.
     * @param categoria   Categoria da palavra
     * @param rodadas     Quantidade de rodadas, ou seja, num de palavras q vou enviar
     * @return
     */
    public List<Palavra> getPalavrasSorteadas(Categoria categoria,int rodadas,String dificuldade){
        int max = 0;
        int min = 0;
        if(dificuldade.equals("Fácil")){
           max = 5;
        }else{
            if(dificuldade.equals("Normal")){
                max = 8;
                min = 6;
            }else{
                if(dificuldade.equals("Magayver")){
                     max = 12;
                     min = 9;
                }else{
                    if(dificuldade.equals("Filho de Osíris")){
                       min = 13; //Aqui o cara e fera d+
                       max = 99;
                    }
                }
            }
        }
        Long codigos[] = new Long[rodadas];//Vetor para adicionar os codigos sorteados
        int cont=0;//variavel para verificar se tinha codigo igual no sorteio
        List<Palavra> palavras = new ArrayList<Palavra>();
        for(int i=0;i<rodadas;i++){
            codigos[i] = 0L; //inicializo o vetor
        }
        Long totalPalavras = (Long) em().createQuery("SELECT count(p) from Palavra p where p.categoria = ?1")
                .setParameter(1,categoria).getSingleResult();
        for(int i=1;i<=rodadas;i++){//sorteia um numero na range dos codigos q existem no banco e add na lista
            cont = 0;
            Random codigo = new Random();  //SOMA E SUBTRAÇAO PARA N ACHAR VALOR 0
            Long id = new Long(codigo.nextInt(totalPalavras.intValue())+1);
            for(int j=0;j<rodadas;j++){
                if(codigos[j].equals(id)){ //pra nao sortear palavras iguais
                    cont++;
                }
            }
            if(cont==0){

                Palavra p = this.findByID(id);
                if(!verificaDificuldade(max,min,p)){
                    i--;
                }else{
                    codigos[i-1] = id;
                    palavras.add(p);
                }
            }else{ //tem que sortear de novo
                i = i-1;
            }
        }
        return palavras;
    }

    private boolean verificaDificuldade(int max, int min, Palavra p) {
        char[] palavra = p.getNome().toCharArray();
        return palavra.length <= max && palavra.length >= min;
    }
}
