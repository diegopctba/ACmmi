/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.funcoes.report.datasource;

import appcmmi.db.pojo.artefato.ArtefatoEspecifica;
import appcmmi.db.pojo.artefato.ArtefatoGenerica;
import java.util.Collection;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * DataSource responsável pela emissão de dados em relatórios e/ou subrelatórios para objetos {@link ArtefatoEspecifica}
 * @author diego
 */
public class ArtefatoGenericaDataSource implements JRDataSource {

    private Iterator especifica;
    private Object valor;
    private boolean proximo = true;

    public ArtefatoGenericaDataSource(Collection lista) {
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
        ArtefatoGenerica artefato = (ArtefatoGenerica) valor;
        if ("descricao".equals(campo.getName())) {
            obj = artefato.getDescricao();
        } else if ("tipo".equals(campo.getName())) {
            obj = artefato.getIdTipoArtefato() == null ? null : artefato.getIdTipoArtefato().getDescricao();
        } else if ("ativo".equals(campo.getName())) {
            obj = artefato.getAtivo() == null ? null : artefato.getAtivo().getDescricao();
        }
        return obj;
    }

}
