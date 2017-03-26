/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.lista;

import appcmmi.db.pojo.modelo.PraticaGenerica;
import appcmmi.modelo.ListaModelo;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link PraticaGenerica}
 * @author diego
 */
public class ListaGenerica extends ListaModelo {

    private List<PraticaGenerica> generica;

    public ListaGenerica() {
    }

    public ListaGenerica(List<PraticaGenerica> generica) {
        this.generica = generica;
    }

    @Override
    public void setElementAt(Object objeto, int posicao) {
        generica.set(posicao, (PraticaGenerica)objeto);
    }

    @Override
    public void addElement(Object objeto) {
        generica.add((PraticaGenerica)objeto);
    }

    @Override
    public List<PraticaGenerica> getList() {
        return generica;
    }

    @Override
    public void setList(List lista) {
        generica = lista;
    }

    @Override
    public int getSize() {
        int size = 0;
        if (generica != null) {
            size = generica.size();
        }
        return size;
    }

    @Override
    public PraticaGenerica getElementAt(int arg0) {
        return (PraticaGenerica) generica.get(arg0);
    }

    @Override
    public void removeElement(Object praticagenerica) {
        generica.remove((PraticaGenerica)praticagenerica);
    }

    @Override
    public void removeElementAt(int posicao) {
        generica.remove(posicao);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

}
