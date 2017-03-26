/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.funcoes.report.datasource;

import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import java.util.Collection;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Diego
 */
public class EspecificaDataSource implements JRDataSource {

    private Iterator especifica;
    private Object valor;
    private boolean proximo = true;

    public EspecificaDataSource(Collection lista) {
        super();
        this.especifica = lista.iterator();
    }

    @Override
    public boolean next() throws JRException {
        valor = especifica.hasNext() ? especifica.next() : null;
        proximo = (valor != null);
        return proximo;
    }

    @Override
    public Object getFieldValue(JRField campo) throws JRException {
        Object obj = null;
        AvaliacaoEspecifica avaliacao = (AvaliacaoEspecifica) valor;
        if ("idpraticaespecifica".equals(campo.getName())) {
            StringBuffer value = new StringBuffer("SP ");
            value.append(avaliacao.getIdpraticaespecifica().toString());
            obj = value.toString();
        } else if ("comentario".equals(campo.getName())) {
            obj = avaliacao.getComentario();
        } else if ("idStatusDefinicao".equals(campo.getName())) {
            obj = avaliacao.getIdStatusDefinicao() != null ? avaliacao.getIdStatusDefinicao().getDescricao() : "";
        } else if ("idStatusComentario".equals(campo.getName())) {
            obj = avaliacao.getIdStatusComentario() != null ? avaliacao.getIdStatusComentario().getDescricao() : "";
        } else if ("artefatoList".equals(campo.getName())) {
            obj = new ArtefatoEspecificaDataSource(avaliacao.getArtefatoList());
        } else if ("areaprocesso".equals(campo.getName())) {
            obj = avaliacao.getIdpraticaespecifica().getIdareaprocesso().getTitulo();
        } else if ("idStatusInstitucionalizacao".equals(campo.getName())) {
            obj = avaliacao.getIdStatusInstitucionalizacao() != null ? avaliacao.getIdStatusInstitucionalizacao().getDescricao() : "";
        }
        return obj;
    }
}
