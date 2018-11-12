/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.persistencia;

/**
 *
 * @author Rodrigo
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import negocio.entidade.Adocao;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class AdocaoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void Inserir(Adocao adocao) {
        em.persist(adocao);
    }
    
    public void Alterar(Adocao adocao) {
        em.merge(adocao);
    }
    
    public List<Adocao> RecuperarTodos(){
         return em.createQuery("select a from Adocao as a order by a.idadocao").getResultList();
    } 
    
    public void DesabilitarPessoa (Adocao adocao){
        em.merge(adocao);
    }

}
