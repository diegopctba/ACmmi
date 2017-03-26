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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "MATURIDADE")
@NamedQueries({@NamedQuery(name = "Maturidade.findAll", query = "SELECT m FROM Maturidade m"), @NamedQuery(name = "Maturidade.findByIdmaturidade", query = "SELECT m FROM Maturidade m WHERE m.idmaturidade = :idmaturidade"), @NamedQuery(name = "Maturidade.findByTitulo", query = "SELECT m FROM Maturidade m WHERE m.titulo = :titulo"), @NamedQuery(name = "Maturidade.findByDescricao", query = "SELECT m FROM Maturidade m WHERE m.descricao = :descricao"), @NamedQuery(name = "Maturidade.findByNummaturidade", query = "SELECT m FROM Maturidade m WHERE m.nummaturidade = :nummaturidade")})
public class Maturidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMATURIDADE")
    private Integer idmaturidade;
    @Basic(optional = false)
    @Column(name = "TITULO", length=128)
    private String titulo;
    @Column(name = "DESCRICAO", length=512)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "NUMMATURIDADE")
    private int nummaturidade;
    @OneToMany(mappedBy = "idmaturidade")
    @OrderBy("numpraticagenerica")
    private List<PraticaGenerica> praticaGenericaList;
    @OneToMany(mappedBy = "idmaturidade", fetch=FetchType.EAGER)
    @OrderBy("numareaprocesso")
    private List<AreaProcesso> areaProcessoList;

    public Maturidade() {
    }

    public Maturidade(Integer idmaturidade) {
        this.idmaturidade = idmaturidade;
    }

    public Maturidade(Integer idmaturidade, String titulo, int nummaturidade) {
        this.idmaturidade = idmaturidade;
        this.titulo = titulo;
        this.nummaturidade = nummaturidade;
    }

    public Integer getIdmaturidade() {
        return idmaturidade;
    }

    public void setIdmaturidade(Integer idmaturidade) {
        this.idmaturidade = idmaturidade;
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

    public int getNummaturidade() {
        return nummaturidade;
    }

    public void setNummaturidade(int nummaturidade) {
        this.nummaturidade = nummaturidade;
    }

    public List<PraticaGenerica> getPraticaGenericaList() {
        return praticaGenericaList;
    }

    public void setPraticaGenericaList(List<PraticaGenerica> praticaGenericaList) {
        this.praticaGenericaList = praticaGenericaList;
    }

    public List<AreaProcesso> getAreaProcessoList() {
        return areaProcessoList;
    }

    public void setAreaProcessoList(List<AreaProcesso> areaProcessoList) {
        this.areaProcessoList = areaProcessoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaturidade != null ? idmaturidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maturidade)) {
            return false;
        }
        Maturidade other = (Maturidade) object;
        if ((this.idmaturidade == null && other.idmaturidade != null) || (this.idmaturidade != null && !this.idmaturidade.equals(other.idmaturidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nummaturidade + " - " + titulo;
    }

}
