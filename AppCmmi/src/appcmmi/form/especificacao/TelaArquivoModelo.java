/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaArquivoModelo.java
 *
 * Created on 22/11/2009, 15:33:15
 */
package appcmmi.form.especificacao;

import appcmmi.db.facade.TipoArtefatoFacade;
import appcmmi.db.facade.avaliacao.StatusComentarioFacade;
import appcmmi.db.facade.avaliacao.StatusFacade;
import appcmmi.db.facade.avaliacao.StatusInstitucionalizacaoFacade;
import appcmmi.db.facade.modelo.AreaProcessoFacade;
import appcmmi.db.facade.modelo.EspecificaFacade;
import appcmmi.db.facade.modelo.GenericaFacade;
import appcmmi.db.facade.modelo.MaturidadeFacade;
import appcmmi.db.pojo.artefato.TipoArtefato;
import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import appcmmi.db.pojo.avaliacao.StatusComentario;
import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.funcoes.Funcoes;
import appcmmi.funcoes.Propriedades;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class TelaArquivoModelo extends javax.swing.JInternalFrame {

    /** Creates new form TelaArquivoModelo */
    public TelaArquivoModelo(int tipo) {
        initComponents();
        this.tipo = tipo;
        switch (this.tipo) {
            case EXPORTAR:
                exportaModelo.setApproveButtonText("Exportar");
                setTitle("Exportar Modelo CMMI");
                break;
            case IMPORTAR:
                exportaModelo.setApproveButtonText("Importar");
                setTitle("Importar Modelo CMMI");
                break;
        }
        String url = Propriedades.getPreferences().get(Propriedades.MODELO, "");
        if (url != null && !url.isEmpty()) {
            exportaModelo.setSelectedFile(new File(url));
        }
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

        exportaModelo = new javax.swing.JFileChooser();

        exportaModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportaModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exportaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exportaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportaModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportaModeloActionPerformed

        if (!evt.getActionCommand().equals("CancelSelection")) {
            try {
                switch (tipo) {
                    case IMPORTAR:
                        List listaobj = (ArrayList) Funcoes.importaArquivo(exportaModelo.getSelectedFile().getPath());
                        List<Maturidade> listaim = (List<Maturidade>) listaobj.get(0);
                        new MaturidadeFacade().salvarMaturidade(listaim);
                        for (Maturidade m : listaim) {
                            new AreaProcessoFacade().salvarAreaProcesso(m.getAreaProcessoList());
                            for (AreaProcesso a : m.getAreaProcessoList()) {
                                new EspecificaFacade().salvarEspecifica(a.getPraticaEspecificaList());
                            }
                            new GenericaFacade().salvarGenerica(m.getPraticaGenericaList());
                        }
                        List<StatusDefinicao> listastatus = (List<StatusDefinicao>) listaobj.get(1);
                        new StatusFacade().importaStatus(listastatus);
                        List<StatusInstitucionalizacao> listainst = (List<StatusInstitucionalizacao>) listaobj.get(2);
                        new StatusInstitucionalizacaoFacade().importar(listainst);
                        List<TipoArtefato> listatipoart = (List<TipoArtefato>) listaobj.get(3);
                        new TipoArtefatoFacade().importaTipoArtefato(listatipoart);
                        List<StatusComentario> listastatuscomentario = (List<StatusComentario>) listaobj.get(4);
                        new StatusComentarioFacade().salvarStatusComentario(listastatuscomentario);
                        Funcoes.info("Importação", "Importação realizada com sucesso.");
                        break;
                    case EXPORTAR:
                        List lista = new ArrayList();
                        List<Maturidade> listaex = new MaturidadeFacade().exportaMaturidades();
                        List<StatusDefinicao> listas = new StatusFacade().retornaTodosStatus();
                        listas.size();
                        List<StatusInstitucionalizacao> listai = new StatusInstitucionalizacaoFacade().retornaTodosStatus();
                        listai.size();
                        List<TipoArtefato> listaa = new TipoArtefatoFacade().retornaTodosTiposArtefatos();
                        listaa.size();
                        List<StatusComentario> listasc = new StatusComentarioFacade().retornaTodosStatusComentario();
                        listasc.size();

                        lista.add(listaex);
                        lista.add(listas);
                        lista.add(listai);
                        lista.add(listaa);
                        lista.add(listasc);
                        Funcoes.exportarArquivo(lista, exportaModelo.getSelectedFile().getPath(), Funcoes.MODELO);
                        Funcoes.info("Modelo CMMI", "Modelo CMMI exportado com sucesso.");
                        break;
                }
                Propriedades.getPreferences().put(Propriedades.MODELO, exportaModelo.getSelectedFile().getPath());
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                Funcoes.erro("Erro", ex.getMessage());
            }
        } else {
            this.dispose();
        }
}//GEN-LAST:event_exportaModeloActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser exportaModelo;
    // End of variables declaration//GEN-END:variables
    private int tipo;
    public static final int IMPORTAR = 0;
    public static final int EXPORTAR = 1;
}
