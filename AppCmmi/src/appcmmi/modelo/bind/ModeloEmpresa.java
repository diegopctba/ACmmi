/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.bind;

import appcmmi.db.pojo.Empresa;
import appcmmi.funcoes.Funcoes;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Vincula um modelo para {@link Empresa}
 * @author diego
 */
public class ModeloEmpresa {

    private PropertyChangeSupport property = new PropertyChangeSupport(this);
    private List<Empresa> listaEmpresa;
    private Empresa empresa;
    private boolean editar;

    public ModeloEmpresa() {
        listaEmpresa = ObservableCollections.observableList(new ArrayList<Empresa>());
        editar = true;
    }

    public ModeloEmpresa(List<Empresa> lista) {
        listaEmpresa = ObservableCollections.observableList(lista);
    }

    public void novaEmpresa() {
        Empresa nova = new Empresa();
        setEmpresa(nova);
        setEditar(true);
    }

    public void excluirEmpresa() {
        if (listaEmpresa.isEmpty()) {
            Funcoes.erro("Erro", "Não existe item na lista para ser removido");
        } else {
            listaEmpresa.remove(empresa);
            empresa = listaEmpresa.get(0);
        }
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        boolean old = this.editar;
        this.editar = editar;
        property.firePropertyChange("editar", old, editar);
    }

    public void setEmpresa(Empresa empresa) {
        Empresa old = this.empresa;
        this.empresa = empresa;
        property.firePropertyChange("empresa", old, empresa);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        List<Empresa> old = this.listaEmpresa;
        this.listaEmpresa = ObservableCollections.observableList(listaEmpresa);
        property.firePropertyChange("listaEmpresa", old, listaEmpresa);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
