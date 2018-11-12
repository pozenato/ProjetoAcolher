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
import negocio.entidade.Animal;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class AnimalDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void Inserir(Animal animal) {
        em.persist(animal);
    }
    
    public void Alterar(Animal animal) {
        em.merge(animal);
    }
    
    public List<Animal> RecuperarTodos(){
         return em.createQuery("select a from Animal as a order by a.idanimal").getResultList();
    }
    
    public List<Animal> RecuperarAnimaisAtivos(){
         return em.createQuery("select a from Animal as a Where a.status = true order by a.idanimal").getResultList();
    }
    
    public void DesabilitarAnimal (Animal animal){
        animal.setStatus(false);
        em.merge(animal);
    }
    
    public Animal recuperarPorId(Integer id) {
        return em.find(Animal.class, id);
    }

}
