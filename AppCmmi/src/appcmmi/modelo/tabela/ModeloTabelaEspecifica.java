/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.tabela;

import appcmmi.db.pojo.modelo.PraticaEspecifica;
import appcmmi.modelo.lista.ListaEspecifica;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Classe que implementa um modelo de tabela utilizando uma lista de {@link PraticaEspecifica}
 * @author diego
 */
public class ModeloTabelaEspecifica extends ListaEspecifica implements TableModel {

    private String[] colunas = {"SP", "Descrição", "Área de Processo"};

    public ModeloTabelaEspecifica(List<PraticaEspecifica> lista) {
        super(lista);
    }

    @Override
    public int getRowCount() {
        return super.getSize();
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
            return getElementAt(arg0).getNumpraticaespecifica();
        } else if (arg1 == 1) {
            return getElementAt(arg0).getTitulo();
        } else if (arg1 == 2) {
            return getElementAt(arg0).getIdareaprocesso().getTitulo();
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
