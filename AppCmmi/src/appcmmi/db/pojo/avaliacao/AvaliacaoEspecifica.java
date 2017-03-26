/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.avaliacao;

import appcmmi.db.pojo.artefato.ArtefatoEspecifica;
import appcmmi.db.pojo.modelo.PraticaEspecifica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author diego
 * @since  18/11/2009
 */
@Entity
@Table(name = "AVALIACAOESPECIFICA")
public class AvaliacaoEspecifica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDAVALIACAOESPECIFICA")
    @Basic(optional = false)
    private Integer idavaliacaoespecifica;
    @PrimaryKeyJoinColumn(name = "IDAVALIACAO", referencedColumnName= "IDAVALIACAO")
    @ManyToOne(optional = false)
    private Avaliacao idavaliacao;
    @PrimaryKeyJoinColumn(name = "IDESPECIFICA", referencedColumnName= "IDESPECIFICA")
    @ManyToOne(optional = false)
    private PraticaEspecifica idpraticaespecifica;
    @Column(name = "COMENTARIO", length = 1024)
    private String comentario;
    @JoinColumn(name = "IDSTATUSDEFINICAO", referencedColumnName = "IDSTATUS")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusDefinicao idStatusDefinicao;
    @JoinColumn(name = "IDSTATUSINSTITUCIONALIZACAO", referencedColumnName = "IDSTATUS")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusInstitucionalizacao idStatusInstitucionalizacao;
    @JoinColumn(name = "IDSTATUSCOMENTARIO", referencedColumnName = "IDSTATUSCOMENTARIO")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusComentario idStatusComentario;
    @OneToMany(mappedBy="idavaliacaoespecifica", cascade=CascadeType.ALL)
    private List<ArtefatoEspecifica> artefatoList;

    public AvaliacaoEspecifica() {
    }

    public AvaliacaoEspecifica(Integer idavaliacaoespecifica, Avaliacao idavaliacao, PraticaEspecifica idpraticaespecifica, String comentario) {
        this.idavaliacaoespecifica = idavaliacaoespecifica;
        this.idavaliacao = idavaliacao;
        this.idpraticaespecifica = idpraticaespecifica;
        this.comentario = comentario;
    }

    public StatusComentario getIdStatusComentario() {
        return idStatusComentario;
    }

    public void setIdStatusComentario(StatusComentario idStatusComentario) {
        this.idStatusComentario = idStatusComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Avaliacao getIdavaliacao() {
        return idavaliacao;
    }

    public void setIdavaliacao(Avaliacao idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public Integer getIdavaliacaoespecifica() {
        return idavaliacaoespecifica;
    }

    public void setIdavaliacaoespecifica(Integer idavaliacaoespecifica) {
        this.idavaliacaoespecifica = idavaliacaoespecifica;
    }

    public PraticaEspecifica getIdpraticaespecifica() {
        return idpraticaespecifica;
    }

    public void setIdpraticaespecifica(PraticaEspecifica idpraticaespecifica) {
        this.idpraticaespecifica = idpraticaespecifica;
    }

    public StatusInstitucionalizacao getIdStatusInstitucionalizacao() {
        return idStatusInstitucionalizacao;
    }

    public void setIdStatusInstitucionalizacao(StatusInstitucionalizacao idStatusInstitucionalizacao) {
        this.idStatusInstitucionalizacao = idStatusInstitucionalizacao;
    }

    public StatusDefinicao getIdStatusDefinicao() {
        return idStatusDefinicao;
    }

    public void setIdStatusDefinicao(StatusDefinicao idStatus) {
        this.idStatusDefinicao = idStatus;
    }

    public List<ArtefatoEspecifica> getArtefatoList() {
        return artefatoList;
    }

    public void setArtefatoList(List<ArtefatoEspecifica> artefatoList) {
        this.artefatoList = artefatoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavaliacaoespecifica != null ? idavaliacaoespecifica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AvaliacaoEspecifica)) {
            return false;
        }
        AvaliacaoEspecifica other = (AvaliacaoEspecifica) object;
        if ((this.idavaliacaoespecifica == null && other.idavaliacaoespecifica != null) || 
                (this.idavaliacaoespecifica != null && other.idavaliacaoespecifica == null) ||
                (this.idavaliacaoespecifica != null && !this.idavaliacaoespecifica.equals(other.idavaliacaoespecifica)) ||
                (this.getIdStatusDefinicao() != null && other.getIdStatusDefinicao() == null) ||
                (this.getIdStatusDefinicao() == null && other.getIdStatusDefinicao() != null) ||
                (this.getIdStatusDefinicao() != null && !this.getIdStatusDefinicao().equals(other.getIdStatusDefinicao())) ||
                (this.getIdStatusInstitucionalizacao() != null && other.getIdStatusInstitucionalizacao() == null) ||
                (this.getIdStatusInstitucionalizacao() == null && other.getIdStatusInstitucionalizacao() != null) ||
                (this.getIdStatusInstitucionalizacao() != null && !this.getIdStatusInstitucionalizacao().equals(other.getIdStatusInstitucionalizacao())) ||
                (this.getComentario() != null && other.getComentario() == null) ||
                (this.getComentario() == null && other.getComentario() != null) ||
                (this.getComentario() != null && !this.getComentario().equals(other.getComentario()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prática Específica " + idpraticaespecifica;
    }

}
