/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.lista;

import appcmmi.db.pojo.modelo.PraticaEspecifica;
import appcmmi.modelo.ListaModelo;
import java.util.List;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link PraticaEspecifica}
 * @author diego
 */
public class ListaEspecifica extends ListaModelo {

    private List<PraticaEspecifica> especifica;

    public ListaEspecifica() {
    }

    public ListaEspecifica(List<PraticaEspecifica> especifica) {
        this.especifica = especifica;
    }

    @Override
    public void setElementAt(Object objeto, int posicao) {
        especifica.set(posicao, (PraticaEspecifica) objeto);
    }

    @Override
    public void addElement(Object objeto) {
        especifica.add((PraticaEspecifica) objeto);
    }

    @Override
    public List<PraticaEspecifica> getList() {
        return especifica;
    }

    @Override
    public void setList(List lista) {
        especifica = lista;
    }

    @Override
    public int getSize() {
        int size = 0;
        if (especifica != null) {
            size = especifica.size();
        }
        return size;
    }

    @Override
    public void removeElementAt(int posicao) {
        especifica.remove(posicao);
    }

    @Override
    public void removeElement(Object esp) {
        especifica.remove((PraticaEspecifica) esp);
    }

    @Override
    public PraticaEspecifica getElementAt(int arg0) {
        return (PraticaEspecifica) especifica.get(arg0);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }
}
