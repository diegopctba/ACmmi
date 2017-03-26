/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi;

import appcmmi.db.HibernateUtil;
import appcmmi.form.avaliacao.TelaArquivoAvaliacao;
import appcmmi.form.empresa.TelaAvaliador;
import appcmmi.form.empresa.TelaEmpresa;
import appcmmi.form.avaliacao.TelaCriarAvaliacao;
import appcmmi.form.avaliacao.TelaPesquisaAvaliacao;
import appcmmi.form.avaliacao.artefato.TelaTipoArtefato;
import appcmmi.form.avaliacao.status.TelaStatusInstitucionalizacao;
import appcmmi.form.avaliacao.status.TelaStatusPratica;
import appcmmi.form.empresa.TelaAtivo;
import appcmmi.form.especificacao.TelaArquivoModelo;
import appcmmi.form.especificacao.TelaNovaEspecificacao;
import appcmmi.form.login.TelaPropriedades;
import appcmmi.form.login.TelaSobre;
import appcmmi.form.report.TelaReport;
import appcmmi.funcoes.Funcoes;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

/**
 * Classe responsável pela inteface, utilizando {@link JDesktopPane} para as telas controladas pelo menu.
 * @author diego
 */
public class PrincipalFrame extends javax.swing.JFrame {

    private static JDesktopPane pane;
    private static BufferedImage image;

    public PrincipalFrame() {
        try {
            image = ImageIO.read(getClass().getResource("/appcmmi/form/imagem/acmmi16.jpg"));
            this.setIconImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
            Funcoes.erro("ACMMI", ex.getMessage());
            System.exit(1);
        }
        setTitle("Sistema de Avaliação CMMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1600, 1200);
        //Setando a tela visivel
        initComponents();
        //Setando o JFrame principal como visivel
        setVisible(true);
    }

    /**
     * Retorna o JDesktopPane da aplicação
     * @return JDestopPane
     */
    public static JDesktopPane getPane() {
        return pane;
    }

    /**
     * Recebe o JDesktoPane para uso na aplicação
     * @param pane
     */
    public static void setPane(JDesktopPane pane) {
        PrincipalFrame.pane = pane;
    }

    /**
     * Atualiza a tela
     * @param fechaComponent
     * @param abreComponent
     */
    public static void atualizarTela(Component fechaComponent, Component abreComponent) {
        pane.remove(fechaComponent);
        adicionarAoPane(abreComponent);
    }

    /**
     * Insere o componente na tela
     * @param component
     */
    private static void adicionarAoPane(Component component) {

        pane.add(component);
        pane.setPosition(component, 0);
    }

    private void initComponents() {
        //Cola o DesktopPane no JFrame principal
        pane = new JDesktopPane();
        pane.setBackground(Color.gray);

        setContentPane(pane);
        //Adiciona a  barra Menu no JFrame Principal
        JMenuBar menu = new JMenuBar();
        JMenu menuAvaliacao = new JMenu("Avaliação");
        JMenu menuEspecificacao = new JMenu("Modelo");
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuRelatorio = new JMenu("Relatório");
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem sairDireto = new JMenuItem("Sair");
        menu.add(menuAvaliacao);
        menu.add(menuEspecificacao);
        menu.add(menuCadastro);
        menu.add(menuRelatorio);
        menu.add(menuAjuda);
        menu.add(sairDireto);
        //Insere os atalhos utilizados junto com o botão ALT
        menuAvaliacao.setMnemonic(KeyEvent.VK_A);
        menuEspecificacao.setMnemonic(KeyEvent.VK_E);
        menuCadastro.setMnemonic(KeyEvent.VK_C);
        menuAjuda.setMnemonic(KeyEvent.VK_U);
        sairDireto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        //Criando um item a ser adiciona no Menu1
        JMenuItem novaAvaliacao = new JMenuItem("Novo");
        JMenuItem abrirAvaliacao = new JMenuItem("Abrir");
        JMenuItem sair = new JMenuItem("Sair");
        JMenu arquivos = new JMenu("Arquivos");
        JMenuItem importar = new JMenuItem("Importar");
        JMenuItem exportar = new JMenuItem("Exportar");
        arquivos.add(importar);
        arquivos.add(exportar);
        JMenuItem propriedades = new JMenuItem("Propriedades");
        sair.setToolTipText("Fecha o sistema.");
        menuAvaliacao.add(novaAvaliacao);
        menuAvaliacao.add(abrirAvaliacao);
        menuAvaliacao.add(new JSeparator());
        menuAvaliacao.add(arquivos);
        menuAvaliacao.add(new JSeparator());
        menuAvaliacao.add(propriedades);
        menuAvaliacao.add(new JSeparator());
        menuAvaliacao.add(sair);
        importar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaArquivoAvaliacao(getFrames()[0], true, TelaArquivoAvaliacao.IMPORTAR, null));
            }
        });
        exportar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaPesquisaAvaliacao(true, false));
            }
        });
        propriedades.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TelaPropriedades(PrincipalFrame.getFrames()[0], true);
            }
        });
        //Adiciona uma ação no botão no menu
        novaAvaliacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        novaAvaliacao.setToolTipText("Crie uma nova avaliação.");
        novaAvaliacao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAoPane(new TelaCriarAvaliacao());
            }
        });
        abrirAvaliacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
        abrirAvaliacao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaPesquisaAvaliacao());
            }
        });
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));
        sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HibernateUtil.closeCurrentSession();
                System.exit(0);
            }
        });
        //Modelo de Especificação CMMI
        JMenuItem novaEspecificacao = new JMenuItem("Modelo CMMI");
        JMenuItem exportarModelo = new JMenuItem("Exportar");
        JMenuItem importarModelo = new JMenuItem("Importar");
        novaEspecificacao.setToolTipText("Visualize, edite ou remova itens do modelo CMMI.");
        menuEspecificacao.add(novaEspecificacao);
        novaEspecificacao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                TelaNovaEspecificacao nova = new TelaNovaEspecificacao();
                nova.setVisible(true);
                nova.setTitle("Nova Especificação");
                pane.add(nova);
                pane.setPosition(nova, 0);
            }
        });
        menuEspecificacao.add(new JSeparator());
        JMenu arquivoModelo = new JMenu("Arquivo");
        menuEspecificacao.add(arquivoModelo);
        arquivoModelo.add(importarModelo);
        arquivoModelo.add(exportarModelo);
        exportarModelo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaArquivoModelo(TelaArquivoModelo.EXPORTAR));
            }
        });
        importarModelo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaArquivoModelo(TelaArquivoModelo.IMPORTAR));
            }
        });
        //Menu Ajuda
        JMenuItem sobre = new JMenuItem("Sobre...");
        sobre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                new TelaSobre(getFrames()[0], true);
            }
        });
        menuAjuda.add(sobre);
        //Menu Cadastro
        JMenuItem itemAuditor = new JMenuItem("Avaliador");
        JMenuItem itemEmpresa = new JMenuItem("Empresa");
        JMenuItem itemEvento = new JMenuItem("Ativo");
        // JMenuItem itemSenha = new JMenuItem("Usuário");
        menuCadastro.add(itemAuditor);
        menuCadastro.add(itemEmpresa);
        menuCadastro.add(itemEvento);
        menuCadastro.add(new JSeparator());
        JMenu barraCadastro = new JMenu("Sistema");
        JMenuItem itemStatus = new JMenuItem("Status de Definição");
        JMenuItem itemStatusI = new JMenuItem("Status de Institucionalização");
        JMenuItem itemTipoArtefato = new JMenuItem("Tipos de Artefatos");
        barraCadastro.add(itemStatus);
        barraCadastro.add(itemStatusI);
        barraCadastro.add(itemTipoArtefato);
        menuCadastro.add(barraCadastro);
        //menuCadastro.add(itemSenha);
        itemAuditor.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaAvaliador());
            }
        });
        itemEmpresa.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaEmpresa());
            }
        });
        itemEvento.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaAtivo());
            }
        });
        itemStatus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaStatusPratica());
            }
        });
        itemStatusI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaStatusInstitucionalizacao());
            }
        });
        itemTipoArtefato.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaTipoArtefato());
            }
        });
        JMenuItem itemRelGeral = new JMenuItem("Geral");
        menuRelatorio.add(itemRelGeral);
        itemRelGeral.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                adicionarAoPane(new TelaReport(TelaReport.GERAL));
            }
        });
        //Adiciona o Menu já pronto no JFrame principal
        setJMenuBar(menu);
        //Setando menu visivel
        menu.setVisible(true);
        //Setando a tela visivel
        pane.setVisible(true);
    }
}
