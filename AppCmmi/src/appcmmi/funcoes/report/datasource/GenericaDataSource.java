/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.funcoes.report.datasource;

import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import java.util.Collection;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * Classe responsável por informar os dados da avaliação de {@link PraticaGenerica} para emissão de relatório
 * @author Diego
 */
public class GenericaDataSource implements JRDataSource {

    private Iterator generica;
    private Object valor;
    private boolean proximo = true;

    public GenericaDataSource(Collection lista) {
        super();
        this.generica = lista.iterator();
    }

    @Override
    public boolean next() throws JRException {
        valor = generica.hasNext() ? generica.next() : null;
        proximo = (valor != null);
        return proximo;
    }

    @Override
    public Object getFieldValue(JRField campo) throws JRException {
        Object obj = null;
        AvaliacaoGenerica avaliacao = (AvaliacaoGenerica) valor;
        if ("idpraticagenerica".equals(campo.getName())) {
            StringBuffer value = new StringBuffer("GP ");
            value.append(avaliacao.getIdpraticagenerica().toString());
            obj = value.toString();
        } else if ("comentario".equals(campo.getName())) {
            obj = avaliacao.getComentario();
        } else if ("idStatusDefinicao".equals(campo.getName())) {
            obj = avaliacao.getIdStatusDefinicao() != null ? 
                avaliacao.getIdStatusDefinicao().getDescricao() : "";
        } else if ("idStatusComentario".equals(campo.getName())) {
            obj = avaliacao.getIdStatusComentario() != null ? 
                avaliacao.getIdStatusComentario().getDescricao() : "";
        } else if ("artefatoList".equals(campo.getName())) {
            obj = new ArtefatoGenericaDataSource(avaliacao.getArtefatoList());
        } else if ("idAreaProcesso".equals(campo.getName())) {
            obj = avaliacao.getIdAreaProcesso().getTitulo();
        } else if ("idStatusInstitucionalizacao".equals(campo.getName())) {
            obj = avaliacao.getIdStatusInstitucionalizacao() != null ?
                avaliacao.getIdStatusInstitucionalizacao().getDescricao() : "";
        }
        return obj;
    }
}
