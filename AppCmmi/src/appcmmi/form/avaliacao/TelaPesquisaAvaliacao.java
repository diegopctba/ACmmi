/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPesquisaAvaliacao.java
 *
 * Created on 18/11/2009, 16:37:09
 */
package appcmmi.form.avaliacao;

import appcmmi.PrincipalFrame;
import appcmmi.db.facade.avaliacao.AvaliacaoFacade;
import appcmmi.db.facade.modelo.MaturidadeFacade;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import appcmmi.funcoes.Funcoes;
import appcmmi.modelo.bind.avaliacao.ModeloPesquisaAvaliacao;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class TelaPesquisaAvaliacao extends javax.swing.JInternalFrame {

    /** Creates new form TelaPesquisaAvaliacao */
    public TelaPesquisaAvaliacao() {
        try {
            inicial();
        } catch (Exception ex) {
            ex.printStackTrace();
            Funcoes.erro("Pesquisa", ex.getMessage());
        }
    }

    public TelaPesquisaAvaliacao(boolean exporta, boolean rel) {
        try {
            inicial();
            if (exporta) {
                exportar.setVisible(exporta);
                exportar.setEnabled(exporta);
            } else if (rel) {
                //this.relatorio.setVisible(rel);
                //relatorio.setEnabled(rel);
            }
        } catch (Exception ex) {
            Funcoes.erro("Pesquisa", ex.getMessage());
        }
    }

    private void inicial() throws Exception {
        model = new ModeloPesquisaAvaliacao(new MaturidadeFacade().retornaTodasMaturidade());
        pesquisarActionPerformed(null);
        initComponents();
        setTitle("Pesquisa de Avaliações");
        setClosable(true);
        exportar.setVisible(false);
        exportar.setEnabled(false);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);
        tabelaAvaliacao.getColumnModel().getColumn(0).setMaxWidth(50);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idEmpresa = new javax.swing.JTextField();
        pesquisaEmpresa = new javax.swing.JButton();
        razaoSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        de = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        ate = new javax.swing.JFormattedTextField();
        definicao = new javax.swing.JCheckBox();
        institucionalizacao = new javax.swing.JCheckBox();
        fechar = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        pesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        maturidade = new javax.swing.JComboBox();
        abrir = new javax.swing.JButton();
        exportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAvaliacao = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Empresa");

        idEmpresa.setColumns(3);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.idEmpresa}"), idEmpresa, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        pesquisaEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/appcmmi/form/imagem/lupa.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("De");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.criacaoDe}"), de, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Até");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.criacaoAte}"), ate, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        definicao.setText("Definição");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.definicao}"), definicao, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        institucionalizacao.setText("Institucionalizacao");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.institucionalizacao}"), institucionalizacao, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        limpar.setText("Limpar");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        jLabel4.setText("Maturidade");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${model.listaMaturidade}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, maturidade);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.maturidade}"), maturidade, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });

        exportar.setText("Exportar");
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(abrir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(idEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(razaoSocial, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(definicao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(institucionalizacao))))
                    .addComponent(maturidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(pesquisaEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(razaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(de, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(ate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(definicao)
                    .addComponent(institucionalizacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(maturidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechar)
                    .addComponent(limpar)
                    .addComponent(pesquisar)
                    .addComponent(abrir)
                    .addComponent(exportar))
                .addContainerGap())
        );

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${model.listaAvaliacao}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tabelaAvaliacao);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idAvaliacao}"));
        columnBinding.setColumnName("Avaliação");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idempresa.nomefantasia}"));
        columnBinding.setColumnName("Empresa");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idmaturidade.titulo}"));
        columnBinding.setColumnName("Maturidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${estado}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${model.avaliacao}"), tabelaAvaliacao, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tabelaAvaliacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        try {
            inicial();
        } catch (Exception ex) {
            ex.printStackTrace();
            Funcoes.erro("Pesquisa", ex.getMessage());
        }
    }//GEN-LAST:event_limparActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_fecharActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        try {
            List<Avaliacao> lista = new ArrayList<Avaliacao>();
            AvaliacaoFacade facade = new AvaliacaoFacade();
            Integer idmaturidade = null;
            if (model.getMaturidade() != null && model.getMaturidade().getIdmaturidade() != null && model.getMaturidade().getIdmaturidade() > 0) {
                idmaturidade = model.getMaturidade().getIdmaturidade();
            }
            lista = facade.pesquisaAvaliacao(model.getIdEmpresa(), idmaturidade,
                    model.getCriacaoDe(), model.getCriacaoAte(), model.isDefinicao(), model.isInstitucionalizacao());
            model.setListaAvaliacao(lista);
            System.out.println(lista.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            Funcoes.erro("Pesquisa", ex.getMessage());
        }
    }//GEN-LAST:event_pesquisarActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        if (model.getAvaliacao() == null) {
            Funcoes.warn("Avaliação", "Selecione uma avaliação para abrir.");
        } else {
            try {
                TelaSenha tela = new TelaSenha(PrincipalFrame.getFrames()[0], true, false);
                //String senha = (String) Funcoes.pergunta("Abrir Avaliação", "Por favor, digite a senha da avaliação.");
                String senha = tela.getSenha();
                Avaliacao avaliacao = model.getAvaliacao();
                if (senha != null && senha.equals(avaliacao.getSenha())) {
                    TelaAvaliacao telaAvaliacao = new TelaAvaliacao(model.getAvaliacao().getIdAvaliacao());
                    PrincipalFrame.atualizarTela(this, telaAvaliacao);
                } else {
                    Funcoes.erro("Avaliação", "Senha incorreta.");
                }
            } catch (Exception ex) {
                Funcoes.erro("Avaliação", "Senha incorreta.");
            }
        }
    }//GEN-LAST:event_abrirActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        try {
            if (model.getAvaliacao() != null) {
                Avaliacao avaliacao = new AvaliacaoFacade().carregaAvaliacao(model.getAvaliacao().getIdAvaliacao());
                TelaSenha tela = new TelaSenha(PrincipalFrame.getFrames()[0], true, false);
                //String senha = (String) Funcoes.pergunta("Exportar Avaliação", "Digite a senha");
                String senha = tela.getSenha();
                if (senha != null && senha.equals(avaliacao.getSenha())) {
                    avaliacao.getIdempresa().getIdempresa();
                    avaliacao.getAtivoList().size();
                    for (AvaliacaoEspecifica e : avaliacao.getAvaliacaoEspecificaList()) {
                        e.getArtefatoList().size();
                    }
                    for (AvaliacaoGenerica g : avaliacao.getAvaliacaoGenericaList()) {
                        g.getArtefatoList().size();
                    }
                    avaliacao.getIdempresa().getAtivoList().size();
                    avaliacao.getIdmaturidade().getIdmaturidade();
                    avaliacao.getAvaliadorList().size();
                    new TelaArquivoAvaliacao(PrincipalFrame.getFrames()[0], true, TelaArquivoAvaliacao.EXPORTAR, avaliacao);
                } else {
                    Funcoes.erro("Avaliação", "Senha incorreta");
                }
            } else {
                Funcoes.warn("Exportar avaliação", "Selecione uma avaliação para exportar.");
            }
        } catch (Exception ex) {
            Funcoes.erro("Erro", ex.getMessage());
        }
    }//GEN-LAST:event_exportarActionPerformed

    public ModeloPesquisaAvaliacao getModel() {
        return model;
    }
    private ModeloPesquisaAvaliacao model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JFormattedTextField ate;
    private javax.swing.JFormattedTextField de;
    private javax.swing.JCheckBox definicao;
    private javax.swing.JButton exportar;
    private javax.swing.JButton fechar;
    private javax.swing.JTextField idEmpresa;
    private javax.swing.JCheckBox institucionalizacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JComboBox maturidade;
    private javax.swing.JButton pesquisaEmpresa;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField razaoSocial;
    private javax.swing.JTable tabelaAvaliacao;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
