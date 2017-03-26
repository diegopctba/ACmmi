/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.pojo.avaliacao;

import appcmmi.db.pojo.artefato.ArtefatoGenerica;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.modelo.PraticaGenerica;
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
 */
@Entity
@Table(name = "AVALIACAOGENERICA")
public class AvaliacaoGenerica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDAVALIACAOGENERICA")
    @Basic(optional = false)
    private Integer idavaliacaogenerica;
    @PrimaryKeyJoinColumn(name = "IDAVALIACAO", referencedColumnName = "IDAVALIACAO")
    @ManyToOne(optional = false)
    private Avaliacao idavaliacao;
    @PrimaryKeyJoinColumn(name = "IDGENERICA", referencedColumnName = "IDGENERICA")
    @ManyToOne(optional = false, cascade=CascadeType.MERGE)
    private PraticaGenerica idpraticagenerica;
    @Column(name = "COMENTARIO", length = 1024)
    private String comentario;
    @JoinColumn(name = "IDSTATUSDEFINICAO", referencedColumnName = "IDSTATUS")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusDefinicao idStatusDefinicao;
    @JoinColumn(name = "IDSTATUSINSTITUCIONALIZACAO", referencedColumnName = "IDSTATUS")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusInstitucionalizacao idStatusInstitucionalizacao;
    @JoinColumn(name = "IDSTATUSCOMENTARIO", referencedColumnName= "IDSTATUSCOMENTARIO")
    @ManyToOne(cascade=CascadeType.MERGE)
    private StatusComentario idStatusComentario;
    @OneToMany(mappedBy = "idavaliacaogenerica", cascade = CascadeType.ALL)
    private List<ArtefatoGenerica> artefatoList;
    @JoinColumn(name = "IDAREAPROCESSO", referencedColumnName= "IDAREAPROCESSO")
    @ManyToOne
    private AreaProcesso idAreaProcesso;

    public AvaliacaoGenerica() {
    }

    public AvaliacaoGenerica(Integer idavaliacaogenerica, Avaliacao idavaliacao, PraticaGenerica idpraticagenerica, String comentario) {
        this.idavaliacaogenerica = idavaliacaogenerica;
        this.idavaliacao = idavaliacao;
        this.idpraticagenerica = idpraticagenerica;
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

    public Integer getIdavaliacaogenerica() {
        return idavaliacaogenerica;
    }

    public void setIdavaliacaogenerica(Integer idavaliacaogenerica) {
        this.idavaliacaogenerica = idavaliacaogenerica;
    }

    public PraticaGenerica getIdpraticagenerica() {
        return idpraticagenerica;
    }

    public void setIdpraticagenerica(PraticaGenerica idpraticagenerica) {
        this.idpraticagenerica = idpraticagenerica;
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

    public List<ArtefatoGenerica> getArtefatoList() {
        return artefatoList;
    }

    public void setArtefatoList(List<ArtefatoGenerica> artefatoList) {
        this.artefatoList = artefatoList;
    }

    public AreaProcesso getIdAreaProcesso() {
        return idAreaProcesso;
    }

    public void setIdAreaProcesso(AreaProcesso idAreaProcesso) {
        this.idAreaProcesso = idAreaProcesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavaliacaogenerica != null ? idavaliacaogenerica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AvaliacaoGenerica)) {
            return false;
        }
        AvaliacaoGenerica other = (AvaliacaoGenerica) object;
        if ((this.idavaliacaogenerica == null && other.idavaliacaogenerica != null) ||
                (this.idavaliacaogenerica != null && other.idavaliacaogenerica == null) ||
                (this.idavaliacaogenerica != null && !this.idavaliacaogenerica.equals(other.idavaliacaogenerica)) ||
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
        return "Avaliação Genérica" + this.idpraticagenerica;
    }
}
