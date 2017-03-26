/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.artefato;

import appcmmi.db.pojo.*;
import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author diego
 * @since 18/11/2009
 */
@Entity
@Table(name = "ARTEFATOESPECIFICA")
public class ArtefatoEspecifica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDARTEFATOESPECIFICA")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idArtefatoEspecifica;
    @Column(name = "DESCRICAO", length=1024)
    @Basic(optional = false)
    private String descricao;
    @JoinColumn(name = "IDAVALIACAOESPECIFICA", referencedColumnName="IDAVALIACAOESPECIFICA")
    @ManyToOne(optional=false)
    private AvaliacaoEspecifica idavaliacaoespecifica;
    @JoinColumn(name="idtipoartefato", referencedColumnName="idtipoartefato")
    @ManyToOne(cascade=CascadeType.MERGE)
    private TipoArtefato idTipoArtefato;
    @JoinColumn(name = "IDATIVO", referencedColumnName="IDATIVO")
    @ManyToOne(cascade=CascadeType.ALL)
    private Ativo ativo;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ArtefatoEspecifica() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String old = this.descricao;
        this.descricao = descricao;
        property.firePropertyChange("descricao", old, descricao);
    }

    public Integer getIdArtefatoEspecifica() {
        return idArtefatoEspecifica;
    }

    public void setIdArtefatoEspecifica(Integer idArtefatoEspecifica) {
        Integer old = this.idArtefatoEspecifica;
        this.idArtefatoEspecifica = idArtefatoEspecifica;
        property.firePropertyChange("idArtefatoEspecifica", old, idArtefatoEspecifica);
    }

    public TipoArtefato getIdTipoArtefatoEspecifica() {
        return idTipoArtefato;
    }

    public void setIdTipoArtefato(TipoArtefato idTipoArtefato) {
        TipoArtefato old = this.idTipoArtefato;
        this.idTipoArtefato = idTipoArtefato;
        property.firePropertyChange("idTipoArtefato", old, idTipoArtefato);
    }

    public AvaliacaoEspecifica getIdAvaliacaoEspecifica() {
        return idavaliacaoespecifica;
    }

    public void setIdAvaliacaoEspecifica(AvaliacaoEspecifica idAvaliacaoEspecifica) {
        AvaliacaoEspecifica old = new AvaliacaoEspecifica();
        this.idavaliacaoespecifica = idAvaliacaoEspecifica;
        property.firePropertyChange("idAvaliacaoEspecifica", old, idAvaliacaoEspecifica);
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        Ativo old = this.ativo;
        this.ativo = ativo;
        property.firePropertyChange("ativo", old, ativo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArtefatoEspecifica != null ? idArtefatoEspecifica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idArtefatoEspecifica fields are not set
        if (!(object instanceof ArtefatoEspecifica)) {
            return false;
        }
        ArtefatoEspecifica other = (ArtefatoEspecifica) object;
        if ((this.idArtefatoEspecifica == null && other.idArtefatoEspecifica != null) || (this.idArtefatoEspecifica != null && !this.idArtefatoEspecifica.equals(other.idArtefatoEspecifica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appcmmi.db.pojo.Artefato[id=" + idArtefatoEspecifica + "]";
    }
}
