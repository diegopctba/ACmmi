/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaNovaPratica.java
 *
 * Created on 01/10/2009, 13:44:47
 */
package appcmmi.form.especificacao;

import appcmmi.PrincipalFrame;
import appcmmi.db.facade.modelo.AreaProcessoFacade;
import appcmmi.db.facade.modelo.EspecificaFacade;
import appcmmi.db.facade.modelo.GenericaFacade;
import appcmmi.db.facade.modelo.MaturidadeFacade;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.db.pojo.modelo.PraticaEspecifica;
import appcmmi.db.pojo.modelo.PraticaGenerica;
import appcmmi.modelo.comboBox.ModeloComboAreaProcesso;
import appcmmi.modelo.comboBox.ModeloComboMaturidade;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class TelaNovaPratica extends javax.swing.JDialog {

    /** Creates new form TelaNovaPratica */
    public TelaNovaPratica(java.awt.Frame parent, boolean modal, Object pratica) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        try {
            modeloMaturidade = new MaturidadeFacade().retornaModeloComboMaturidade();
            modeloProcesso = new ModeloComboAreaProcesso(new ArrayList<AreaProcesso>());
            initComponents();

            if (pratica instanceof PraticaEspecifica) {
                tipoPratica = especifica;
                praticaEspecifica = (PraticaEspecifica) pratica;
                areaProcesso.setText("Área de Processo");
                alteracao = (praticaEspecifica != null &&
                        praticaEspecifica.getIdespecifica() != null && !praticaEspecifica.getIdespecifica().equals(0)) ? true : false;

                if (alteracao) {
                    this.setTitle("Prática Específica");
                    salvar.setText("Alterar");
                    for (int x = 0; x < modeloMaturidade.getList().size(); x++) {
                        if (praticaEspecifica.getIdareaprocesso().getIdmaturidade().getIdmaturidade().equals(
                                modeloMaturidade.getElementAt(x).getIdmaturidade())) {
                            comboMaturidade.setSelectedIndex(x);
                            break;
                        }
                    }
                    modeloProcesso = new AreaProcessoFacade().retornaComboAreaProcessoPorMaturidade(praticaEspecifica.getIdareaprocesso().getIdmaturidade().getIdmaturidade());
                    comboProcesso.setModel(modeloProcesso);
                    for (int x = 0; x < modeloProcesso.getList().size(); x++) {
                        if (praticaEspecifica.getIdareaprocesso().getIdareaprocesso().equals(
                                modeloProcesso.getElementAt(x).getIdareaprocesso())) {
                            comboProcesso.setSelectedIndex(x);
                            break;
                        }
                    }

                    comboMaturidade.setSelectedItem(comboProcesso.getSelectedIndex());
                    titulo.setText(praticaEspecifica.getTitulo());
                    numPratica.setText(Double.toString(praticaEspecifica.getNumpraticaespecifica()));
                    descricao.setText(praticaEspecifica.getDescricao());
                } else {
                    praticaEspecifica = new PraticaEspecifica();
                    this.setTitle("Nova Prática Específica");
                    salvar.setText("Salvar");
                }
                comboMaturidade.addItemListener(new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent arg0) {
                        try {
                            modeloProcesso = null;
                            modeloProcesso = new AreaProcessoFacade().retornaComboAreaProcessoPorMaturidade(
                                    modeloMaturidade.getSelectedItem().getIdmaturidade());
                            comboProcesso.setModel(modeloProcesso);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(PrincipalFrame.getFrames()[0], ex);
                        }
                    }
                });
            } else if (pratica instanceof PraticaGenerica) {
                comboProcesso.setEnabled(false);
                areaProcesso.setEnabled(false);
                tipoPratica = generica;
                areaProcesso.setText("Maturidade");
                praticaGenerica = (PraticaGenerica) pratica;
                alteracao = (praticaGenerica != null &&
                        praticaGenerica.getIdgenerica() != null && !praticaGenerica.getIdgenerica().equals(0)) ? true : false;
                if (alteracao) {
                    this.setTitle("Prática Genérica");
                    salvar.setText("Alterar");
                    comboMaturidade.setSelectedItem(praticaGenerica.getIdmaturidade());
                    numPratica.setText(Double.toString(praticaGenerica.getNumpraticagenerica()));
                    titulo.setText(praticaGenerica.getTitulo());
                    descricao.setText(praticaGenerica.getDescricao());
                } else {
                    praticaGenerica = new PraticaGenerica();
                    this.setTitle("Nova Prática Genérica");
                    salvar.setText("Salvar");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
        comboProcesso.revalidate();
        comboProcesso.repaint();
        setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaProcesso = new javax.swing.JLabel();
        comboProcesso = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        numPratica = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboMaturidade = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        areaProcesso.setText("Área Processo");

        comboProcesso.setModel(modeloProcesso);

        jLabel1.setText("Nº Prática");

        jLabel2.setText("Descrição");

        salvar.setText("jButton1");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        jLabel3.setText("Maturidade");

        comboMaturidade.setModel(modeloMaturidade);

        jLabel4.setText("Título");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane1.setViewportView(descricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(areaProcesso)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(numPratica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboProcesso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jScrollPane1))
                        .addComponent(titulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                        .addComponent(comboMaturidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboMaturidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaProcesso)
                    .addComponent(comboProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numPratica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(limpar)
                    .addComponent(fechar))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_fecharActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            switch (tipoPratica) {
                case especifica:

                    praticaEspecifica.setTitulo(titulo.getText().toUpperCase());
                    praticaEspecifica.setDescricao(descricao.getText());
                    praticaEspecifica.setNumpraticaespecifica(Double.valueOf(numPratica.getText()));
                    praticaEspecifica.setIdareaprocesso((AreaProcesso) comboProcesso.getSelectedItem());
                    EspecificaFacade facadeEsp = new EspecificaFacade();
                    if (alteracao) {
                        facadeEsp.atualizarEspecifica(praticaEspecifica);
                    } else {
                        facadeEsp.salvarEspecifica(praticaEspecifica);
                        limparCampos();
                    }
                    JOptionPane.showMessageDialog(this, "Prática Específica salva com sucesso");
                    break;
                case generica:

                    praticaGenerica.setTitulo(titulo.getText().toUpperCase());
                    praticaGenerica.setDescricao(descricao.getText());
                    praticaGenerica.setNumpraticagenerica(Double.valueOf(numPratica.getText()));
                    praticaGenerica.setIdmaturidade((Maturidade) comboMaturidade.getSelectedItem());

                    GenericaFacade facadeGen = new GenericaFacade();
                    if (alteracao) {
                        facadeGen.atualizarGenerica(praticaGenerica);
                    } else {
                        facadeGen.salvarGenerica(praticaGenerica);
                        limparCampos();
                    }
                    JOptionPane.showMessageDialog(this, "Prática Genérica salva com sucesso");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_salvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TelaNovaPratica dialog = new TelaNovaPratica(new javax.swing.JFrame(), true, new Object());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaProcesso;
    private javax.swing.JComboBox comboMaturidade;
    private javax.swing.JComboBox comboProcesso;
    private javax.swing.JTextArea descricao;
    private javax.swing.JButton fechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField numPratica;
    private javax.swing.JButton salvar;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
    private PraticaEspecifica praticaEspecifica;
    private PraticaGenerica praticaGenerica;
    private int tipoPratica;
    private static final int especifica = 1;
    private static final int generica = 2;
    private boolean alteracao;
    private ModeloComboAreaProcesso modeloProcesso;
    private ModeloComboMaturidade modeloMaturidade;

    private void limparCampos() {
        descricao.setText("");
        titulo.setText("");
        numPratica.setText("");
        comboMaturidade.setSelectedIndex(0);
        comboProcesso.setSelectedIndex(0);
    }
}
