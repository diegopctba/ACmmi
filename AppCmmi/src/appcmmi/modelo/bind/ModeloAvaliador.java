/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind;

import appcmmi.db.pojo.Avaliador;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Modelo que implementa os recursos de binding da classe Avaliador
 * @author diego
 * @since 06/11/2009
 */
public class ModeloAvaliador {

    private List<Avaliador> listaAvaliador;
    private Avaliador avaliador;
    private boolean editar;
    private List<Avaliador> selecionados;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloAvaliador() {
        listaAvaliador = ObservableCollections.observableList(new ArrayList<Avaliador>());
        editar = true;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        Avaliador old = this.avaliador;
        this.avaliador = avaliador;
        property.firePropertyChange("avaliador", old, avaliador);
    }

    public List<Avaliador> getSelecionados() {
        return selecionados;
    }

    public void setSelecionados(List<Avaliador> selecionados) {
        List<Avaliador> old = this.getSelecionados();
        this.selecionados = selecionados;
        property.firePropertyChange("selecionados", old, selecionados);
    }

    public List<Avaliador> getListaAvaliador() {
        return listaAvaliador;
    }

    public void setListaAvaliador(List<Avaliador> listaAvaliador) {
        List<Avaliador> old = this.listaAvaliador;
        this.listaAvaliador = ObservableCollections.observableList(listaAvaliador);
        property.firePropertyChange("listaAvaliador", old, this.listaAvaliador);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        boolean old = this.editar;
        this.editar = editar;
        property.firePropertyChange("editar", old, editar);
    }

    /**
     * Insere um novo Avaliador na listaAvaliador
     */
    public void novoAvaliador() {
        Avaliador novo = new Avaliador();
        //listaAvaliador.add(novo);
        setAvaliador(novo);
        setEditar(true);
    }

    /**
     * Recebe Avaliador que será inserdio na listaAvaliador
     * @param avaliador
     */
    public void novoAvaliador(Avaliador avaliador) {
        listaAvaliador.add(avaliador);
        setAvaliador(avaliador);
        setEditar(true);
    }

    /**
     * Remove avaliador selecionado em <i>avaliador</i>
     */
    public void removeAvaliador() {
        listaAvaliador.remove(avaliador);
    }
}
