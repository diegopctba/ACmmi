/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.artefato;

import appcmmi.db.pojo.artefato.TipoArtefato;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link TipoArtefato}
 * @author diego
 */
public class ModeloTipoArtefato {

    private TipoArtefato tipoArtefato;
    private List<TipoArtefato> listaTipoArtefato;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloTipoArtefato() {
        tipoArtefato = new TipoArtefato();
        listaTipoArtefato = ObservableCollections.observableList(new ArrayList<TipoArtefato>());
    }

    public void novoTipoArtefato(String descricao) {
        TipoArtefato novo = new TipoArtefato();
        List<TipoArtefato> lista = getListaTipoArtefato();
        novo.setDescricao(descricao);
        lista.add(novo);
        setListaTipoArtefato(lista);
        if (listaTipoArtefato.size() > 0) {
            setTipoArtefato(listaTipoArtefato.get(0));
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    public List<TipoArtefato> getListaTipoArtefato() {
        return listaTipoArtefato;
    }

    public void setListaTipoArtefato(List<TipoArtefato> listaTipoArtefato) {
        List<TipoArtefato> old = this.listaTipoArtefato;
        this.listaTipoArtefato = ObservableCollections.observableList(listaTipoArtefato);
        property.firePropertyChange("listaTipoArtefato", old, listaTipoArtefato);
        if (this.listaTipoArtefato.size() > 0) {
            setTipoArtefato(listaTipoArtefato.get(0));
        }
    }

    public TipoArtefato getTipoArtefato() {
        return tipoArtefato;
    }

    public void setTipoArtefato(TipoArtefato tipoArtefato) {
        TipoArtefato old = this.tipoArtefato;
        this.tipoArtefato = tipoArtefato;
        property.firePropertyChange("tipoArtefato", old, tipoArtefato);
    }

    public void removerTipo(TipoArtefato tipoArtefato) {
        listaTipoArtefato.remove(tipoArtefato);
    }

}
