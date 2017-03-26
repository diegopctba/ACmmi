/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * Classe de acesso ao banco de dados responsável pelo Status
 * @author diego
 */
public class StatusDao extends Dao {

    public StatusDao() {
        super(StatusDefinicao.class);
    }

    /**
     * Salva um novo Status
     * @param status
     * @throws Exception
     */
    public void salvarAtualizar(StatusDefinicao status) throws Exception {
        super.salvarAtualizar(status);
    }

    /**
     * Atualiza um Status
     * @param status
     * @throws Exception
     */
    public void atualizar(StatusDefinicao status) throws Exception {
        super.atualizar(status);
    }

    /**
     * Excluir um Status
     * @param status
     * @throws Exception
     */
    public void excluir(StatusDefinicao status) throws Exception {
        super.excluir(status);
    }

    /**
     * Retorna um Status à partir do idStatus
     * @param idStatus
     * @return Status
     * @throws Exception
     */
    public StatusDefinicao carrega(Integer idStatus) throws Exception {
        return (StatusDefinicao) super.carregar(idStatus);
    }

    /**
     * Retorna uma lista de todos os Status, ordenado por descrição
     * @return List<Status>
     * @throws Exception
     */
    public List<StatusDefinicao> retornaTodosStatus() throws Exception {
        List<StatusDefinicao> lista = new ArrayList<StatusDefinicao>();
        String sql = "FROM "+StatusDefinicao.class.getName() + " ORDER BY descricao";
        Query query = session.createQuery(sql);
        lista = query.list();
        return lista;
    }

    /**
     * Remove todos os tipos {@link Status} para posterior importação
     * @param lista
     * @throws Exception
     */
    public void importa(List<StatusDefinicao> lista) throws Exception {
        String sql = "DELETE FROM statusdefinicao";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        super.salvar(lista);
    }
}
