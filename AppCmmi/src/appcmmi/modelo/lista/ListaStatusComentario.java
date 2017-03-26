/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.lista;

import appcmmi.db.pojo.avaliacao.StatusComentario;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 * Classe que implementa um modelo de lista de {@link StatusComentario}
 * @author diego
 */
public class ListaStatusComentario implements ListModel {

    private List<StatusComentario> listaStatus;

    public ListaStatusComentario(List<StatusComentario> listaStatus) {
        this.listaStatus = listaStatus;
    }

    @Override
    public int getSize() {
        return listaStatus.size();
    }

    @Override
    public StatusComentario getElementAt(int arg0) {
        return listaStatus.get(arg0);
    }

    @Override
    public void addListDataListener(ListDataListener arg0) {
    }

    @Override
    public void removeListDataListener(ListDataListener arg0) {
    }

}
