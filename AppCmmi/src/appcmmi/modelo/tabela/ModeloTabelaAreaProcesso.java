/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.modelo.tabela;

import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.modelo.lista.ListaAreaProcesso;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Manipula os dados de uma tabela responsável por {@link AreaProcesso}
 * @author diego
 */
public class ModeloTabelaAreaProcesso extends ListaAreaProcesso implements TableModel {

    private String[] colunas = {"Núm", "Sigla", "Título", "Maturidade"};

    public ModeloTabelaAreaProcesso() {
    }

    public ModeloTabelaAreaProcesso(List<AreaProcesso> lista) {
        super(lista);
    }

    @Override
    public int getRowCount() {
        return getSize();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int arg0) {
        return colunas[arg0];
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return colunas[arg0].getClass();
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        if (arg1 == 0) {
            return getNumAreaProcesso(arg0);
        } else if (arg1 == 1) {
            return getSigla(arg0);
        } else if (arg1 == 2) {
            return getTitulo(arg0);
        } else if (arg1 ==3) {
          return getMaturidade(arg0);
        } else {
            return "";
        }
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
    }

}
