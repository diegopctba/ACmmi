/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaAvaliacao.java
 *
 * Created on 12/09/2009, 14:59:07
 */
package appcmmi.form.avaliacao;

import appcmmi.PrincipalFrame;
import appcmmi.db.dao.avaliacao.AvaliacaoDao;
import appcmmi.db.facade.avaliacao.AvaliacaoEspecificaFacade;
import appcmmi.db.facade.avaliacao.AvaliacaoFacade;
import appcmmi.db.facade.avaliacao.AvaliacaoGenericaFacade;
import appcmmi.db.facade.avaliacao.StatusInstitucionalizacaoFacade;
import appcmmi.db.facade.modelo.MaturidadeFacade;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.Ativo;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.GraficoAvaliacao;
import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.form.report.TelaImprimir;
import appcmmi.funcoes.Funcoes;
import appcmmi.funcoes.GerarRelatorio;
import appcmmi.funcoes.report.datasource.AvaliacaoDataSource;
import appcmmi.modelo.coluna.ModeloColunaBotao;
import appcmmi.modelo.comboBox.ModeloComboStatusComentario;
import appcmmi.modelo.comboBox.ModeloComboStatusDefinicao;
import appcmmi.modelo.comboBox.ModeloComboStatusInstitucionalizacao;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoEspecifica;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoGenerica;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * Tela para avaliação, mostrando todas as práticas separadas em abas por Áreas de Processo e Maturidade.
 * @author diego
 */
public class TelaAvaliacao extends javax.swing.JInternalFrame {

    public TelaAvaliacao(Integer idAvaliacao) {
        inicial(idAvaliacao);
    }

    /**
     * Realiza a configuração das tabelas utilizadas em cada aba,
     * definindo seu tamanho e tipo de colunas.
     * @param tabela
     * @param listaAtivo
     * @return JScrollPane
     * @throws Exception
     */
    private JScrollPane configuraTabela(JTable tabela, List<Ativo> listaAtivo) throws Exception {
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setAutoscrolls(true);
        tabela.setPreferredScrollableViewportSize(new Dimension(getSize().width - 50, getSize().height - 250)); //panelEspecifica.add(tabela);
        tabela.getColumnModel().getColumn(0).setMinWidth(250);
        tabela.getColumnModel().getColumn(0).setMaxWidth(800);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(600);
        int posicao = 0;
        if (definicao && instiucionalizacao) {
            DefaultCellEditor comboI = new DefaultCellEditor(new JComboBox(new ModeloComboStatusInstitucionalizacao()));
            DefaultCellEditor comboD = new DefaultCellEditor(new JComboBox(new StatusInstitucionalizacaoFacade().retornaTodosStatus().toArray()));
            tabela.getColumnModel().getColumn(1).setCellEditor(comboD);
            tabela.getColumnModel().getColumn(2).setCellEditor(comboI);
            tabela.getColumnModel().getColumn(1).setMinWidth(50);
            tabela.getColumnModel().getColumn(1).setMaxWidth(120);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(2).setMinWidth(50);
            tabela.getColumnModel().getColumn(2).setMaxWidth(120);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(3).setMinWidth(300);
            tabela.getColumnModel().getColumn(3).setMaxWidth(1000);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(350);
            tabela.getColumnModel().getColumn(4).setPreferredWidth(50);

            posicao = 5;
        } else {
            tabela.getColumnModel().getColumn(1).setMinWidth(50);
            tabela.getColumnModel().getColumn(1).setMaxWidth(120);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(2).setMinWidth(300);
            tabela.getColumnModel().getColumn(2).setMaxWidth(1000);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(350);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
            if (definicao) {
                posicao = 4;
                tabela.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox(new ModeloComboStatusDefinicao())));
            } else if (instiucionalizacao) {
                posicao = 4;
                tabela.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JComboBox(new ModeloComboStatusInstitucionalizacao())));
            }
        }
        tabela.getColumnModel().getColumn(posicao - 1).setCellEditor(new DefaultCellEditor(new JComboBox(new ModeloComboStatusComentario())));
        tabela.setRowHeight(30);
        new ModeloColunaBotao(tabela, posicao, listaAtivo);
        return new JScrollPane(tabela);
    }

    /**
     * Realiza todas as configurações iniciais da tela,
     * incluindo permissão de gravação/alteração.
     * @param idAvaliacao
     */
    private void inicial(Integer idAvaliacao) {
        try {
            initComponents();
            setSize(PrincipalFrame.getPane().getSize());
            setVisible(true);
            setTitle("Avaliação");
            setResizable(true);
            setClosable(true);
            setIconifiable(true);
            setMaximizable(true);
            avaliacao = new AvaliacaoFacade().carregaAvaliacao(idAvaliacao);
            avaliacao.getAtivoList().size();

            if (avaliacao != null) {
                if (avaliacao.getEstado().equals("FINALIZADA")) {
                    salvar.setEnabled(false);
                    encerrar.setEnabled(false);
                }
                definicao = (avaliacao.getDefinicao() == null) ? false : avaliacao.getDefinicao();
                instiucionalizacao = (avaliacao.getInstitucionalizacao() == null) ? false : avaliacao.getInstitucionalizacao();
                empresa.setText(avaliacao.getIdempresa().getRazaosocial());
                dataCriacao.setText(Funcoes.formataData(avaliacao.getDataCriacao()));
                List<Maturidade> maturidades = new MaturidadeFacade().listaMaturidadesAvaliacao(avaliacao.getIdmaturidade().getNummaturidade());
                panePrincipal.setSize(500, 400);
                AvaliacaoEspecificaFacade facadeEspecifica = new AvaliacaoEspecificaFacade();
                AvaliacaoGenericaFacade facadeGenerica = new AvaliacaoGenericaFacade();
                for (Maturidade m : maturidades) {
                    JTabbedPane paneMaturidade = new JTabbedPane();
                    paneMaturidade.setSize(getSize());
                    for (AreaProcesso a : m.getAreaProcessoList()) {
                        JTabbedPane tabbedArea = new JTabbedPane();
                        Border border = new TitledBorder(a.getTitulo());
                        //Práticas específicas
                        JPanel panelEspecifica = new JPanel();
                        panelEspecifica.setBorder(border);
                        tabbedArea.add(panelEspecifica, PRATICA[0]);
                        ModeloTabelaAvaliacaoEspecifica model = facadeEspecifica.retornaTabelaAvaliacaoAreaProcesso(
                                avaliacao.getIdAvaliacao(), a.getIdareaprocesso());
                        JTable tabelaEspecifica = new JTable(model);
                        panelEspecifica.add(configuraTabela(tabelaEspecifica, avaliacao.getAtivoList()));
                        //práticas genéricas
                        JPanel panelGenerica = new JPanel();
                        panelGenerica.setBorder(border);
                        ModeloTabelaAvaliacaoGenerica modelGen = facadeGenerica.retornaModeloAvaliacaoMaturidade(
                                m.getIdmaturidade(), avaliacao.getIdAvaliacao(), a.getIdareaprocesso());
                        JTable tabelaGenerica = new JTable(modelGen);
                        panelGenerica.add(configuraTabela(tabelaGenerica, avaliacao.getAtivoList()));
                        tabbedArea.add(panelGenerica, PRATICA[1]);
                        paneMaturidade.add(tabbedArea, a.getSigla());
                    }
                    panePrincipal.add(paneMaturidade, m.toString());
                }
            } else {
                Funcoes.erro("Erro", "Avaliação não existe.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Funcoes.erro("Erro", e.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        empresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dataCriacao = new javax.swing.JFormattedTextField();
        panePrincipal = new javax.swing.JTabbedPane();
        relatorio = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        salvar = new javax.swing.JButton();
        grafico = new javax.swing.JButton();
        encerrar = new javax.swing.JButton();

        painel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Avaliação"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Empresa");

        empresa.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Data");

        dataCriacao.setEditable(false);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panePrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliação"));

        relatorio.setText("Relatório");
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioActionPerformed(evt);
            }
        });

        fechar.setText("Cancelar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        grafico.setText("Gráfico");
        grafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoActionPerformed(evt);
            }
        });

        encerrar.setText("Encerrar");
        encerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grafico, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
            .addComponent(panePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1067, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(relatorio)
                            .addComponent(grafico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechar)
                            .addComponent(salvar)
                            .addComponent(encerrar)))
                    .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panePrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Finaliza a tela.
     * @param evt
     */
    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        int idx = Funcoes.opcao("Avaliação", "Deseja cancelar esta avaliação?");
        if (idx == 0) {
            this.dispose();
        } else {
            inicial(null);
        }
    }//GEN-LAST:event_fecharActionPerformed

    /**
     * Percorre todas as abas e atualiza os dados nelas preenchidas.
     * @param evt
     */
    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        try {
            salvar.requestFocus();
            String estado = avaliacao.getEstado();
            if (estado == null || estado.equals("CRIADA") || !estado.equals("FINALIZADA")) {
                avaliacao.setEstado("INICIADA");
                avaliacao.setDataInicio(new Date());
                new AvaliacaoDao().salvarAtualizar(avaliacao);
            }
            if (avaliacao.getEstado().equals("FINALIZADA")) {
                Funcoes.warn("Não foi possível salvar a avaliação", "Esta avaliação está encerrada.");
            } else {
                for (int x = 0; x < panePrincipal.getComponentCount(); x++) {
                    if (panePrincipal.getComponent(x) instanceof JTabbedPane) {
                        //se for práticas específicas
                        JTabbedPane pMaturidade = (JTabbedPane) panePrincipal.getComponent(x);
                        for (int y = 0; y < pMaturidade.getComponentCount(); y++) {
                            if (pMaturidade.getComponent(y) instanceof JTabbedPane) {
                                JTabbedPane tabbed = (JTabbedPane) pMaturidade.getComponent(y);
                                for (int q = 0; q < tabbed.getComponentCount(); q++) {
                                    if (tabbed.getComponent(q) instanceof JPanel) {
                                        JPanel panel = (JPanel) tabbed.getComponent(q);
                                        for (int w = 0; w < panel.getComponentCount(); w++) {
                                            if (panel.getComponent(w) instanceof JScrollPane) {
                                                JScrollPane scroll = (JScrollPane) panel.getComponent(w);
                                                for (int z = 0; z < scroll.getComponentCount(); z++) {
                                                    if (scroll.getComponent(z) instanceof JViewport) {
                                                        JViewport report = (JViewport) scroll.getComponent(z);
                                                        for (int k = 0; k < report.getComponentCount(); k++) {
                                                            if (report.getComponent(k) instanceof JTable) {
                                                                JTable tabela = (JTable) report.getComponent(k);
                                                                if (tabela.getModel() instanceof ModeloTabelaAvaliacaoEspecifica) {
                                                                    ModeloTabelaAvaliacaoEspecifica model = (ModeloTabelaAvaliacaoEspecifica) tabela.getModel();
                                                                    new AvaliacaoEspecificaFacade().salvarListaAvaliacaoEspecifica(model.getList());
                                                                } else if (tabela.getModel() instanceof ModeloTabelaAvaliacaoGenerica) {
                                                                    ModeloTabelaAvaliacaoGenerica model = (ModeloTabelaAvaliacaoGenerica) tabela.getModel();
                                                                    new AvaliacaoGenericaFacade().salvarListaAvaliacaoGenerica(model.getList());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (!evt.getActionCommand().equals("finalizar")) {
                    Funcoes.info("Avaliação", "Avaliação salva com sucesso.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Funcoes.erro("Avaliação", e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed

    /**
     * Apresenta uma tela para indicar o local onde em seguida será salvo o relatório geral da avaliação em aberto.
     * @param evt
     */
    private void relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioActionPerformed
        try {
            Funcoes.info("Relatório", "Por favor, indique o local onde deseja salvar o relatório");
            TelaImprimir file = new TelaImprimir(PrincipalFrame.getFrames()[0], true);
            File local = file.getFile();
            file.dispose();
            if (local != null) {
                Avaliacao report = new AvaliacaoFacade().carregaAvaliacao(avaliacao.getIdAvaliacao());
                GerarRelatorio gerar = new GerarRelatorio();
                Collection<Avaliacao> data = new ArrayList<Avaliacao>();
                report.getAvaliacaoEspecificaList().size();
                report.getAvaliacaoGenericaList().size();
                data.add(report);
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("dataFim", avaliacao.getDataFim());
                param.put("dataInicio", avaliacao.getDataInicio());
                param.put("comentario", avaliacao.getComentario());
                gerar.jasperReport(local, "avaliacao", new AvaliacaoDataSource(data), param);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Funcoes.erro("Relatório", ex.getMessage());
        }

    }//GEN-LAST:event_relatorioActionPerformed

    /**
     * Apresenta a tela para indicar o local onde será salvo os gráficos da avaliação em aberto.
     * @param evt
     */
    private void graficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoActionPerformed
        try {
            Funcoes.info("Relatório", "Por favor, indique o local onde deseja salvar o gráfico");
            TelaImprimir file = new TelaImprimir(PrincipalFrame.getFrames()[0], true);
            File local = file.getFile();
            file.dispose();
            if (local != null) {
                List<GraficoAvaliacao> lista = new AvaliacaoFacade().retornaGraficoAvaliacao(avaliacao.getIdAvaliacao());
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("empresa", avaliacao.getIdempresa().getRazaosocial());
                param.put("data", avaliacao.getDataCriacao());
                param.put("maturidade", avaliacao.getIdmaturidade().getTitulo());
                Avaliacao report = new AvaliacaoFacade().carregaAvaliacao(avaliacao.getIdAvaliacao());
                GerarRelatorio gerar = new GerarRelatorio();
                Collection<Avaliacao> data = new ArrayList<Avaliacao>();
                report.getAvaliacaoEspecificaList().size();
                report.getAvaliacaoGenericaList().size();
                data.add(report);

                gerar.jasperReport(local, "Grafico", lista, param);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            Funcoes.info("Erro", ex.getMessage());
        }

    }//GEN-LAST:event_graficoActionPerformed

    /**
     * Realiza o encerramento da avalição, indicando o estado como finalizada e inserindo um comentario.
     * @param evt
     */
    private void encerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encerrarActionPerformed
        TelaEncerrar encerra = new TelaEncerrar(PrincipalFrame.getFrames()[0], true);
        String comentario = encerra.getComentario();
        encerra.dispose();
        if (comentario != null) {
            try {
                avaliacao.setComentario(comentario);
                avaliacao.setDataFim(new Date());
                salvarActionPerformed(new ActionEvent(encerrar, 0, "finalizar"));
                avaliacao.setEstado("FINALIZADA");
                new AvaliacaoFacade().salvarAtualizarAvaliacao(avaliacao);
                Funcoes.info("Avaliação finalizada", "Avaliação finalizada.");
                salvar.setEnabled(false);
                encerrar.setEnabled(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                Funcoes.erro("Erro", ex.getMessage());
            }
        }
    }//GEN-LAST:event_encerrarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataCriacao;
    private javax.swing.JTextField empresa;
    private javax.swing.JButton encerrar;
    private javax.swing.JButton fechar;
    private javax.swing.JButton grafico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel painel;
    private javax.swing.JTabbedPane panePrincipal;
    private javax.swing.JButton relatorio;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
    private Avaliacao avaliacao;
    private boolean definicao;
    private boolean instiucionalizacao;
    private static final String[] PRATICA = {"ESPECÍFICA", "GENÉRICA"};
}
