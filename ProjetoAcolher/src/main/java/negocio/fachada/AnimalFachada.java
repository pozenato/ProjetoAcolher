/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import negocio.entidade.Animal;
import negocio.persistencia.AnimalDAO;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class AnimalFachada {
    @EJB
    private AnimalDAO animalDAO;
    
    public void Inserir(Animal animal){
        animal.setStatus(true);
        animalDAO.Inserir(animal);
    }
    
    public void Alterar(Animal animal){
        animalDAO.Alterar(animal);
    }
    
    public List<Animal> Listar (){
        return animalDAO.RecuperarTodos();        
    }
           
    public List<Animal> ListarAtivos (){
        return animalDAO.RecuperarAnimaisAtivos();        
    }

    public void DesabilitarAnimal(Animal animal) {
        animal.setStatus(false);
        this.animalDAO.DesabilitarAnimal(animal);
    }
    
    public Animal recuperarPorId(Integer id) {
        return animalDAO.recuperarPorId(id);
    }
}
