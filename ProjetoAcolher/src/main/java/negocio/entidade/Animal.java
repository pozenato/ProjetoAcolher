/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.entidade;

import java.io.Serializable;
import java.math.BigInteger;
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
 * @author Rodrigo
 */
@Entity
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByIdanimal", query = "SELECT a FROM Animal a WHERE a.idanimal = :idanimal")
    , @NamedQuery(name = "Animal.findByNome", query = "SELECT a FROM Animal a WHERE a.nome = :nome")
    , @NamedQuery(name = "Animal.findByDatanasc", query = "SELECT a FROM Animal a WHERE a.datanasc = :datanasc")
    , @NamedQuery(name = "Animal.findByTipo", query = "SELECT a FROM Animal a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Animal.findByStatus", query = "SELECT a FROM Animal a WHERE a.status = :status")
    , @NamedQuery(name = "Animal.findByRaca", query = "SELECT a FROM Animal a WHERE a.raca = :raca")})
public class Animal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idanimal", nullable = false)
    @SequenceGenerator(name="Animal_Generator", sequenceName="animal_sequence", allocationSize= 1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Animal_Generator")
    private Integer idanimal;   
   
    @Column(name = "nome")
    private String nome;
    @Column(name = "datanasc")
    @Temporal(TemporalType.DATE)
    private Date datanasc;
    @Column(name = "tipo")
    private BigInteger tipo;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 2147483647)
    @Column(name = "raca")
    private String raca;
    
    
    @OneToMany(mappedBy = "idanimal", fetch = FetchType.EAGER)
    private Collection<Adocao> adocaoCollection;

    public Animal() {
    }

    public Animal(Integer idanimal) {
        this.idanimal = idanimal;
    }

    public Integer getIdanimal() {
        return idanimal;
    }

    public void setIdanimal(Integer idanimal) {
        this.idanimal = idanimal;
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

    public BigInteger getTipo() {
        return tipo;
    }

    public void setTipo(BigInteger tipo) {
        this.tipo = tipo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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
        hash += (idanimal != null ? idanimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.idanimal == null && other.idanimal != null) || (this.idanimal != null && !this.idanimal.equals(other.idanimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "negocio.entidade.Animal[ idanimal=" + idanimal + " ]";
    }
    
}
