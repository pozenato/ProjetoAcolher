/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.fachada;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import negocio.entidade.Adocao;
import negocio.persistencia.AdocaoDAO;

/**
 *
 * @author Rodrigo
 */
@Stateless
public class AdocaoFachada {
    @EJB
    private AdocaoDAO adocaoDAO;
    
    @EJB
    private PessoaFachada pessoaFachada;
    
    @EJB
    private AnimalFachada animalFachada;
    
    public void Inserir(Adocao adocao){
        adocao.setDataadocao(new Date());
        this.getAnimalFachada().DesabilitarAnimal(adocao.getIdanimal());
        adocaoDAO.Inserir(adocao);
    }
    
    public void Alterar(Adocao adocao){
        adocaoDAO.Alterar(adocao);
    }
    
    public List<Adocao> Listar (){
        return adocaoDAO.RecuperarTodos();        
    }

    public void DesabilitarPessoa(Adocao adocao) {
        this.adocaoDAO.DesabilitarPessoa(adocao);
    }

    /**
     * @return the pessoaFachada
     */
    public PessoaFachada getPessoaFachada() {
        return pessoaFachada;
    }

    /**
     * @param pessoaFachada the pessoaFachada to set
     */
    public void setPessoaFachada(PessoaFachada pessoaFachada) {
        this.pessoaFachada = pessoaFachada;
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
