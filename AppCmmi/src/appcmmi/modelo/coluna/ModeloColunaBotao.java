/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.modelo.coluna;

import appcmmi.PrincipalFrame;
import appcmmi.db.pojo.Ativo;
import appcmmi.form.avaliacao.artefato.TelaArtefato;
import appcmmi.modelo.ListaModelo;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoEspecifica;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoGenerica;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * Classe responsável pela ação do botão inserido nas tabelas na {@link TelaAvaliacao}
 * @author diego
 */
public class ModeloColunaBotao extends AbstractCellEditor implements TableCellEditor, TableCellRenderer, ActionListener {

    private JTable tabela;
    private JButton botao;
    private String texto;
    private List<Ativo> listaAtivo;

    public ModeloColunaBotao(JTable tabela, int column, List<Ativo> listaativo) {
        super();
        this.tabela = tabela;
        this.listaAtivo = listaativo;
        botao = new JButton("teste");
        botao.setFocusPainted(false);
        botao.setFocusable(false);
        botao.addActionListener(this);
        botao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcmmi/form/imagem/anexar.png")));
        TableColumnModel modelColumn = tabela.getColumnModel();
        modelColumn.getColumn(column).setCellEditor(this);
        modelColumn.getColumn(column).setCellRenderer(this);
    }


    @Override
    public Object getCellEditorValue() {
        return texto;
    }

    @Override
    public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
        texto = (arg1 == null) ? "" : arg1.toString();
        botao.setText(texto);
        return botao;
    }

    @Override
    public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
        if (arg3) {
            botao.setForeground(tabela.getForeground());
            botao.setBackground(UIManager.getColor("Button.background"));
        } else if (arg2) {
            botao.setForeground(tabela.getSelectionForeground());
            botao.setBackground(tabela.getSelectionBackground());
        } else {
            botao.setForeground(tabela.getForeground());
            botao.setBackground(UIManager.getColor("Button.background"));
        }

        botao.setText((arg1 == null) ? "" : arg1.toString());
        return botao;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        fireEditingStopped();
        ListaModelo model = null;
        if (tabela.getModel() instanceof ModeloTabelaAvaliacaoEspecifica) {
            model = (ModeloTabelaAvaliacaoEspecifica) tabela.getModel();
        } else if (tabela.getModel() instanceof ModeloTabelaAvaliacaoGenerica) {
            model = (ModeloTabelaAvaliacaoGenerica) tabela.getModel();
        }
        new TelaArtefato(PrincipalFrame.getFrames()[0], true, model.getElementAt(tabela.getSelectedRow()), listaAtivo);
    }
}
