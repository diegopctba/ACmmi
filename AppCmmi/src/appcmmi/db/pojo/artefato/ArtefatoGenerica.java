/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.artefato;

import appcmmi.db.pojo.Ativo;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
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
import javax.persistence.Transient;

/**
 *
 * @author diego
 */
@Entity
public class ArtefatoGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDARTEFATOGENERICA")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idArtefatoGenerica;
    @Column(name = "DESCRICAO", length=1024)
    @Basic(optional = false)
    private String descricao;
    @JoinColumn(name = "IDAVALIACAOGENERICA", referencedColumnName="IDAVALIACAOGENERICA")
    @ManyToOne(optional=false)
    private AvaliacaoGenerica idavaliacaogenerica;
    @JoinColumn(name="idtipoartefato", referencedColumnName="idtipoartefato")
    @ManyToOne(cascade=CascadeType.MERGE)
    private TipoArtefato idTipoArtefato;
    @JoinColumn(name = "IDATIVO", referencedColumnName="IDATIVO")
    @ManyToOne(cascade=CascadeType.ALL)
    private Ativo ativo;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ArtefatoGenerica() {
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdArtefatoGenerica() {
        return idArtefatoGenerica;
    }

    public void setIdArtefatoGenerica(Integer idArtefatoGenerica) {
        this.idArtefatoGenerica = idArtefatoGenerica;
    }

    public TipoArtefato getIdTipoArtefato() {
        return idTipoArtefato;
    }

    public void setIdTipoArtefato(TipoArtefato idTipoArtefato) {
        this.idTipoArtefato = idTipoArtefato;
    }

    public AvaliacaoGenerica getIdavaliacaogenerica() {
        return idavaliacaogenerica;
    }

    public void setIdavaliacaogenerica(AvaliacaoGenerica idavaliacaogenerica) {
        this.idavaliacaogenerica = idavaliacaogenerica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArtefatoGenerica != null ? idArtefatoGenerica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idArtefatoGenerica fields are not set
        if (!(object instanceof ArtefatoGenerica)) {
            return false;
        }
        ArtefatoGenerica other = (ArtefatoGenerica) object;
        if ((this.idArtefatoGenerica == null && other.idArtefatoGenerica != null) || (this.idArtefatoGenerica != null && !this.idArtefatoGenerica.equals(other.idArtefatoGenerica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appcmmi.db.pojo.artefato.ArtefatoGenerica[id=" + idArtefatoGenerica + "]";
    }

}
