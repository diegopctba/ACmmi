/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.pojo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "AVALIADOR")
@NamedQueries({@NamedQuery(name = "Avaliador.findAll", query = "SELECT a FROM Avaliador a"), @NamedQuery(name = "Avaliador.findByIdavaliador", query = "SELECT a FROM Avaliador a WHERE a.idavaliador = :idavaliador"), @NamedQuery(name = "Avaliador.findByNome", query = "SELECT a FROM Avaliador a WHERE a.nome = :nome"), @NamedQuery(name = "Avaliador.findByCpf", query = "SELECT a FROM Avaliador a WHERE a.cpf = :cpf"), @NamedQuery(name = "Avaliador.findByRg", query = "SELECT a FROM Avaliador a WHERE a.rg = :rg")})
public class Avaliador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAVALIADOR")
    private Integer idavaliador;
    @Basic(optional = false)
    @Column(name = "NOME", length = 64)
    private String nome;
    @Column(name = "CPF", unique = true)
    private long cpf;
    @Column(name = "RG", unique = true)
    private long rg;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public Avaliador() {
    }

    public Avaliador(Integer idavaliador) {
        this.idavaliador = idavaliador;
    }

    public Avaliador(Integer idavaliador, String nome, long cpf, long rg) {
        this.idavaliador = idavaliador;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Integer getIdavaliador() {
        return idavaliador;
    }

    public void setIdavaliador(Integer idavaliador) {
        Integer old = this.idavaliador;
        this.idavaliador = idavaliador;
        property.firePropertyChange("idavaliador", old, idavaliador);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String old = this.nome;
        this.nome = nome.toUpperCase();
        property.firePropertyChange("nome", old, nome);
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        long old = this.cpf;
        this.cpf = cpf;
        property.firePropertyChange("cpf", old, cpf);
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        long old = this.rg;
        this.rg = rg;
        property.firePropertyChange("rg", old, rg);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavaliador != null ? idavaliador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliador)) {
            return false;
        }
        Avaliador other = (Avaliador) object;
        if ((this.idavaliador == null && other.idavaliador != null) || (this.idavaliador != null && !this.idavaliador.equals(other.idavaliador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idavaliador + " - " + this.nome;
    }

    /**
     * Adiciona um escutador de mudança de propriedade
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    /**
     * Remove um escutador de mudança de propriedade
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
