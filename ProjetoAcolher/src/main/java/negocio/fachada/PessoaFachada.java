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
import javax.faces.model.SelectItem;
import negocio.entidade.Pessoa;
import negocio.persistencia.PessoaDAO;

/**
 *
 * @author pozenato
 */
@Stateless
public class PessoaFachada {
    @EJB
    private PessoaDAO pessoaDAO;
    
    public void Inserir(Pessoa pessoa){
        pessoa.setStatus(true);
        pessoa.setDatacadastro(new Date());
        pessoaDAO.Inserir(pessoa);
    }
    
    public void Alterar(Pessoa pessoa){
        pessoaDAO.Alterar(pessoa);
    }
    
    public List<Pessoa> Listar (){
        return pessoaDAO.RecuperarTodos();        
    }
    
    public List<Pessoa> ListarAtivas (){
        return pessoaDAO.RecuperarPessoasAtivas();        
    }
        
    public void DesabilitarPessoa(Pessoa pessoa) {
        this.pessoaDAO.DesabilitarPessoa(pessoa);
    }
    
    public Pessoa recuperarPorId(Integer id) {
        return pessoaDAO.recuperarPorId(id);
    }
}
