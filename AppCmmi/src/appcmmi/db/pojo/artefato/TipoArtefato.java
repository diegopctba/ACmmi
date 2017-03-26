/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.pojo.artefato;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "TIPOARTEFATO")
public class TipoArtefato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDTIPOARTEFATO")
    @Basic(optional=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idtipoartefato;
    @Column(name="DESCRICAO", length=32)
    private String descricao;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public TipoArtefato() {
    }

    public Integer getIdtipoartefato() {
        return idtipoartefato;
    }

    public void setIdtipoartefato(Integer idTipoArtefato) {
        Integer old = this.idtipoartefato;
        this.idtipoartefato = idTipoArtefato;
        property.firePropertyChange("idtipoartefato", old, idTipoArtefato);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String old = this.descricao;
        this.descricao = descricao;
        property.firePropertyChange("descricao", old, descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }

    /*public void addPropertyChangeListener(PropertyChangeListener listener) {
    property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
    property.removePropertyChangeListener(listener);
    }*/
}
