/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.funcoes.report.datasource;

import appcmmi.db.pojo.avaliacao.Avaliacao;
import java.util.Collection;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Diego
 */
public class AvaliacaoDataSource implements JRDataSource {

    private Iterator especifica;
    private Object valor;
    private boolean proximo = true;

    public AvaliacaoDataSource(Collection lista) {
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
        Avaliacao avaliacao = (Avaliacao) valor;
        if ("idempresa".equals(campo.getName())) {
            obj = avaliacao.getIdempresa().getRazaosocial();
        } else if ("comentario".equals(campo.getName())) {
            obj = avaliacao.getComentario();
        } else if ("definicao".equals(campo.getName())) {
            obj = avaliacao.getDefinicao();
        } else if ("institucionalizacao".equals(campo.getName())) {
            obj = avaliacao.getInstitucionalizacao();
        } else if ("idmaturidade".equals(campo.getName())) {
            obj = avaliacao.getIdmaturidade().getTitulo();
        } else if ("dataInicio".equals(campo.getName())) {
            obj = avaliacao.getDataInicio();
        } else if ("dataFim".equals(campo.getName())) {
            obj = avaliacao.getDataFim();
        } else if ("avaliacaoEspecificaList".equals(campo.getName())) {
            EspecificaDataSource esp = new EspecificaDataSource(avaliacao.getAvaliacaoEspecificaList());
            obj = esp;
        } else if ("avaliacaoGenericaList".equals(campo.getName())) {
            obj = new GenericaDataSource(avaliacao.getAvaliacaoGenericaList());
        }
        return obj;
    }
}
