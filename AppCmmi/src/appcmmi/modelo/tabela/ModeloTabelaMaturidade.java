/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.tabela;

import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.modelo.lista.ListaMaturidade;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * Classe que implementa um modelo de tabela utilizando uma lista de {@link Maturidade}
 * @author diego
 */
public class ModeloTabelaMaturidade extends ListaMaturidade implements TableModel {

    private String[] colunas = {"Nível", "Titulo", "Descrição"};

    public ModeloTabelaMaturidade() {
    }

    public ModeloTabelaMaturidade(List<Maturidade> maturidade) {
        super(maturidade);
    }

    @Override
    public int getRowCount() {
        return super.getSize();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
     * Informa o nome da referida coluna
     * @param arg0
     * @return String
     */
    @Override
    public String getColumnName(int arg0) {
        return colunas[arg0];
    }

    /**
     * Retorna a classe da coluna
     * @param arg0
     * @return Class
     */
    @Override
    public Class<?> getColumnClass(int arg0) {
        return colunas[arg0].getClass();
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    /**
     * Retorna valor da linha (arg0) com a coluna (arg1)
     * @param arg0
     * @param arg1
     * @return Object
     */
    @Override
    public Object getValueAt(int arg0, int arg1) {
        if (arg1 == 0) {
            //arg1 igual à coluna ID
            return getNumMaturidade(arg0);
        } else if (arg1 == 1) {
            return getTitulo(arg0);
        } else if (arg1 == 2) {
            //arg1 igual à coluna Descrição
            return getDescricao(arg0);
        } else {
            return "";
        }
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {
        super.setElementAt(arg0, arg1);
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
