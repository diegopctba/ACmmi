/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.modelo;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "PRATICAESPECIFICA")
@NamedQueries({@NamedQuery(name = "PraticaEspecifica.findAll", query = "SELECT p FROM PraticaEspecifica p"), @NamedQuery(name = "PraticaEspecifica.findByIdespecifica", query = "SELECT p FROM PraticaEspecifica p WHERE p.idespecifica = :idespecifica"), @NamedQuery(name = "PraticaEspecifica.findByTitulo", query = "SELECT p FROM PraticaEspecifica p WHERE p.titulo = :titulo"), @NamedQuery(name = "PraticaEspecifica.findByDescricao", query = "SELECT p FROM PraticaEspecifica p WHERE p.descricao = :descricao"), @NamedQuery(name = "PraticaEspecifica.findByNumpraticaespecifica", query = "SELECT p FROM PraticaEspecifica p WHERE p.numpraticaespecifica = :numpraticaespecifica")})
public class PraticaEspecifica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDESPECIFICA")
    private Integer idespecifica;
    @Basic(optional = false)
    @Column(name = "TITULO", length=128)
    private String titulo;
    @Column(name = "DESCRICAO", length=512)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "NUMPRATICAESPECIFICA")
    private double numpraticaespecifica;
    @JoinColumn(name = "IDAREAPROCESSO", referencedColumnName = "IDAREAPROCESSO")
    @ManyToOne(optional = false, cascade=CascadeType.MERGE)
    private AreaProcesso idareaprocesso;

    public PraticaEspecifica() {
    }

    public PraticaEspecifica(Integer idespecifica) {
        this.idespecifica = idespecifica;
    }

    public PraticaEspecifica(Integer idespecifica, String titulo, double numpraticaespecifica) {
        this.idespecifica = idespecifica;
        this.titulo = titulo;
        this.numpraticaespecifica = numpraticaespecifica;
    }

    public Integer getIdespecifica() {
        return idespecifica;
    }

    public void setIdespecifica(Integer idespecifica) {
        this.idespecifica = idespecifica;
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

    public double getNumpraticaespecifica() {
        return numpraticaespecifica;
    }

    public void setNumpraticaespecifica(double numpraticaespecifica) {
        this.numpraticaespecifica = numpraticaespecifica;
    }

    public AreaProcesso getIdareaprocesso() {
        return idareaprocesso;
    }

    public void setIdareaprocesso(AreaProcesso idareaprocesso) {
        this.idareaprocesso = idareaprocesso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecifica != null ? idespecifica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PraticaEspecifica)) {
            return false;
        }
        PraticaEspecifica other = (PraticaEspecifica) object;
        if ((this.idespecifica == null && other.idespecifica != null) || (this.idespecifica != null && !this.idespecifica.equals(other.idespecifica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return numpraticaespecifica + " - " + titulo;
    }

}
