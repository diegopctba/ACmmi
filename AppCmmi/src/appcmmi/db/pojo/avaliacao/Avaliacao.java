/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.pojo.avaliacao;

import appcmmi.db.pojo.*;
import appcmmi.db.pojo.modelo.Maturidade;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ForeignKey;

/**
 * Classe responsável pela tabela Avaliação.
 * @author diego
 */
@Entity
@Table(name = "AVALIACAO")
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IDAVALIACAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idAvaliacao;
    @ForeignKey(inverseName = "IDEMPRESA", name = "IDEMPRESA")
    @ManyToOne(optional = false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Empresa idempresa;
    @Column(name = "COMENTARIO", length = 1024)
    private String comentario;
    @Column(name = "SENHA", length = 64)
    @Basic(optional = false)
    private String senha;
    @Column(name = "DEFINICAO")
    private Boolean definicao;
    @Column(name = "INSTITUCIONALIZACAO")
    private Boolean institucionalizacao;
    @ForeignKey(inverseName = "IDMATURIDADE", name = "IDMATURIDADE")
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    private Maturidade idmaturidade;
    @Column(name = "DATACRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "DATAINICIO")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "DATAFIM")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Column(name= "ESTADO")
    private String estado;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Avaliador> avaliadorList;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ativo> ativoList;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "idavaliacao")
    private List<AvaliacaoGenerica> avaliacaoGenericaList;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "idavaliacao")
    private List<AvaliacaoEspecifica> avaliacaoEspecificaList;
    @Transient
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public Avaliacao() {
    }

    public Avaliacao(Integer idAvaliacao, Empresa idempresa, String comentario, String senha, Boolean definicao, Boolean institucionalizacao, Maturidade idmaturidade, Date dataCriacao, Date dataInicio, Date dataFim, List<Avaliador> avaliadorList, List<Ativo> ativoList, List<AvaliacaoGenerica> avaliacaoGenericaList, List<AvaliacaoEspecifica> avaliacaoEspecificaList, PropertyChangeSupport property) {
        this.idAvaliacao = idAvaliacao;
        this.idempresa = idempresa;
        this.idmaturidade = idmaturidade;
    }

    public List<Ativo> getAtivoList() {
        return ativoList;
    }

    public void setAtivoList(List<Ativo> ativoList) {
        List<Ativo> old = this.ativoList;
        this.ativoList = ativoList;
        property.firePropertyChange("ativoList", old, ativoList);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<AvaliacaoEspecifica> getAvaliacaoEspecificaList() {
        return avaliacaoEspecificaList;
    }

    public void setAvaliacaoEspecificaList(List<AvaliacaoEspecifica> avaliacaoEspecificaList) {
        List<AvaliacaoEspecifica> old = this.avaliacaoEspecificaList;
        this.avaliacaoEspecificaList = avaliacaoEspecificaList;
        property.firePropertyChange("avaliacaoEspecificaList", old, avaliacaoEspecificaList);
    }

    public List<AvaliacaoGenerica> getAvaliacaoGenericaList() {
        return avaliacaoGenericaList;
    }

    public void setAvaliacaoGenericaList(List<AvaliacaoGenerica> avaliacaoGenericaList) {
        List<AvaliacaoGenerica> old = this.avaliacaoGenericaList;
        this.avaliacaoGenericaList = avaliacaoGenericaList;
        property.firePropertyChange("avaliacaoGenericaList", old, avaliacaoGenericaList);
    }

    public List<Avaliador> getAvaliadorList() {
        return avaliadorList;
    }

    public void setAvaliadorList(List<Avaliador> avaliadorList) {
        List<Avaliador> old = this.avaliadorList;
        this.avaliadorList = avaliadorList;
        property.firePropertyChange("avaliadorList", old, avaliadorList);
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        String old = this.comentario;
        this.comentario = comentario;
        property.firePropertyChange("comentario", old, comentario);
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        Date old = this.dataCriacao;
        this.dataCriacao = dataCriacao;
        property.firePropertyChange("dataCriacao", old, dataCriacao);
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        Date old = this.dataFim;
        this.dataFim = dataFim;
        property.firePropertyChange("dataFim", old, dataFim);
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        Date old = this.dataInicio;
        this.dataInicio = dataInicio;
        property.firePropertyChange("dataInicio", old, dataInicio);
    }

    public Boolean getDefinicao() {
        return definicao;
    }

    public void setDefinicao(Boolean definicao) {
        Boolean old = this.definicao;
        this.definicao = definicao;
        property.firePropertyChange("definicao", old, definicao);
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        Integer old = this.idAvaliacao;
        this.idAvaliacao = idAvaliacao;
        property.firePropertyChange("idAvaliacao", old, idAvaliacao);
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        Empresa old = this.idempresa;
        this.idempresa = idempresa;
        property.firePropertyChange("idempresa", old, idempresa);
    }

    public Maturidade getIdmaturidade() {
        return idmaturidade;
    }

    public void setIdmaturidade(Maturidade idmaturidade) {
        Maturidade old = this.idmaturidade;
        this.idmaturidade = idmaturidade;
        property.firePropertyChange("idmaturidade", old, idmaturidade);
    }

    public Boolean getInstitucionalizacao() {
        return institucionalizacao;
    }

    public void setInstitucionalizacao(Boolean institucionalizacao) {
        Boolean old = this.institucionalizacao;
        this.institucionalizacao = institucionalizacao;
        property.firePropertyChange("institucionalizacao", old, institucionalizacao);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String old = this.senha;
        this.senha = senha;
        property.firePropertyChange("senha", old, senha);
    }

    public void addPropertyChangeSupport(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeSupport(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Avaliacao)) {
            return false;
        }
        Avaliacao obj = (Avaliacao) arg0;
        if ((obj.getIdAvaliacao() == null || this.getIdAvaliacao() != null) &&
                (obj.getIdAvaliacao() != null || this.getIdAvaliacao() == null) &&
                (!obj.getIdAvaliacao().equals(this.getIdAvaliacao())) &&
                (!obj.getIdAvaliacao().equals(this.getIdAvaliacao())) &&
                (obj.getIdempresa() != null || this.getIdempresa() == null) &&
                !obj.getIdempresa().equals(this.getIdempresa())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idAvaliacao != null ? this.idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return (idAvaliacao + " - " + idempresa.getRazaosocial());
    }
}
