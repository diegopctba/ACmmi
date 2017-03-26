/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.funcoes;

import appcmmi.funcoes.report.datasource.AvaliacaoDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 * Classe responsável por montar e imprimr os relatórios.
 * @author diego
 */
public class GerarRelatorio {

    private static final String PREFIX = "/appcmmi/funcoes/report/";
    private static final String PREFIX2 = "/home/diego/NetBeansProjects/AppCmmi/src/appcmmi/funcoes/report/";
    private static final String SUFIX = ".jasper";
    private static final String TYPE = ".pdf";

    /**
     * Gerar o relatorio de acordo com os parâmetros
     * @param name nome do relatório
     * @param type tipo de saída
     * @param data Coleção de algum pojo;
     * @throws java.io.IOException
     * @throws java.lang.Exception
     */
    public void jasperReport(String name, Collection data) throws IOException, Exception {
        report(null, name, carregarPrint(name, data, null, null));
    }

    /**
     * Gera o relatório de acordo com os parâmetros
     * @param file
     * @param name
     * @param data
     * @throws IOException
     * @throws Exception
     */
    public void jasperReport(File file, String name, Collection data) throws IOException, Exception {
        report(file, name, carregarPrint(name, data, null, null));
    }

    /**
     * Gera o relatório de acordo com os parâmetros
     * @param file
     * @param name
     * @param data
     * @throws IOException
     * @throws Exception
     */
    public void jasperReport(File file, String name, Collection data, Map param) throws IOException, Exception {
        report(file, name, carregarPrint(name, data, param, null));
    }

    public void jasperReport(String name, AvaliacaoDataSource avaliacaoDataSource, Map<String, Object> map) throws IOException, Exception {
        report(null, name, carregarPrint(name, null, map, avaliacaoDataSource));
    }

    /**
     * Gera e imprime o relatório com os dados dos parâmetros
     * @param name
     * @param data
     * @param params
     * @throws IOException
     * @throws Exception
     */
    public void jasperReport(String name, Collection data, Map params) throws IOException, Exception {
        report(null, name, carregarPrint(name, data, params, null));
    }

    /**
     * Gera o print para ser exportado em arquivo.
     * @param name
     * @param data
     * @param params
     * @return JasperPrint
     * @throws IOException
     * @throws Exception
     */
    private JasperPrint carregarPrint(String name, Collection data, Map params, JRDataSource dataSource) throws IOException, Exception {

        //InputStream stream = new getResourceAsStream(PREFIX + name + SUFIX);
        InputStream stream = new FileInputStream(new File(getClass().getResource(PREFIX + name + SUFIX).getFile()));
        if (stream == null) {
            throw new IllegalArgumentException("nome relatorio desconhecido");
        }
        JasperPrint print = null;
        try {
            if (data != null) {
                print = JasperFillManager.fillReport(stream, params, new JRBeanCollectionDataSource(data));
            } else if (dataSource != null) {
                print = JasperFillManager.fillReport(stream, params, dataSource);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                throw ex;
            }
        }
        return print;
    }

    /**
     * Imprime o relatório para arquivo
     * @param file
     * @param name
     * @param print
     * @throws IOException
     * @throws Exception
     */
    private void report(File file, String name, JasperPrint print) throws IOException, Exception {
        JRExporter exporter = null;
        OutputStream output = null;
        if (file != null) {
            output = new FileOutputStream(new File(file.getPath() + File.separator + name + TYPE));
        } else {
            output = new FileOutputStream(new File(name + TYPE));
        }
        try {
            exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
            exporter.exportReport();
        } catch (Exception e) {
            throw e;
        }


    }

    public void jasperReport(File local, String string, AvaliacaoDataSource avaliacaoDataSource) throws IOException, Exception {
        report(local, string, carregarPrint(string, null, null, avaliacaoDataSource));
    }

    public void jasperReport(File local, String string, AvaliacaoDataSource avaliacaoDataSource, Map<String, Object> param) throws IOException, Exception {
        report(local, string, carregarPrint(string, null, param, avaliacaoDataSource));
    }
}
