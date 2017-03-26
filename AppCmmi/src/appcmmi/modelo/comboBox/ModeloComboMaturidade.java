/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.comboBox;

import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.modelo.lista.ListaMaturidade;
import java.util.List;
import javax.swing.ComboBoxModel;

/**
 * Classe que implementa um modelo de combobox de {@link Maturidade}
 * @author diego
 */
public class ModeloComboMaturidade extends ListaMaturidade implements ComboBoxModel {

    private Maturidade itemSelecionado;

    public ModeloComboMaturidade(List<Maturidade> lista) {
        super(lista);
    }

    @Override
    public Maturidade getElementAt(int arg0) {
        return super.getElementAt(arg0);
    }

    @Override
    public void setSelectedItem(Object arg0) {
        itemSelecionado = (Maturidade) arg0;
    }

    @Override
    public Maturidade getSelectedItem() {
        return (Maturidade) itemSelecionado;
    }

}
