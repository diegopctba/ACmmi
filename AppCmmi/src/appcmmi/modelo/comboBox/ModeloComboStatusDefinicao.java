/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.comboBox;

import appcmmi.db.facade.avaliacao.StatusFacade;
import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import appcmmi.modelo.lista.ListaStatus;
import javax.swing.ComboBoxModel;

/**
 * Modelo de implementação de interface de combobox, responsável pela utilização do objeto Status
 * @author diego
 * @since 14/11/2009
 */
public class ModeloComboStatusDefinicao extends ListaStatus implements ComboBoxModel {

    private StatusDefinicao status;

    public ModeloComboStatusDefinicao() throws Exception {
        setList(new StatusFacade().retornaTodosStatus());
    }

    /**
     * Indica o Status selecionado.
     * @param Status
     */
    @Override
    public void setSelectedItem(Object arg0) {
        this.status = (StatusDefinicao) arg0;
    }

    /**
     * Retorna o Status selecionado.
     * @return Status
     */
    @Override
    public StatusDefinicao getSelectedItem() {
        return status;
    }

}
