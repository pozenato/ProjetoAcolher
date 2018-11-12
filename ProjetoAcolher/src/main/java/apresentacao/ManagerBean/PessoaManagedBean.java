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
import negocio.entidade.Pessoa;
import negocio.fachada.PessoaFachada;


/**
 *
 * @author Rodrigo
 */
@ManagedBean(name = "pessoaManagedBean")
@SessionScoped
public class PessoaManagedBean {  

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> Pessoas;
    private List<Pessoa> PessoaFiltro;

    @EJB
    private PessoaFachada pessoaFachada;

    public PessoaManagedBean() {
    }

    public String montarPaginaParaInsercao() {
        this.setPessoa(new Pessoa());        
        return "/Pessoa/InserirPessoa?faces-redirect=true";
    }
    
    public String montarPaginaParaAlteracao() {
        return "/Pessoa/AlterarPessoa?faces-redirect=true";
    }

    public String Inserir() {
        getPessoaFachada().Inserir(getPessoa());
        this.recuperarPessoas();
        return "/Pessoa/ListarPessoas?faces-redirect=true";
    }
    
    public String Alterar() {
        getPessoaFachada().Alterar(getPessoa());
        this.recuperarPessoas();
        return "/Pessoa/ListarPessoas?faces-redirect=true";
    }

    private void recuperarPessoas() {
        List<Pessoa> pessoasListadas = getPessoaFachada().Listar();
        setPessoaFiltro(pessoasListadas);
        this.setPessoas(pessoasListadas);
    }

    public String listar() {
        this.recuperarPessoas();
        return "/Pessoa/ListarPessoas?faces-redirect=true";
    }

        
    /**
     * @return the Pessoas
     */
    public List<Pessoa> getPessoas() {
        return Pessoas;
    }

    /**
     * @return the PessoaFiltro
     */
    public List<Pessoa> getPessoaFiltro() {
        return PessoaFiltro;
    }

    /**
     * @return the pessoaFachada
     */
    public PessoaFachada getPessoaFachada() {
        return pessoaFachada;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @param Pessoas the Pessoas to set
     */
    public void setPessoas(List<Pessoa> Pessoas) {
        this.Pessoas = Pessoas;
    }

    /**
     * @param PessoaFiltro the PessoaFiltro to set
     */
    public void setPessoaFiltro(List<Pessoa> PessoaFiltro) {
        this.PessoaFiltro = PessoaFiltro;
    }

    /**
     * @param pessoaFachada the pessoaFachada to set
     */
    public void setPessoaFachada(PessoaFachada pessoaFachada) {
        this.pessoaFachada = pessoaFachada;
    }

}

