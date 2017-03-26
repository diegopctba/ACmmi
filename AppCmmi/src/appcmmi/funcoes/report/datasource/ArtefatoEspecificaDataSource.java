/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.funcoes.report.datasource;

import appcmmi.db.pojo.artefato.ArtefatoEspecifica;
import java.util.Collection;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * DataSource responsável pela emissão de dados em relatórios e/ou subrelatórios para objetos {@link ArtefatoEspecifica}
 * @author diego
 */
public class ArtefatoEspecificaDataSource implements JRDataSource {

    private Iterator especifica;
    private Object valor;
    private boolean proximo = true;

    public ArtefatoEspecificaDataSource(Collection lista) {
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
        ArtefatoEspecifica artefato = (ArtefatoEspecifica) valor;
        if ("descricao".equals(campo.getName())) {
            obj = artefato.getDescricao();
        } else if ("tipo".equals(campo.getName())) {
            obj = artefato.getIdTipoArtefatoEspecifica().getDescricao();
        } else if ("ativo".equals(campo.getName())) {
            obj = artefato.getAtivo() == null ? null : artefato.getAtivo().getDescricao();
        }
        return obj;
    }

}
