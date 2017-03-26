/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.avaliacao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author diego
 */
@Entity
public class StatusComentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="idstatuscomentario")
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idStatusComentario;
    @Column(name="descricao", length=32)
    @Basic(optional=false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdStatusComentario() {
        return idStatusComentario;
    }

    public void setIdStatusComentario(Integer idStatusComentario) {
        this.idStatusComentario = idStatusComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatusComentario != null ? idStatusComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the idStatusComentario fields are not set
        if (!(object instanceof StatusComentario)) {
            return false;
        }
        StatusComentario other = (StatusComentario) object;
        if ((this.idStatusComentario == null && other.idStatusComentario != null) || (this.idStatusComentario != null && !this.idStatusComentario.equals(other.idStatusComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
