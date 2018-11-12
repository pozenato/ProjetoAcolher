/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author monitora
 */
@Entity
@Table(name = "adocao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adocao.findAll", query = "SELECT a FROM Adocao a")
    , @NamedQuery(name = "Adocao.findByIdadocao", query = "SELECT a FROM Adocao a WHERE a.idadocao = :idadocao")
    , @NamedQuery(name = "Adocao.findByDataadocao", query = "SELECT a FROM Adocao a WHERE a.dataadocao = :dataadocao")})
public class Adocao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idadocao", nullable = false)
    @SequenceGenerator(name="Adocao_Generator", sequenceName="adocao_sequence", allocationSize= 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Adocao_Generator")
    private Integer idadocao;   
    
    @Column(name = "dataadocao")
    @Temporal(TemporalType.DATE)
    private Date dataadocao;
    @JoinColumn(name = "idanimal", referencedColumnName = "idanimal")
    @ManyToOne
    private Animal idanimal;
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    @ManyToOne
    private Pessoa idpessoa;

    public Adocao() {
    }

    public Adocao(Integer idadocao) {
        this.idadocao = idadocao;
    }

    public Integer getIdadocao() {
        return idadocao;
    }

    public void setIdadocao(Integer idadocao) {
        this.idadocao = idadocao;
    }

    public Date getDataadocao() {
        return dataadocao;
    }

    public void setDataadocao(Date dataadocao) {
        this.dataadocao = dataadocao;
    }

    public Animal getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(Animal idanimal) {
        this.idanimal = idanimal;
    }

    public Pessoa getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(Pessoa idpessoa) {
        this.idpessoa = idpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadocao != null ? idadocao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adocao)) {
            return false;
        }
        Adocao other = (Adocao) object;
        if ((this.idadocao == null && other.idadocao != null) || (this.idadocao != null && !this.idadocao.equals(other.idadocao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entidade.Adocao[ idadocao=" + idadocao + " ]";
    }
    
}
