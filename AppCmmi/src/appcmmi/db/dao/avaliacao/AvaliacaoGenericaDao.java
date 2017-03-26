/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Classe de acesso ao banco de dados, responsável pela {@link AvaliacaoGenerica}
 * @author diego
 * @since 18/11/2009
 */
public class AvaliacaoGenericaDao extends Dao {

    public AvaliacaoGenericaDao() {
        super(AvaliacaoGenerica.class);
    }

    /**
     * Caso a AvaliacaoGenerica não possua referência no banco de dados, salva a avaliação genérica.
     * Se houver referência, atualiza-o.
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAtualizar(AvaliacaoGenerica avaliacao) throws Exception {
        super.salvarAtualizar(avaliacao);
    }

    /**
     * Salva ou atualiza uma lista de {@link AvaliacaoGenerica}.
     * @param lista
     * @throws Exception
     */
    public void salvarAtualizar(List<AvaliacaoGenerica> lista) throws Exception {
        Transaction t = session.beginTransaction();
        for (AvaliacaoGenerica g : lista) {
            session.saveOrUpdate(g);
        }
        t.commit();
    }

    /**
     * Com base no parâmetro <code>idMaturidade</code>, retorna a lista de avaliações de práticas genérica de uma avaliação.
     * Atenção: <b>idMaturidade deve ser a maturidade de nível mais alto da avaliação.</b>
     * @param idMaturidade
     * @param idAvaliacao
     * @return List<AvaliacaoGenerica>
     * @throws Exception
     */
    public List<AvaliacaoGenerica> retornaAvaliacaoGenericaMaturidade(Integer idMaturidade, Integer idAvaliacao, Integer idAreaprocesso) throws Exception {
        List<AvaliacaoGenerica> lista = new ArrayList<AvaliacaoGenerica>();
        StringBuffer sql = new StringBuffer("FROM ");
        sql.append(AvaliacaoGenerica.class.getName());
        sql.append(" WHERE idpraticagenerica.idmaturidade.idmaturidade = ");
        sql.append(idMaturidade);
        sql.append(" AND idAreaProcesso.idareaprocesso = ");
        sql.append(idAreaprocesso);
        sql.append(" AND idavaliacao.idAvaliacao = ");
        sql.append(idAvaliacao);
        Query query = session.createQuery(sql.toString());
        lista = query.list();
        return lista;
    }

    /**
     * Retorna uma lista de {@link AvaliacaoGenerica} pesquisada pela {@code idAvaliacao} e {@code idGenerica}
     * @param idAvaliacao
     * @param idGenerica
     * @return AvaliacaoGenerica
     * @throws Exception
     */
    public AvaliacaoGenerica retornaAvaliacaoGenerica(Integer idAvaliacao, Integer idGenerica) throws Exception {
        AvaliacaoGenerica g = null;
        Criteria c = session.createCriteria(AvaliacaoGenerica.class);
        c.add(Restrictions.eq("idavaliacao.idAvaliacao", idAvaliacao));
        c.add(Restrictions.eq("idpraticagenerica.idgenerica", idGenerica));
        g = (AvaliacaoGenerica) c.uniqueResult();
        return g;
    }
}
