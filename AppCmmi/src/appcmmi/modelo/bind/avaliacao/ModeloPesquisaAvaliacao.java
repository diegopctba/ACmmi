/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.avaliacao;

import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.modelo.Maturidade;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link Avaliacao} e {@link Maturidade}
 * @author diego
 */
public class ModeloPesquisaAvaliacao {

    private List<Avaliacao> listaAvaliacao;
    private List<Maturidade> listaMaturidade;
    private Integer idEmpresa;
    private Maturidade maturidade;
    private String criacaoDe;
    private String criacaoAte;
    private Boolean definicao;
    private Boolean institucionalizacao;
    private Avaliacao avaliacao;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloPesquisaAvaliacao() {
        listaAvaliacao = ObservableCollections.observableList(new ArrayList<Avaliacao>());
    }

    public ModeloPesquisaAvaliacao(List<Maturidade> maturidades) {
        listaAvaliacao = ObservableCollections.observableList(new ArrayList<Avaliacao>());
        setListaMaturidade(maturidades);
    }

    public Boolean isInstitucionalizacao() {
        return institucionalizacao;
    }

    public void setInstitucionalizacao(Boolean institucionalizacao) {
        Boolean old = this.institucionalizacao;
        this.institucionalizacao = institucionalizacao;
        property.firePropertyChange("institucionalizacao", old, institucionalizacao);
    }

    public String getCriacaoAte() {
        return criacaoAte;
    }

    public void setCriacaoAte(String criacaoAte) {
        String old = this.criacaoAte;
        this.criacaoAte = criacaoAte;
        property.firePropertyChange("criacaoAte", old, criacaoAte);
    }

    public String getCriacaoDe() {
        return criacaoDe;
    }

    public void setCriacaoDe(String criacaoDe) {
        String old = this.criacaoDe;
        this.criacaoDe = criacaoDe;
        property.firePropertyChange("criacaoDe", old, criacaoDe);
    }

    public Boolean isDefinicao() {
        return definicao;
    }

    public void setDefinicao(Boolean definicao) {
        Boolean old = this.definicao;
        this.definicao = definicao;
        property.firePropertyChange("definicao", old, definicao);
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        Integer old = this.idEmpresa;
        this.idEmpresa = idEmpresa;
        property.firePropertyChange("idEmpresa", old, idEmpresa);
    }

    public Maturidade getMaturidade() {
        return maturidade;
    }

    public void setMaturidade(Maturidade maturidade) {
        Maturidade old = this.maturidade;
        this.maturidade = maturidade;
        property.firePropertyChange("maturidade", old, maturidade);
    }

    public List<Avaliacao> getListaAvaliacao() {
        return listaAvaliacao;
    }

    public void setListaAvaliacao(List<Avaliacao> listaAvaliacao) {
        List<Avaliacao> old = this.listaAvaliacao;
        this.listaAvaliacao = ObservableCollections.observableList(listaAvaliacao);
        //this.listaAvaliacao = listaAvaliacao;
        property.firePropertyChange("listaAvaliacao", old, listaAvaliacao);
    }

    public List<Maturidade> getListaMaturidade() {
        return listaMaturidade;
    }

    public void setListaMaturidade(List<Maturidade> listaMaturidade) {
        List<Maturidade> old = this.listaMaturidade;
        //listaMaturidade.add(0, new Maturidade());
        this.listaMaturidade = listaMaturidade;
        property.firePropertyChange("listaMaturidade", old, listaMaturidade);
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        Avaliacao old = this.avaliacao;
        this.avaliacao = avaliacao;
        property.firePropertyChange("avaliacao", old, avaliacao);
    }

    public void addPropertyChangeSupport(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeSupport(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

}
