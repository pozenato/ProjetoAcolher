/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidade;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author monitora
 */
@Entity
@Table(name = "pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
    , @NamedQuery(name = "Pessoa.findByIdpessoa", query = "SELECT p FROM Pessoa p WHERE p.idpessoa = :idpessoa")
    , @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome")
    , @NamedQuery(name = "Pessoa.findByDatanasc", query = "SELECT p FROM Pessoa p WHERE p.datanasc = :datanasc")
    , @NamedQuery(name = "Pessoa.findByStatus", query = "SELECT p FROM Pessoa p WHERE p.status = :status")
    , @NamedQuery(name = "Pessoa.findByDatacadastro", query = "SELECT p FROM Pessoa p WHERE p.datacadastro = :datacadastro")
    , @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone")})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpessoa", nullable = false)
    @SequenceGenerator(name="Pessoa_Generator", sequenceName="pessoa_sequence", allocationSize= 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Pessoa_Generator")
    private Integer idpessoa;   
    
    @Column(name = "nome")
    private String nome;
    @Column(name = "datanasc")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "datacadastro")
    @Temporal(TemporalType.DATE)
    private Date datacadastro;
    @Size(max = 2147483647)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "idpessoa", fetch = FetchType.EAGER)
    private Collection<Adocao> adocaoCollection;

    public Pessoa() {
    }

    public Pessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public Integer getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Integer idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public Collection<Adocao> getAdocaoCollection() {
        return adocaoCollection;
    }

    public void setAdocaoCollection(Collection<Adocao> adocaoCollection) {
        this.adocaoCollection = adocaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpessoa != null ? idpessoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.idpessoa == null && other.idpessoa != null) || (this.idpessoa != null && !this.idpessoa.equals(other.idpessoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entidade.Pessoa[ idpessoa=" + idpessoa + " ]";
    }
    
}
