/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.Dao;
import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

/**
 *
 * @author diego
 */
public class StatusInstitucionalizacaoDao extends Dao {

    public StatusInstitucionalizacaoDao() {
        super(StatusInstitucionalizacao.class);
    }

    public void salvar(StatusInstitucionalizacao status) throws Exception {
        super.salvar(status);
    }

    public void atualizar(StatusInstitucionalizacao status) throws Exception {
        super.atualizar(status);
    }

    public List<StatusInstitucionalizacao> retornaTodos() throws Exception {
        List<StatusInstitucionalizacao> lista = new ArrayList<StatusInstitucionalizacao>();
        String sql = "FROM " + StatusInstitucionalizacao.class.getName() + " ORDER BY descricao";
        Query q = session.createQuery(sql);
        lista = q.list();

        return lista;
    }

    public void importa(List<StatusInstitucionalizacao> lista) throws Exception {
        String sql = "DELETE FROM statusinstitucionalizacao";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        super.salvar(lista);
    }

    public void salvarLista(List<StatusInstitucionalizacao> listaStatus) throws Exception {
        Transaction t = session.beginTransaction();
        for (StatusInstitucionalizacao s : listaStatus) {
            session.saveOrUpdate(s);
        }

        t.commit();
    }
}
