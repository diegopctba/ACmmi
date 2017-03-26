/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Classe responsável pela conexão e manipulação da tabela {@link AvaliacaoEspecifica}
 * @author diego
 * @since 17/11/2009
 */
public class AvaliacaoEspecificaDao extends Dao {

    public AvaliacaoEspecificaDao() {
        super(AvaliacaoEspecifica.class);
    }

    /**
     * Salva ou atualiza uma {@link AvaliacaoEspecifica}
     * @param avaliacaoEspecifica
     * @throws Exception
     */
    public void salvarAtualizar(AvaliacaoEspecifica avaliacaoEspecifica) throws Exception {
        super.salvarAtualizar(avaliacaoEspecifica);
    }

    /**
     * Retorna uma lista de {@link AvaliacaoEspecifica}, através da {@code idAvaliacao} e {@code idAreaProcesso}
     * @param idAvaliacao
     * @param idAreaProcesso
     * @return List
     * @throws Exception
     */
    public List<AvaliacaoEspecifica> retornaEspecificaAvaliacaoAreaProcesso(Integer idAvaliacao, Integer idAreaProcesso) throws Exception {
        List<AvaliacaoEspecifica> lista = new ArrayList<AvaliacaoEspecifica>();
        StringBuffer sql = new StringBuffer("FROM ");
        sql.append(AvaliacaoEspecifica.class.getName());
        sql.append(" WHERE idpraticaespecifica.idareaprocesso.idareaprocesso = ");
        sql.append(idAreaProcesso);
        sql.append(" AND idavaliacao.idAvaliacao = ");
        sql.append(idAvaliacao);
        Query query = session.createQuery(sql.toString());
        lista = query.list();
        return lista;
    }

    /**
     * Salva ou atualiza uma lista de {@link AvaliacaoEspecifica}
     * @param lista
     * @throws Exception
     */
    public void salvarAtualizar(List<AvaliacaoEspecifica> lista) throws Exception {
        Transaction t = session.beginTransaction();
        for (AvaliacaoEspecifica e : lista) {
            session.saveOrUpdate(e);
        }
        t.commit();
    }

    /**
     * Retorna a {@link AvaliacaoEspecifica} de acordo com os parâmetros
     * @param idAvaliacao
     * @param idEspecifica
     * @return AvaliacaoEspecifica
     * @throws Exception
     */
    public AvaliacaoEspecifica retornaAvaliacaoEspecifica(Integer idAvaliacao, Integer idEspecifica) throws Exception {
        AvaliacaoEspecifica e = null;
        Criteria c = session.createCriteria(AvaliacaoEspecifica.class);
        c.add(Restrictions.eq("idavaliacao.idAvaliacao", idAvaliacao));
        c.add(Restrictions.eq("idpraticaespecifica.idespecifica", idEspecifica));
        e = (AvaliacaoEspecifica) c.uniqueResult();
        return e;
    }
}
