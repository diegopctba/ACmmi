/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.avaliacao;

import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link StatusDefinicao}
 * @author diego
 */
public class ModeloStatusPratica {

    private StatusDefinicao status;
    private List<StatusDefinicao> listaStatus;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloStatusPratica() {
        listaStatus = ObservableCollections.observableList(new ArrayList<StatusDefinicao>());
        status = new StatusDefinicao();
    }

    public void novoStatus(String descricao, String sigla) {
        StatusDefinicao novo = new StatusDefinicao();
        List<StatusDefinicao> lista = getListaStatus();
        novo.setDescricao(descricao);
        novo.setSigla(sigla);
        lista.add(novo);
        setListaStatus(lista);
    }

    public void excluirStatus(StatusDefinicao status) {
        listaStatus.remove(status);
    }

    public List<StatusDefinicao> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(List<StatusDefinicao> listaStatus) {
        List<StatusDefinicao> old = this.listaStatus;
        this.listaStatus = ObservableCollections.observableList(listaStatus);
        property.firePropertyChange("listaStatus", old, listaStatus);
    }

    public StatusDefinicao getStatus() {
        return status;
    }

    public void setStatus(StatusDefinicao status) {
        StatusDefinicao old = this.status;
        this.status = status;
        property.firePropertyChange("status", old, status);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
