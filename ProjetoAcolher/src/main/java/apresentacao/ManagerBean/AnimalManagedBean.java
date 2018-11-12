/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.ManagerBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import negocio.entidade.Animal;
import negocio.fachada.AnimalFachada;


/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "animalManagedBean")
@SessionScoped
public class AnimalManagedBean {  

    private Animal animal = new Animal();
    private List<Animal> Animais;
    private List<Animal> AnimaisFiltro;

    @EJB
    private AnimalFachada animalFachada;

    public AnimalManagedBean() {
    }

    public String montarPaginaParaInsercao() {
        this.setAnimal(new Animal());        
        return "/Animal/InserirAnimal?faces-redirect=true";
    }
    
    public String montarPaginaParaAlteracao() {
        return "/Animal/AlterarAnimal?faces-redirect=true";
    }

    public String Inserir() {
        getAnimalFachada().Inserir(getAnimal());
        this.recuperarAnimais();
        return "/Animal/ListarAnimais?faces-redirect=true";
    }
    
    public String Alterar() {
        getAnimalFachada().Alterar(getAnimal());
        this.recuperarAnimais();
        return "/Animal/ListarAnimais?faces-redirect=true";
    }

    private void recuperarAnimais() {
        List<Animal> animaisListados = getAnimalFachada().Listar();
        setAnimais(animaisListados);
        this.setAnimaisFiltro(animaisListados);
    }

    public String listar() {
        this.recuperarAnimais();
        return "/Animal/ListarAnimais?faces-redirect=true";
    }

    /**
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * @return the Animais
     */
    public List<Animal> getAnimais() {
        return Animais;
    }

    /**
     * @param Animais the Animais to set
     */
    public void setAnimais(List<Animal> Animais) {
        this.Animais = Animais;
    }

    /**
     * @return the AnimaisFiltro
     */
    public List<Animal> getAnimaisFiltro() {
        return AnimaisFiltro;
    }

    /**
     * @param AnimaisFiltro the AnimaisFiltro to set
     */
    public void setAnimaisFiltro(List<Animal> AnimaisFiltro) {
        this.AnimaisFiltro = AnimaisFiltro;
    }

    /**
     * @return the animalFachada
     */
    public AnimalFachada getAnimalFachada() {
        return animalFachada;
    }

    /**
     * @param animalFachada the animalFachada to set
     */
    public void setAnimalFachada(AnimalFachada animalFachada) {
        this.animalFachada = animalFachada;
    }     
   
}

