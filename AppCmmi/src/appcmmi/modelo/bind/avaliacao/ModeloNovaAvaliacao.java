/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind.avaliacao;

import appcmmi.db.pojo.Ativo;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.Avaliador;
import appcmmi.db.pojo.Empresa;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Modelo de nova avaliação, para preenchimento da tela com empresa, lista de ativos e de avaliadores.
 * @author diego
 * @since 10/11/2009
 */
public class ModeloNovaAvaliacao {

    private PropertyChangeSupport property = new PropertyChangeSupport(this);
    private Avaliacao avaliacao;
    private List<Ativo> ativos;
    private List<Ativo> selecAtivos;
    private List<Avaliador> avaliadores;
    private List<Avaliador> selecAvaliadores;
    private Empresa empresa;
    private boolean editar;

    public ModeloNovaAvaliacao() {
        novaAvaliacao();
    }

    public void novaAvaliacao() {
        editar = false;
        setEmpresa(new Empresa());
        setAvaliacao(new Avaliacao());
        setSelecAtivos(ObservableCollections.observableList(new ArrayList<Ativo>()));
        setSelecAvaliadores(ObservableCollections.observableList(new ArrayList<Avaliador>()));
        ativos = ObservableCollections.observableList(new ArrayList<Ativo>());
        avaliadores = ObservableCollections.observableList(new ArrayList<Avaliador>());
    }

    public void removerAtivos() {
        ativos.removeAll(selecAtivos);
    }

    public void removerAvaliadores() {
        ativos.removeAll(selecAvaliadores);
    }

    public List<Ativo> getSelecAtivos() {
        return selecAtivos;
    }

    public void setSelecAtivos(List<Ativo> selecAtivos) {
        List<Ativo> old = this.ativos;
        this.selecAtivos = selecAtivos;
        property.firePropertyChange("selecAtivos", old, selecAtivos);
    }

    public List<Avaliador> getSelecAvaliadores() {
        return selecAvaliadores;
    }

    public void setSelecAvaliadores(List<Avaliador> selecAvaliadores) {
        List<Avaliador> old = this.avaliadores;
        this.selecAvaliadores = selecAvaliadores;
        property.firePropertyChange("selecAvaliadores", old, selecAvaliadores);
    }

    /**
     * Retorna a lista de ativos
     * @return List
     */
    public List<Ativo> getAtivos() {
        return ativos;
    }

    /**
     * Preenche a lista com ativos de uma empresa
     * @param ativos
     */
    public void setAtivos(List<Ativo> ativos) {
        List<Ativo> old = this.ativos;
        this.ativos = ObservableCollections.observableList(ativos);
        property.firePropertyChange("ativos", old, this.ativos);
    }

    /**
     * Retorna a Avaliação
     * @return Avaliacao
     */
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    /**
     * Preenche um objeto de Avaliação
     * @param avaliacao
     */
    public void setAvaliacao(Avaliacao avaliacao) {
        Avaliacao old = this.avaliacao;
        this.avaliacao = avaliacao;
        property.firePropertyChange("avaliacao", old, avaliacao);
    }

    /**
     * Retorna a lista de avaliadores
     * @return List
     */
    public List<Avaliador> getAvaliadores() {
        return avaliadores;
    }

    /**
     * Preenche a lista com avaliadores
     * @param avaliadores
     */
    public void setAvaliadores(List<Avaliador> avaliadores) {
        List<Avaliador> old = this.avaliadores;
        this.avaliadores = ObservableCollections.observableList(avaliadores);
        property.firePropertyChange("avaliadores", old, avaliadores);
    }

    /**
     * Retorna a empresa
     * @return Empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Preenche a empresa selecionada para a nova avaliação
     * @param empresa
     */
    public void setEmpresa(Empresa empresa) {
        Empresa old = this.empresa;
        this.empresa = empresa;
        if (empresa != null && empresa.getIdempresa() != null && empresa.getIdempresa() > 0) {
            setEditar(true);
        } else {
            setEditar(false);
        }
        property.firePropertyChange("empresa", old, empresa);
    }

    /**
     * Retorna se a tela está permitindo editar demais campos.
     * @return boolean
     */
    public boolean isEditar() {
        return editar;
    }

    /**
     * Insere a permição de edição dos demais campos.
     * @param editar
     */
    public void setEditar(boolean editar) {
        boolean old = this.editar;
        this.editar = editar;
        property.firePropertyChange("editar", old, editar);
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
