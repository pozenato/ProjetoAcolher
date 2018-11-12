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
import negocio.entidade.Pessoa;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class PessoaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void Inserir(Pessoa pessoa) {
        em.persist(pessoa);
    }
    
    public void Alterar(Pessoa pessoa) {
        em.merge(pessoa);
    }
    
    public List<Pessoa> RecuperarTodos(){
         return em.createQuery("select p from Pessoa as p order by p.idpessoa").getResultList();
    }
    
    public List<Pessoa> RecuperarPessoasAtivas(){
         return em.createQuery("select p from Pessoa as p Where p.status = true order by p.idpessoa").getResultList();
    } 
    
    public Pessoa recuperarPorId(Integer id) {
        return em.find(Pessoa.class, id);
    }
    
    public void DesabilitarPessoa (Pessoa pessoa){
        em.merge(pessoa);
    }

}
