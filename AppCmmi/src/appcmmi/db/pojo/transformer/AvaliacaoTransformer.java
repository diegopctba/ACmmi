/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.pojo.transformer;

import appcmmi.db.pojo.avaliacao.GraficoAvaliacao;
import java.util.List;
import org.hibernate.transform.ResultTransformer;

/**
 *
 * @author diego
 */
public class AvaliacaoTransformer implements ResultTransformer {

    @Override
    public Object transformTuple(Object[] arg0, String[] arg1) {
        GraficoAvaliacao graf = new GraficoAvaliacao();
        graf.setTitulo((String)arg0[3]);
        graf.setAreaProcesso((String)arg0[2]);
        graf.setDefinicao((String)arg0[1]);
        graf.setQtde((Integer)arg0[0]);

        return graf;
    }

    @Override
    public List transformList(List arg0) {
        return arg0;
    }
}
