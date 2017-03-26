/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.comboBox;

import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.modelo.lista.ListaAreaProcesso;
import java.util.List;
import javax.swing.ComboBoxModel;

/**
 * Classe que implementa um modelo de combobox de {@link AreaProcesso}
 * @author diego
 */
public class ModeloComboAreaProcesso extends ListaAreaProcesso implements ComboBoxModel {

    private AreaProcesso itemSelecionado;

    public ModeloComboAreaProcesso(List<AreaProcesso> lista) {
        setList(lista);
    }

    @Override
    public void setSelectedItem(Object arg0) {
        itemSelecionado = (AreaProcesso) arg0;
    }

    @Override
    public AreaProcesso getSelectedItem() {
        return itemSelecionado;
    }
}
