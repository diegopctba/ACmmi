/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.artefato;

import appcmmi.db.dao.Dao;
import appcmmi.db.pojo.artefato.TipoArtefato;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * Classe responsável pela conexão e manipulação de dados da tabela {@link TipoArtefato}
 * @author diego
 */
public class TipoArtefatoDao extends Dao {

    public TipoArtefatoDao() {
        super(TipoArtefatoDao.class);
    }

    /**
     * Salva ou atualiza um novo {@link TipoArtefato}
     * @param tipoArtefato
     * @throws Exception
     */
    public void salvarAtualizar(TipoArtefato tipoArtefato) throws Exception {
        super.salvarAtualizar(tipoArtefato);
    }

    /**
     * Remove um {@link TipoArtefato}
     * @param tipoArtefato
     * @throws Exception
     */
    public void remover(TipoArtefato tipoArtefato) throws Exception {
        super.excluir(tipoArtefato);
    }

    /**
     * Retorna uma lista com todos {@link TipoArtefato} ordenados pelo campo <i>descrição</i>
     * @return List
     * @throws Exception
     */
    public List<TipoArtefato> retornaTodosTipoArtefato() throws Exception {
        List<TipoArtefato> lista = new ArrayList<TipoArtefato>();
        StringBuffer sql = new StringBuffer("FROM ");
        sql.append(TipoArtefato.class.getName());
        sql.append(" ORDER BY descricao");
        Query query = session.createQuery(sql.toString());
        lista = query.list();
        return lista;
    }

    /**
     * Salva ou atualiza uma lista de {@link TipoArtefato}
     * @param lista
     * @throws Exception
     */
    public void salvarAtualizar(List<TipoArtefato> lista) throws Exception {
        super.salvar(lista);
    }

    /**
     * Remove todos {@link TipoArtefato} cadastrado para realizar a importação à partir de um arquivo.
     * @param lista
     * @throws Exception
     */
    public void importa(List<TipoArtefato> lista) throws Exception {
        String sql = "DELETE FROM tipoartefato";
        SQLQuery query = session.createSQLQuery(sql);
        query.executeUpdate();
        super.salvar(lista);
    }
}
