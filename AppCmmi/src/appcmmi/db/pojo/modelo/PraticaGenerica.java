/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "PRATICAGENERICA")
@NamedQueries({@NamedQuery(name = "PraticaGenerica.findAll", query = "SELECT p FROM PraticaGenerica p"), @NamedQuery(name = "PraticaGenerica.findByIdgenerica", query = "SELECT p FROM PraticaGenerica p WHERE p.idgenerica = :idgenerica"), @NamedQuery(name = "PraticaGenerica.findByTitulo", query = "SELECT p FROM PraticaGenerica p WHERE p.titulo = :titulo"), @NamedQuery(name = "PraticaGenerica.findByDescricao", query = "SELECT p FROM PraticaGenerica p WHERE p.descricao = :descricao"), @NamedQuery(name = "PraticaGenerica.findByNumpraticagenerica", query = "SELECT p FROM PraticaGenerica p WHERE p.numpraticagenerica = :numpraticagenerica")})
public class PraticaGenerica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDGENERICA")
    private Integer idgenerica;
    @Basic(optional = false)
    @Column(name = "TITULO", length=128)
    private String titulo;
    @Column(name = "DESCRICAO", length=512)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "NUMPRATICAGENERICA")
    private double numpraticagenerica;
    @JoinColumn(name = "IDMATURIDADE", referencedColumnName = "IDMATURIDADE")
    @ManyToOne(optional = false)
    private Maturidade idmaturidade;

    public PraticaGenerica() {
    }

    public PraticaGenerica(Integer idgenerica) {
        this.idgenerica = idgenerica;
    }

    public PraticaGenerica(Integer idgenerica, String titulo, double numpraticagenerica) {
        this.idgenerica = idgenerica;
        this.titulo = titulo;
        this.numpraticagenerica = numpraticagenerica;
    }

    public Integer getIdgenerica() {
        return idgenerica;
    }

    public void setIdgenerica(Integer idgenerica) {
        this.idgenerica = idgenerica;
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

    public double getNumpraticagenerica() {
        return numpraticagenerica;
    }

    public void setNumpraticagenerica(double numpraticagenerica) {
        this.numpraticagenerica = numpraticagenerica;
    }

    public Maturidade getIdmaturidade() {
        return idmaturidade;
    }

    public void setIdmaturidade(Maturidade idmaturidade) {
        this.idmaturidade = idmaturidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgenerica != null ? idgenerica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraticaGenerica)) {
            return false;
        }
        PraticaGenerica other = (PraticaGenerica) object;
        if ((this.idgenerica == null && other.idgenerica != null) || (this.idgenerica != null && !this.idgenerica.equals(other.idgenerica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numpraticagenerica + " - " + titulo;
    }

}
