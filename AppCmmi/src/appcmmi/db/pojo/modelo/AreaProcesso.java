/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "AREAPROCESSO")
@NamedQueries({@NamedQuery(name = "AreaProcesso.findAll", query = "SELECT a FROM AreaProcesso a"), @NamedQuery(name = "AreaProcesso.findByIdareaprocesso", query = "SELECT a FROM AreaProcesso a WHERE a.idareaprocesso = :idareaprocesso"), @NamedQuery(name = "AreaProcesso.findByTitulo", query = "SELECT a FROM AreaProcesso a WHERE a.titulo = :titulo"), @NamedQuery(name = "AreaProcesso.findByDescricao", query = "SELECT a FROM AreaProcesso a WHERE a.descricao = :descricao"), @NamedQuery(name = "AreaProcesso.findByNumareaprocesso", query = "SELECT a FROM AreaProcesso a WHERE a.numareaprocesso = :numareaprocesso")})
public class AreaProcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAREAPROCESSO")
    private Integer idareaprocesso;
    @Basic(optional = false)
    @Column(name = "TITULO", length=128)
    private String titulo;
    @Column(name = "DESCRICAO", length=512)
    private String descricao;
    @Column(name = "SIGLA", length=6)
    private String sigla;
    @Basic(optional = false)
    @Column(name = "NUMAREAPROCESSO")
    private int numareaprocesso;
    @OneToMany(mappedBy = "idareaprocesso")
    @OrderBy("numpraticaespecifica")
    private List<PraticaEspecifica> praticaEspecificaList;
    @JoinColumn(name = "IDMATURIDADE", referencedColumnName = "IDMATURIDADE")
    @ManyToOne(optional = false)
    private Maturidade idmaturidade;

    public AreaProcesso() {
    }

    public AreaProcesso(Integer idareaprocesso) {
        this.idareaprocesso = idareaprocesso;
    }

    public AreaProcesso(Integer idareaprocesso, String titulo, int numareaprocesso) {
        this.idareaprocesso = idareaprocesso;
        this.titulo = titulo;
        this.numareaprocesso = numareaprocesso;
    }

    public Integer getIdareaprocesso() {
        return idareaprocesso;
    }

    public void setIdareaprocesso(Integer idareaprocesso) {
        this.idareaprocesso = idareaprocesso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumareaprocesso() {
        return numareaprocesso;
    }

    public void setNumareaprocesso(int numareaprocesso) {
        this.numareaprocesso = numareaprocesso;
    }

    public List<PraticaEspecifica> getPraticaEspecificaList() {
        return praticaEspecificaList;
    }

    public void setPraticaEspecificaList(List<PraticaEspecifica> praticaEspecificaList) {
        this.praticaEspecificaList = praticaEspecificaList;
    }

    public Maturidade getIdmaturidade() {
        return idmaturidade;
    }

    public void setIdmaturidade(Maturidade idmaturidade) {
        this.idmaturidade = idmaturidade;
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
        hash += (idareaprocesso != null ? idareaprocesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaProcesso)) {
            return false;
        }
        AreaProcesso other = (AreaProcesso) object;
        if ((this.idareaprocesso == null && other.idareaprocesso != null) || (this.idareaprocesso != null && !this.idareaprocesso.equals(other.idareaprocesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  numareaprocesso + " - " + titulo;
    }

}
