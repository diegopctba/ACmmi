/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.dao.modelo;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.modelo.Maturidade;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * Classe de acesso ao banco de dados, responsável pela Maturidade
 * @author diego
 */
public class MaturidadeDao extends Dao {

    public MaturidadeDao() throws Exception {
        super(Maturidade.class);
    }

    /**
     * Carrega uma maturidade através do id
     * @param id
     * @return Maturidade
     * @throws Exception
     */
    public Maturidade carregaMaturidade(Integer id) throws Exception {
        return (Maturidade) super.carregar(id);
    }

    /**
     * Salva uma nova maturidade
     * @param maturidade
     * @throws Exception
     */
    public void salvarMaturidade(Maturidade maturidade) throws Exception {
        super.salvar(maturidade);
    }

    /**
     * Remove uma maturidade
     * @param maturidade
     * @throws Exception
     */
    public void deletarMaturidade(Maturidade maturidade) throws Exception {
        super.excluir(maturidade);
    }

    /**
     * Atualiza uma maturidade
     * @param maturidade
     * @throws Exception
     */
    public void atualizarMaturidade(Maturidade maturidade) throws Exception {
        super.atualizar(maturidade);
    }

    /**
     * Retorna todas as maturidades cadastradas
     * @return List
     * @throws Exception
     */
    public List<Maturidade> listaTodasMaturidade() throws Exception {
        List<Maturidade> listaMaturidade = new ArrayList<Maturidade>();
        StringBuffer sql = new StringBuffer("SELECT m FROM ");
        sql.append(Maturidade.class.getName());
        sql.append(" m ORDER BY numMaturidade ");
        Query query = session.createQuery(sql.toString());
        listaMaturidade = query.list();

        return listaMaturidade;
    }

    /**
     * Retorna uma lista de Maturidades regressiva ao nível indicado.
     * Exemplo: ao solicitar o nível 4, retorna os níveis 4, 3, 2...
     * @param maturidade
     * @return List<Maturidade>
     * @throws Exception
     */
    public List<Maturidade> listaMaturidadesAvaliacao(Integer maturidade) throws Exception {
        List<Maturidade> lista = new ArrayList<Maturidade>();
        StringBuffer sql = new StringBuffer("FROM ");
        sql.append(Maturidade.class.getName());
        sql.append(" WHERE nummaturidade <= ");
        sql.append(maturidade);
        Query q = session.createQuery(sql.toString());
        lista = q.list();

        return lista;
    }

    /**
     * Este método remove todas as práticas, áreas de processos e maturidade, e insere os novos valores à partir de uma lista.
     * @param lista
     * @throws Exception
     */
    public void salvarMaturidade(List<Maturidade> lista) throws Exception {
        String sqlgen = "DELETE FROM praticagenerica";
        String sqlEsp = "DELETE FROM praticaespecifica";
        String sqlArea = "DELETE FROM areaprocesso";
        String sqlMat = "DELETE FROM maturidade";
        SQLQuery query = session.createSQLQuery(sqlgen);
        query.executeUpdate();
        query = session.createSQLQuery(sqlEsp);
        query.executeUpdate();
        query = session.createSQLQuery(sqlArea);
        query.executeUpdate();
        query = session.createSQLQuery(sqlMat);
        query.executeUpdate();
        super.salvar(lista);
    }
}
