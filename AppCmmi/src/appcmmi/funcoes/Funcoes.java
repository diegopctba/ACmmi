/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.funcoes;

import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Classe estática de funções genéricas de utilização nas camadas de controle e visão.
 * @author diego
 * @since 28/10/2009
 */
public class Funcoes {

    private static final String[] SIM_NAO = {"Sim", "Não"};
    private static final String[] SUBSTITUIR = {"Substituir", "Substituir todos", "Não substituir", "Não suibstituir nenhum", "Cancelar"};
    private static final Object[] OK_CANCELAR = {"OK", "Cancelar"};
    public static final String MODELO = ".cmmi";
    public static final String AVALIACAO = ".caf";

    /**
     * Imprime uma mensagem de erro na tela
     * @param titulo
     * @param descricao
     */
    public static void erro(String titulo, String descricao) {
        JOptionPane.showMessageDialog(null, descricao, titulo, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Imprime uma mensagem de informação na tela
     * @param titulo
     * @param descricao
     */
    public static void info(String titulo, String descricao) {
        JOptionPane.showMessageDialog(null, descricao, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Imprime uma mensagem de cuidado na tela
     * @param titulo
     * @param descricao
     */
    public static void warn(String titulo, String descricao) {
        JOptionPane.showMessageDialog(null, descricao, titulo, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Imprime uma mensagem de opcao na tela, retornando o valor correspondente.
     * @param titulo
     * @param descricao
     * @return int
     */
    public static int opcao(String titulo, String descricao) {
        int opcao = JOptionPane.showOptionDialog(null, descricao, titulo, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, SIM_NAO, SIM_NAO[0]);
        return opcao;
    }

    /**
     * Imprime uma pergunta na tela, devolvendo uma String de resposta.
     * @param titulo
     * @param descricao
     * @return String
     */
    public static Object pergunta(String titulo, String descricao) {
        Object obj = JOptionPane.showInputDialog(null, titulo, descricao, JOptionPane.OK_CANCEL_OPTION);
        return obj;
    }

    /**
     * Retorna um hash MD5 de dada String
     * @param valor
     * @return String
     * @throws NoSuchAlgorithmException
     * @throws Exception
     */
    public static String criptografar(String valor) throws NoSuchAlgorithmException, Exception {
        if (valor == null) {
            return null;
        }
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] cripto = md5.digest(valor.getBytes());
        char[] hex = new char[cripto.length * 2];
        String sb;
        for (int i = 0; i < cripto.length; i++) {
            sb = "00" + Integer.toHexString(cripto[i]);
            sb.toUpperCase().getChars(sb.length() - 2,
                    sb.length(), hex, i * 2);
        }
        return new String(hex);
    }

    /**
     * Retorna uma data formatada no padrão dd/MM/yyyy
     * @param data
     * @return String
     */
    public static String formataData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String format = sdf.format(data);

        return format;
    }

    /**
     * Salva o arquivo de acordo com o objeto a ser salvo no local indicado.
     * @param objeto
     * @param local
     * @param tipo
     * @throws Exception
     */
    public static void exportarArquivo(Object objeto, String local, String tipo) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(local + tipo));
        oos.writeObject(objeto);
        oos.close();
    }

    /**
     * Retorna o objeto do arquivo no local indicado
     * @param local
     * @return Object
     * @throws Exception
     */
    public static Object importaArquivo(String local) throws Exception {
        Object objeto = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(local));
        objeto = ois.readObject();
        return objeto;
    }

    /**
     * Mensagem ao mesclar uma avaliação
     * @param velho
     * @param novo
     * @return int
     */
    public static int opcaoAvaliacao(Object velho, Object novo) {
        int opcao = 0;
        if (velho != null && novo != null) {
            StringBuffer mensagem = new StringBuffer("A prática 1 já foi avaliada como \n2 (4) .");
            mensagem.append("\nDeseja importar o resultado do arquivo como 3 (5)?");
            int a1 = mensagem.indexOf("1");
            int a2 = mensagem.indexOf("2");
            int a3 = mensagem.indexOf("3");
            int a4 = mensagem.indexOf("4");
            int a5 = mensagem.indexOf("5");
            String mensagem1 = "";
            String mensagem2 = "";
            String mensagem3 = "";
            String com1 = "";
            String com2 = "";
            if (velho instanceof AvaliacaoEspecifica) {
                AvaliacaoEspecifica especificaVelho = (AvaliacaoEspecifica) velho;
                AvaliacaoEspecifica especificaNovo = (AvaliacaoEspecifica) novo;
                mensagem3 = especificaNovo.getIdStatusDefinicao() == null ? "'não avaliado'" : especificaNovo.getIdStatusDefinicao().getDescricao();
                mensagem2 = especificaNovo.getIdStatusDefinicao() == null ? "'não avaliado'" : especificaNovo.getIdStatusDefinicao().getDescricao();
                mensagem1 = especificaVelho.getIdpraticaespecifica().toString();
                com2 = (especificaNovo.getComentario().length() > 50) ?
                    especificaNovo.getComentario().substring(0, 50) :
                    especificaNovo.getComentario();
                com1 = (especificaVelho.getComentario().length() > 50) ?
                    especificaVelho.getComentario().substring(0, 50) :
                    especificaVelho.getComentario();
            } else if (velho instanceof AvaliacaoGenerica) {
                AvaliacaoGenerica genericaVelho = (AvaliacaoGenerica) velho;
                AvaliacaoGenerica genericaNovo = (AvaliacaoGenerica) novo;
                mensagem3 = genericaNovo.getIdStatusDefinicao() == null ? "'não avaliado'" : genericaVelho.getIdStatusDefinicao().getDescricao();
                mensagem2 = genericaVelho.getIdStatusDefinicao() == null ? "'não avaliado'" : genericaVelho.getIdStatusDefinicao().getDescricao();
                mensagem3 = genericaVelho.getIdpraticagenerica() == null ? "'não avaliado'" : genericaVelho.getIdpraticagenerica().toString();
                com2 = (genericaNovo.getComentario().length() > 50) ?
                    genericaNovo.getComentario().substring(0, 50) :
                    genericaNovo.getComentario();
                com1 = (genericaVelho.getComentario().length() > 50) ?
                    genericaVelho.getComentario().substring(0, 50) :
                    genericaVelho.getComentario();
            }
            mensagem.replace(a5, a5 + 1, com2);
            mensagem.replace(a4, a4 + 1, com1);
            mensagem.replace(a3, a3 + 1, mensagem3);
            mensagem.replace(a2, a2 + 1, mensagem2);
            mensagem.replace(a1, a1 + 1, mensagem1);
            opcao = JOptionPane.showOptionDialog(null, mensagem, "Atenção", JOptionPane.CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, SUBSTITUIR, SUBSTITUIR[0]);
        }
        return opcao;
    }
}
