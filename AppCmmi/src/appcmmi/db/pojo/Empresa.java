/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.pojo;

import appcmmi.db.pojo.avaliacao.Avaliacao;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Index;

/**
 * Classe da tabela Empresa.
 * @author diego
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

    @Transient
    private final PropertyChangeSupport property = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEMPRESA")
    private Integer idempresa;
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL", length = 128)
    private String razaosocial;
    @Column(name = "NOMEFANTASIA", length = 128)
    @Basic(optional = false)
    private String nomefantasia;
    @Column(name = "CNPJ")
    @Index(name="cnpj")
    private long cnpj;
    @Column(name = "INSCRICAOESTADUAL")
    @Index(name="insestadual")
    private BigInteger inscricaoestadual;
    @Column(name = "ENDERECO", length = 64)
    private String endereco;
    @Column(name = "NUMERO")
    private int numero;
    @Column(name = "COMPLEMENTO", length = 64)
    private String complemento;
    @Column(name = "TELEFONE", length = 32)
    private String telefone;
    @Column(name = "CONTATO", length = 64)
    @Basic(optional = false)
    private String contato;
    @Column(name = "EMAIL", length = 64)
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    @Column(name = "PATROCINADOR", length = 128)
    private String patrocinador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresa")
    @OrderBy("nome")
    private List<Ativo> ativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempresa")
    private List<Avaliacao> avaliacaoList;

    public Empresa() {
    }

    public Empresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public Empresa(Integer idempresa, String razaosocial, long cnpj, String endereco, int numero, String telefone) {
        this.idempresa = idempresa;
        this.razaosocial = razaosocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        Integer old = this.idempresa;
        this.idempresa = idempresa;
        property.firePropertyChange("idempresa", old, idempresa);
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        String old = this.razaosocial;
        this.razaosocial = razaosocial.toUpperCase();
        property.firePropertyChange("razaosocial", old, razaosocial);
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        String old = this.nomefantasia;
        this.nomefantasia = nomefantasia.toUpperCase();
        property.firePropertyChange("nomefantasia", old, nomefantasia);
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        long old = this.cnpj;
        this.cnpj = cnpj;
        property.firePropertyChange("cnpj", old, cnpj);
    }

    public BigInteger getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(BigInteger inscricaoestadual) {
        BigInteger old = this.inscricaoestadual;
        this.inscricaoestadual = inscricaoestadual;
        property.firePropertyChange("inscricaoestadual", old, inscricaoestadual);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String old = this.endereco;
        this.endereco = endereco.toUpperCase();
        property.firePropertyChange("endereco", old, endereco);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        int old = this.numero;
        this.numero = numero;
        property.firePropertyChange("numero", old, numero);
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        String old = this.complemento;
        this.complemento = complemento.toUpperCase();
        property.firePropertyChange("complemento", old, complemento);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String old = this.telefone;
        this.telefone = telefone;
        property.firePropertyChange("telefone", old, telefone);
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        String old = this.contato;
        this.contato = contato.toUpperCase();
        property.firePropertyChange("contato", old, contato);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String old = this.email;
        this.email = email.toLowerCase();
        property.firePropertyChange("email", old, email);
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        String old = this.patrocinador;
        this.patrocinador = patrocinador.toUpperCase();
        property.firePropertyChange("patrocinador", old, patrocinador);
    }

    public List<Ativo> getAtivoList() {
        return ativoList;
    }

    public void setAtivoList(List<Ativo> projetoList) {
        List<Ativo> old = this.ativoList;
        this.ativoList = projetoList;
        property.firePropertyChange("ativoList", old, ativoList);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresa != null ? idempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idempresa == null && other.idempresa != null) || (this.idempresa != null && !this.idempresa.equals(other.idempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idempresa + " - " + razaosocial;
    }

    /**
     * Adiciona um escutador de mudança de propriedade
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    /**
     * Remove um escutador de mudança de propriedade
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
