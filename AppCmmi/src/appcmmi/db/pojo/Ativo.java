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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Classe da tabela Ativo
 * @author diego
 */
@Entity
@Table(name = "ATIVO")
public class Ativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDATIVO")
    private Integer idativo;
    @Basic(optional = false)
    @Column(name = "NOME", length=128)
    private String nome;
    @Column(name = "DESCRICAO", length=512)
    private String descricao;
    @JoinColumn(name = "IDEMPRESA", referencedColumnName = "IDEMPRESA")
    @ManyToOne(optional = false)
    private Empresa idempresa;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public Ativo() {
    }

    public Ativo(Integer idprojeto) {
        this.idativo = idprojeto;
    }

    public Ativo(Integer idprojeto, String nome) {
        this.idativo = idprojeto;
        this.nome = nome;
    }

    public Ativo(Integer idprojeto, String nome, String descricao) {
        this.idativo = idprojeto;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getIdativo() {
        return idativo;
    }

    public void setIdativo(Integer idprojeto) {
        Integer old = this.idativo;
        this.idativo = idprojeto;
        property.firePropertyChange("idativo", old, idprojeto);
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String old = this.nome;
        this.nome = nome.toUpperCase();
        property.firePropertyChange("nome", old, nome);
    }

    public void setDescricao(String descricao) {
        String old = this.descricao;
        this.descricao = descricao.toUpperCase();
        property.firePropertyChange("descricao", old, descricao);
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        Empresa old = this.idempresa;
        this.idempresa = idempresa;
        property.firePropertyChange("idempresa", old, idempresa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idativo != null ? idativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ativo)) {
            return false;
        }
        Ativo other = (Ativo) object;
        if ((this.idativo == null && other.idativo != null) || (this.idativo != null && !this.idativo.equals(other.idativo)) ||
                (this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idativo + " - " + nome;
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
