/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.avaliacao;

import appcmmi.db.pojo.artefato.ArtefatoEspecifica;
import appcmmi.db.pojo.Ativo;
import appcmmi.db.pojo.artefato.ArtefatoGenerica;
import appcmmi.db.pojo.artefato.TipoArtefato;
import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link ArtefatoGenerica}, {@link ArtefatoEspecifica} e {@link Ativo}
 * @author diego
 */
public class ModeloArtefato {

    private List<ArtefatoEspecifica> listaArtefatoEspecifica;
    private List<ArtefatoGenerica> listaArtefatoGenerica;
    private List<TipoArtefato> listaTipoArtefato;
    private TipoArtefato tipoArtefato;
    private ArtefatoEspecifica artefatoEspecifica;
    private ArtefatoGenerica artefatoGenerica;
    private List<Ativo> listaAtivo;
    private Ativo ativo;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloArtefato() {
        listaTipoArtefato = new ArrayList<TipoArtefato>();
        listaAtivo = new ArrayList<Ativo>();
        artefatoEspecifica = new ArtefatoEspecifica();
        artefatoGenerica = new ArtefatoGenerica();
        listaArtefatoEspecifica = ObservableCollections.observableList(new ArrayList<ArtefatoEspecifica>());
        listaArtefatoGenerica = ObservableCollections.observableList(new ArrayList<ArtefatoGenerica>());
        tipoArtefato = new TipoArtefato();
        ativo = new Ativo();
    }

    public void novoArtefatoEspecifica(String descricao, AvaliacaoEspecifica especifica) {
        List<ArtefatoEspecifica> lista = getListaArtefatoEspecifica();
        ArtefatoEspecifica artefato = new ArtefatoEspecifica();
        artefato.setDescricao(descricao);
        artefato.setIdAvaliacaoEspecifica(especifica);
        artefato.setIdTipoArtefato(getTipoArtefato());
        lista.add(artefato);
        setListaArtefatoEspecifica(listaArtefatoEspecifica);
        //setArtefatoEspecifica(new ArtefatoEspecifica());
    }

    public void novoArtefatoGenerico(String descricao, AvaliacaoGenerica generica) {
        ArtefatoGenerica artefato = new ArtefatoGenerica();
        List<ArtefatoGenerica> lista = getListaArtefatoGenerica();
        artefato.setDescricao(descricao);
        artefato.setIdavaliacaogenerica(generica);
        artefato.getIdTipoArtefato();
        lista.add(artefato);
        setListaArtefatoGenerica(listaArtefatoGenerica);
        setArtefatoGenerica(new ArtefatoGenerica());
    }

    public ArtefatoEspecifica getArtefatoEspecifica() {
        return artefatoEspecifica;
    }

    public void setArtefatoEspecifica(ArtefatoEspecifica artefatoEspecifica) {
        ArtefatoEspecifica old = this.artefatoEspecifica;
        this.artefatoEspecifica = artefatoEspecifica;
        property.firePropertyChange("artefatoEspecifica", old, artefatoEspecifica);
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        Ativo old = this.ativo;
        this.ativo = ativo;
        property.firePropertyChange("ativo", old, ativo);
    }

    public List<TipoArtefato> getListaTipoArtefato() {
        return listaTipoArtefato;
    }

    public void setListaTipoArtefato(List<TipoArtefato> listaArtefato) {
        List<TipoArtefato> old = this.listaTipoArtefato;
        this.listaTipoArtefato = listaArtefato;
        property.firePropertyChange("listaTipoArtefato", old, listaArtefato);
        if (this.listaTipoArtefato.size() > 0) {
            setTipoArtefato(listaTipoArtefato.get(0));
        }
    }

    public List<Ativo> getListaAtivo() {
        return listaAtivo;
    }

    public void setListaAtivo(List<Ativo> listaAtivo) {
        List<Ativo> old = this.listaAtivo;
        this.listaAtivo = listaAtivo;
        property.firePropertyChange("listaAtivo", old, listaAtivo);
    }

    public TipoArtefato getTipoArtefato() {
        return tipoArtefato;
    }

    public void setTipoArtefato(TipoArtefato tipoArtefato) {
        TipoArtefato old = this.tipoArtefato;
        this.tipoArtefato = tipoArtefato;
        property.firePropertyChange("tipoArtefato", old, tipoArtefato);
    }

    public List<ArtefatoEspecifica> getListaArtefatoEspecifica() {
        return listaArtefatoEspecifica;
    }

    public void setListaArtefatoEspecifica(List<ArtefatoEspecifica> listaArtefatoEspecifica) {
        List<ArtefatoEspecifica> old = this.listaArtefatoEspecifica;
        this.listaArtefatoEspecifica = ObservableCollections.observableList(listaArtefatoEspecifica);
        property.firePropertyChange("listaArtefatoEspecifica", old, listaArtefatoEspecifica);
    }

    public ArtefatoGenerica getArtefatoGenerica() {
        return artefatoGenerica;
    }

    public void setArtefatoGenerica(ArtefatoGenerica artefatoGenerica) {
        ArtefatoGenerica old = this.artefatoGenerica;
        this.artefatoGenerica = artefatoGenerica;
        property.firePropertyChange("artefatoGenerica", old, artefatoGenerica);
    }

    public List<ArtefatoGenerica> getListaArtefatoGenerica() {
        return listaArtefatoGenerica;
    }

    public void setListaArtefatoGenerica(List<ArtefatoGenerica> listaArtefatoGenerica) {
        List<ArtefatoGenerica> old = this.listaArtefatoGenerica;
        this.listaArtefatoGenerica = ObservableCollections.observableList(listaArtefatoGenerica);
        property.firePropertyChange("listaArtefatoGenerica", old, listaArtefatoGenerica);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
    
}
