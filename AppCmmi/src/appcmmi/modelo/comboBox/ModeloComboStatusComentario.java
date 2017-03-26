/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.comboBox;

import appcmmi.db.facade.avaliacao.StatusComentarioFacade;
import appcmmi.db.pojo.avaliacao.StatusComentario;
import appcmmi.modelo.lista.ListaStatusComentario;
import javax.swing.ComboBoxModel;

/**
 * Classe que implementa um modelo de combobox de {@link StatusComentario}
 * @author diego
 */
public class ModeloComboStatusComentario extends ListaStatusComentario implements ComboBoxModel {

    private StatusComentario statusComentario;

    public ModeloComboStatusComentario() throws Exception {
        super(new StatusComentarioFacade().retornaTodosStatusComentario());
    }

    @Override
    public void setSelectedItem(Object arg0) {
        this.statusComentario = (StatusComentario) arg0;
    }

    @Override
    public StatusComentario getSelectedItem() {
        return this.statusComentario;
    }

}
