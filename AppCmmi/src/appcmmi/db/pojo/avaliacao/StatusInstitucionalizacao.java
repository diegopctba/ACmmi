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
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "STATUSINSTITUCIONALIZACAO")
public class StatusInstitucionalizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDSTATUS")
    @Basic(optional = false)
    private Integer idStatus;
    @Column(name="SIGLA", length=5)
    private String sigla;
    @Column(name="DESCRICAO", length=64)
    private String descricao;

    public StatusInstitucionalizacao(Integer idStatus, String sigla, String descricao) {
        this.idStatus = idStatus;
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public StatusInstitucionalizacao() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatus != null ? idStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof StatusInstitucionalizacao)) {
            return false;
        }
        StatusInstitucionalizacao other = (StatusInstitucionalizacao) object;
        if ((this.idStatus == null && other.idStatus != null) ||
                (this.idStatus != null && other.idStatus == null) ||
                (this.idStatus != null && !this.idStatus.equals(other.idStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sigla;
    }

}
