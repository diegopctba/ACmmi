/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.comboBox;

import appcmmi.db.facade.avaliacao.StatusInstitucionalizacaoFacade;
import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import appcmmi.modelo.lista.ListaStatusInstitucionalizacao;
import javax.swing.ComboBoxModel;

/**
 * Modelo de implementação de interface de combobox, responsável pela utilização do objeto Status
 * @author diego
 * @since 14/11/2009
 */
public class ModeloComboStatusInstitucionalizacao extends ListaStatusInstitucionalizacao implements ComboBoxModel {

    private StatusInstitucionalizacao status;

    public ModeloComboStatusInstitucionalizacao() throws Exception {
        setList(new StatusInstitucionalizacaoFacade().retornaTodosStatus());
    }

    /**
     * Indica o Status selecionado.
     * @param Status
     */
    @Override
    public void setSelectedItem(Object arg0) {
        this.status = (StatusInstitucionalizacao) arg0;
    }

    /**
     * Retorna o Status selecionado.
     * @return Status
     */
    @Override
    public StatusInstitucionalizacao getSelectedItem() {
        return status;
    }
}
