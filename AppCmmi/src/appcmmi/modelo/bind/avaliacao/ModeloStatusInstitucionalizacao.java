/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.avaliacao;

import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link StatusInstitucionalizacao}
 * @author diego
 */
public class ModeloStatusInstitucionalizacao {

    private StatusInstitucionalizacao status;
    private List<StatusInstitucionalizacao> listaStatus;
    private PropertyChangeSupport property = new PropertyChangeSupport(this);

    public ModeloStatusInstitucionalizacao() {
        listaStatus = ObservableCollections.observableList(new ArrayList<StatusInstitucionalizacao>());
        status = new StatusInstitucionalizacao();
    }

    public void novoStatus(String descricao, String sigla) {
        StatusInstitucionalizacao novo = new StatusInstitucionalizacao();
        List<StatusInstitucionalizacao> lista = getListaStatus();
        novo.setDescricao(descricao);
        novo.setSigla(sigla);
        lista.add(novo);
        setListaStatus(lista);
    }

    public void excluirStatus(StatusInstitucionalizacao status) {
        listaStatus.remove(status);
    }

    public List<StatusInstitucionalizacao> getListaStatus() {
        return listaStatus;
    }

    public void setListaStatus(List<StatusInstitucionalizacao> listaStatus) {
        List<StatusInstitucionalizacao> old = this.listaStatus;
        this.listaStatus = ObservableCollections.observableList(listaStatus);
        property.firePropertyChange("listaStatus", old, listaStatus);
    }

    public StatusInstitucionalizacao getStatus() {
        return status;
    }

    public void setStatus(StatusInstitucionalizacao status) {
        StatusInstitucionalizacao old = this.status;
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
