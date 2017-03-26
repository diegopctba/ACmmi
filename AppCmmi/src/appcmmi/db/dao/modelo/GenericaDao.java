/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.modelo;

import appcmmi.db.dao.*;
import appcmmi.db.HibernateUtil;
import appcmmi.db.pojo.modelo.PraticaGenerica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 * Classe de acesso ao banco, responsável pela Prática Genérica
 * @author diego
 * @since 28/10/2009
 */
public class GenericaDao extends Dao {

    public GenericaDao() {
        super(PraticaGenerica.class);
    }

    /**
     * Retorna todas as práticas genéricas
     * @return List<PraticaGenerica>
     * @throws Exception
     */
    public List<PraticaGenerica> retornaTodasEspecificas() throws Exception {
        List<PraticaGenerica> lista = new ArrayList<PraticaGenerica>();
        Criteria criteria = HibernateUtil.currentSession().createCriteria(PraticaGenerica.class);
        criteria.addOrder(Order.asc("numpraticagenerica"));
        lista = criteria.list();
        return lista;
    }

    /**
     * Retorna as práticas genéricas relacionadas à uma maturidade
     * @param idMaturidade
     * @return List<PraticaGenerica
     * @throws Exception
     */
    public List<PraticaGenerica> retornaGenericaMaturidade(Integer idMaturidade) throws Exception {
        List<PraticaGenerica> lista = new ArrayList<PraticaGenerica>();
        StringBuffer sql = new StringBuffer("SELECT g FROM ");
        sql.append(PraticaGenerica.class.getName());
        sql.append(" g WHERE g.idmaturidade.idmaturidade = :idMaturidade");
        Query query = session.createQuery(sql.toString());
        query.setParameter("idMaturidade", idMaturidade);
        lista = query.list();
        return lista;
    }

    /**
     * Retorna as práticas genéricas para avaliação.
     * É informado o nível de maturidade.
     * @param idMaturidade
     * @return List<PraticaGenerica>
     * @throws Exception
     */
    public List<PraticaGenerica> retornaGenericaAvaliacao(Integer idMaturidade) throws Exception {
        List<PraticaGenerica> lista = new ArrayList<PraticaGenerica>();
        StringBuffer sql = new StringBuffer(" FROM ");
        sql.append(PraticaGenerica.class.getName());
        sql.append(" WHERE idmaturidade.nummaturidade <= ");
        sql.append(idMaturidade);
        sql.append(" ORDER BY numpraticagenerica");

        Query query = session.createQuery(sql.toString());
        lista = query.list();

        return lista;
    }

    /**
     * Salva uma prática genérica
     * @param generica
     * @throws Exception
     */
    public void salvar(PraticaGenerica generica) throws Exception {
        super.salvar(generica);
    }

    /**
     * Atualiza uma prática genérica
     * @param generica
     * @throws Exception
     */
    public void atualizar(PraticaGenerica generica) throws Exception {
        super.atualizar(generica);
    }

    /**
     * Retorna uma prática genérica através do idPraticaGenerica
     * @param id
     * @return PraticaGenerica
     * @throws Exception
     */
    public PraticaGenerica retornaPraticaId(Integer id ) throws Exception {
        return (PraticaGenerica) super.carregar(id);
    }

    /**
     * Exclui uma prática genérica.
     * @param generica
     * @throws Exception
     */
    public void excluir(PraticaGenerica generica) throws Exception {
        super.excluir(generica);
    }

    /**
     * Salva uma lista de {@link PraticaGenerica}
     * @param praticaGenericaList
     * @throws Exception
     */
    public void salvarLista(List<PraticaGenerica> praticaGenericaList) throws Exception {
        super.salvar(praticaGenericaList);
    }
}
