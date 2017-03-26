/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo;

import java.util.List;
import javax.swing.ListModel;

/**
 * Classe abstrata que implementa a interface {@link ListModel},
 * para utilização com classes responsáveis pela manipulação de listas,
 * como {@link ComboBoxModel}, {@link TableModel} e {@link JList}.
 * @author diego
 */
public abstract class ListaModelo<T> implements ListModel {

     public abstract void setElementAt(Object objeto, int posicao);

     public abstract void addElement(Object objeto);

     public abstract List<T> getList();

     public abstract void setList(List<T> lista);

     public abstract void removeElementAt(int posicao);

    public abstract void removeElement(Object objeto);
}
