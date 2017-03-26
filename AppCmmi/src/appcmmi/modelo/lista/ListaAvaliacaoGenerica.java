/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.lista;

import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import appcmmi.modelo.ListaModelo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link AvaliacaoGenerica}
 * @author diego
 */
public class ListaAvaliacaoGenerica extends ListaModelo {

    private List<AvaliacaoGenerica> listaGenerica;

    public ListaAvaliacaoGenerica() {
    }

    public ListaAvaliacaoGenerica(List<AvaliacaoGenerica> listaGenerica) {
        this.listaGenerica = listaGenerica;
    }

    @Override
    public void setElementAt(Object objeto, int posicao) {
        listaGenerica.set(posicao,(AvaliacaoGenerica) objeto);
    }

    @Override
    public void addElement(Object objeto) {
        listaGenerica.add((AvaliacaoGenerica) objeto);
    }

    @Override
    public List<AvaliacaoGenerica> getList() {
        return listaGenerica;
    }

    @Override
    public void setList(List lista) {
        listaGenerica = new ArrayList<AvaliacaoGenerica>(lista);
    }

    @Override
    public void removeElementAt(int posicao) {
        listaGenerica.remove(posicao);
    }

    @Override
    public void removeElement(Object objeto) {
        listaGenerica.remove((AvaliacaoGenerica)objeto);
    }

    @Override
    public int getSize() {
        return listaGenerica.size();
    }

    @Override
    public AvaliacaoGenerica getElementAt(int arg0) {
        return (AvaliacaoGenerica) listaGenerica.get(arg0);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

}
