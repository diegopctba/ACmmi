/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.bind;

import appcmmi.db.pojo.Empresa;
import appcmmi.db.pojo.Ativo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 * Modelo que implementa os recursos de binding de Projeto
 * @author diego
 */
public class ModeloAtivo {

    private PropertyChangeSupport property = new PropertyChangeSupport(this);
    private List<Ativo> listaAtivo;
    private Ativo ativo;
    private Empresa empresa;
    private List<Ativo> selecionados;

    public ModeloAtivo() {
        listaAtivo = ObservableCollections.observableList(new ArrayList<Ativo>());
    }

    /**
     * Retorna a lista de Ativo
     * @return List
     */
    public List<Ativo> getListaAtivo() {
        return listaAtivo;
    }

    /**
     * Retorna a empresa selecionada
     * @return Empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Retorna os Ativos selecionados na tela
     * @return List
     */
    public List<Ativo> getSelecionados() {
        return selecionados;
    }

    /**
     * Informa os itens selecionados na tela
     * @param selecionados
     */
    public void setSelecionados(List<Ativo> selecionados) {
        List<Ativo> old = this.selecionados;
        this.selecionados = selecionados;
        property.firePropertyChange("selecionados", old, selecionados);
    }

    /**
     * Preenche a Empresa a ser utilizada na tela.
     * @param empresa
     */
    public void setEmpresa(Empresa empresa) {
        Empresa old = this.empresa;
        this.empresa = empresa;
        property.firePropertyChange("empresa", old, empresa);
        if (this.empresa != null && this.empresa.getAtivoList() != null &&
                !this.empresa.getAtivoList().isEmpty()) {
            setListaAtivo(empresa.getAtivoList());
        } else {
            setListaAtivo(ObservableCollections.observableList(new ArrayList<Ativo>()));
        }
    }

    /**
     * Adiciona os valores de Ativo na lista
     * @param listaAtivo
     */
    public void setListaAtivo(List<Ativo> listaAtivo) {
        List<Ativo> old = this.listaAtivo;
        this.listaAtivo = ObservableCollections.observableList(listaAtivo);
        property.firePropertyChange("listaAtivo", old, listaAtivo);
    }

    /**
     * Retorna o Ativo selecionado
     * @return Ativo
     */
    public Ativo getProjeto() {
        return ativo;
    }

    /**
     * Preenche o Ativo
     * @param projeto
     */
    public void setProjeto(Ativo projeto) {
        Ativo old = this.ativo;
        this.ativo = projeto;
        property.firePropertyChange("ativo", old, projeto);
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

    /**
     * Insere um novo Ativo na lista
     */
    public void novoProjeto() {
        Ativo novo = new Ativo();
        listaAtivo.add(novo);
        setProjeto(novo);
    }

    /**
     * Exclui Ativo selecionado
     */
    public void excluirProjeto() {
        listaAtivo.remove(ativo);
        setProjeto(listaAtivo.get(0));
    }

    /**
     * Adiciona um novo Ativo de acordo com o parâmetro passado
     * @param text
     */
    public void novoProjeto(String text) {
        Ativo novo = new Ativo();
        novo.setDescricao(text);
        novo.setIdempresa(this.empresa);
        listaAtivo.add(novo);
        setProjeto(novo);
    }
}
