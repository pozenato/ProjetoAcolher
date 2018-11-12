/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao.ManagerBean;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import negocio.entidade.Adocao;
import negocio.entidade.Animal;
import negocio.entidade.Pessoa;
import negocio.fachada.AdocaoFachada;
import negocio.fachada.AnimalFachada;
import negocio.fachada.PessoaFachada;


/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "adocaoManagedBean")
@SessionScoped
public class AdocaoManagedBean {  

    private Adocao adocao = new Adocao();
    private List<Adocao> adocoes;
    private List<Adocao> AdocoesFiltro;
    private Integer idPessoaSelecionada;
    private Integer idAnimalSelecionado;
    private List<SelectItem> PessoasParaAdocao = new ArrayList<>();
    private List<SelectItem> AnimaisParaAdocao = new ArrayList<>();

    @EJB
    private AdocaoFachada adocaoFachada;
    
    @EJB
    private PessoaFachada pessoaFachada;
    
    @EJB
    private AnimalFachada animalFachada;

    public AdocaoManagedBean() {
    }

    public String montarPaginaParaInsercao() {
        this.setIdpessoaSelecionada(0);
        this.setIdAnimalSelecionado(0);
        this.setAnimaisParaAdocao(this.getAnimais());
        this.setPessoasParaAdocao(this.getPessoas());
        this.setAdocao(new Adocao());        
        return "/Adocao/InserirAdocao?faces-redirect=true";
    }
       
    public List<SelectItem> getAnimais() {
        List<Animal> animaisParaAdocao = this.getAnimalFachada().ListarAtivos();

        List<SelectItem> animais = new ArrayList<SelectItem>(animaisParaAdocao.size());

        for (Animal animal : animaisParaAdocao) {
            animais.add(new SelectItem(animal.getIdanimal(), animal.getNome()));
        }

        return animais;
    }
    
    public List<SelectItem> getPessoas() {
        List<Pessoa> pessoasParaAdocao = this.getPessoaFachada().ListarAtivas();

        List<SelectItem> pessoas = new ArrayList<SelectItem>(pessoasParaAdocao.size());

        for (Pessoa pessoa : pessoasParaAdocao) {
            pessoas.add(new SelectItem(pessoa.getIdpessoa(), pessoa.getNome()));
        }

        return pessoas;
    }
    
    
    public String montarPaginaParaAlteracao() {
        return "/Adocao/AlterarAdocao?faces-redirect=true";
    }

    public String Inserir() {
        this.getAdocao().setIdanimal(this.animalFachada.recuperarPorId(this.getIdAnimalSelecionado()));
        this.getAdocao().setIdpessoa(this.getPessoaFachada().recuperarPorId(this.getIdpessoaSelecionada()));
        getAdocaoFachada().Inserir(getAdocao());
        this.recuperarAdocoes();
        return "/Adocao/ListarAdocoes?faces-redirect=true";
    }
    
    public String Alterar() {
        getAdocaoFachada().Alterar(getAdocao());
        this.recuperarAdocoes();
        return "/Adocao/ListarAdocoes?faces-redirect=true";
    }

    private void recuperarAdocoes() {
        List<Adocao> adocoesListadas = getAdocaoFachada().Listar();
        setAdocoes(adocoesListadas);
        this.setAdocoesFiltro(adocoesListadas);
    }

    public String listar() {
        this.recuperarAdocoes();
        return "/Adocao/ListarAdocoes?faces-redirect=true";
    }

    /**
     * @return the adocao
     */
    public Adocao getAdocao() {
        return adocao;
    }

    /**
     * @param adocao the adocao to set
     */
    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    /**
     * @return the adocoes
     */
    public List<Adocao> getAdocoes() {
        return adocoes;
    }

    /**
     * @param adocoes the adocoes to set
     */
    public void setAdocoes(List<Adocao> adocoes) {
        this.adocoes = adocoes;
    }

    /**
     * @return the AdocoesFiltro
     */
    public List<Adocao> getAdocoesFiltro() {
        return AdocoesFiltro;
    }

    /**
     * @param AdocoesFiltro the AdocoesFiltro to set
     */
    public void setAdocoesFiltro(List<Adocao> AdocoesFiltro) {
        this.AdocoesFiltro = AdocoesFiltro;
    }

    /**
     * @return the adocaoFachada
     */
    public AdocaoFachada getAdocaoFachada() {
        return adocaoFachada;
    }

    /**
     * @param adocaoFachada the adocaoFachada to set
     */
    public void setAdocaoFachada(AdocaoFachada adocaoFachada) {
        this.adocaoFachada = adocaoFachada;
    }

    /**
     * @return the idPessoaSelecionada
     */
    public Integer getIdpessoaSelecionada() {
        return idPessoaSelecionada;
    }

    /**
     * @param idpessoaSelecionada the idPessoaSelecionada to set
     */
    public void setIdpessoaSelecionada(Integer idpessoaSelecionada) {
        this.idPessoaSelecionada = idpessoaSelecionada;
    }

    /*
     * @return the idAnimalSelecionado
     */
    public Integer getIdAnimalSelecionado() {
        return idAnimalSelecionado;
    }

    /**
     * @param idAnimalSelecionado the idAnimalSelecionado to set
     */
    public void setIdAnimalSelecionado(Integer idAnimalSelecionado) {
        this.idAnimalSelecionado = idAnimalSelecionado;
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

    /**
     * @return the PessoasParaAdocao
     */
    public List<SelectItem> getPessoasParaAdocao() {
        return PessoasParaAdocao;
    }

    /**
     * @param PessoasParaAdocao the PessoasParaAdocao to set
     */
    public void setPessoasParaAdocao(List<SelectItem> PessoasParaAdocao) {
        this.PessoasParaAdocao = PessoasParaAdocao;
    }

    /**
     * @return the AnimaisParaAdocao
     */
    public List<SelectItem> getAnimaisParaAdocao() {
        return AnimaisParaAdocao;
    }

    /**
     * @param AnimaisParaAdocao the AnimaisParaAdocao to set
     */
    public void setAnimaisParaAdocao(List<SelectItem> AnimaisParaAdocao) {
        this.AnimaisParaAdocao = AnimaisParaAdocao;
    }

}

