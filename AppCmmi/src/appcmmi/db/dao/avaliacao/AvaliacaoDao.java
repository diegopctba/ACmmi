/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.GraficoAvaliacao;
import appcmmi.db.pojo.transformer.AvaliacaoTransformer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

/**
 * Classe de acesso ao banco de dados, responsável pela Avaliacao
 * @author diego
 * @since 13/11/2009
 */
public class AvaliacaoDao extends Dao {

    public AvaliacaoDao() {
        super(Avaliacao.class);
    }

    /**
     * Salva a avaliação
     * @param avaliacao
     * @throws Exception
     */
    public void salvar(Avaliacao avaliacao) throws Exception {
        super.salvar(avaliacao);
    }

    /**
     * Salva ou atualiza a avaliação
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAtualizar(Avaliacao avaliacao) throws Exception {
        super.salvarAtualizar(avaliacao);
    }

    /**
     * Remove a avaliação do banco de dados.
     * @param avaliacao
     * @throws Exception
     */
    public void apaga(Avaliacao avaliacao) throws Exception {
        super.excluir(avaliacao);
    }

    /**
     * Retorna uma avaliação de acordo com o id
     * @param idAvaliacao
     * @return Avaliacao
     * @throws Exception
     */
    public Avaliacao carrega(Integer idAvaliacao) throws Exception {
        return (Avaliacao) super.carregar(idAvaliacao);
    }

    /**
     * Pesquisa {@link Avaliacao} de acordo com os diversos parâmetros recebidos.
     * @param idEmpresa
     * @param idMaturidade
     * @param de
     * @param ate
     * @param definicao
     * @param institucionalizacao
     * @return List
     * @throws Exception
     */
    public List<Avaliacao> pesquisaAvaliacao(Integer idEmpresa, Integer idMaturidade,
            String de, String ate, Boolean definicao, Boolean institucionalizacao) throws Exception {
        List<Avaliacao> lista = new ArrayList<Avaliacao>();
        StringBuffer sql = new StringBuffer("FROM ");
        Map<String, Object> map = new HashMap<String, Object>();
        sql.append(Avaliacao.class.getName());
        sql.append(" WHERE ");
        if (idEmpresa != null && idEmpresa != 0) {
            sql.append(" idempresa.idempresa = :idempresa AND ");
            map.put("idempresa", idEmpresa);
        }
        if (idMaturidade != null && idMaturidade != 0) {
            sql.append(" idmaturidade.idmaturidade = :idmaturidade AND ");
            map.put("idmaturidade", idMaturidade);
        }
        if (definicao != null && definicao == true) {
            sql.append(" definicao = :definicao AND ");
            map.put("definicao", definicao);
        }
        if (institucionalizacao != null && institucionalizacao == true) {
            sql.append(" institucionalizacao = :institucionalizacao AND ");
            map.put("institucionalizacao", institucionalizacao);
        }
        if (de != null && !de.isEmpty()) {
            sql.append(" dataCriacao >= :de AND ");
            map.put("de", de);
        }
        if (ate != null && !ate.isEmpty()) {
            sql.append(" dataCriacao <= :ate AND ");
            map.put("ate", ate);
        }
        Query q = session.createQuery(sql.substring(0, sql.length() - 5));
        for (Map.Entry<String, Object> e : map.entrySet()) {
            q.setParameter(e.getKey(), e.getValue());
        }
        lista = q.list();

        return lista;
    }

    /**
     * Importa uma avaliação.
     * @param avaliacao
     * @throws Exception
     */
    public void importar(Avaliacao avaliacao) throws Exception {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.merge(avaliacao);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            throw new Exception(e);
        }
    }

    /**
     * Retorna o {@code idAvaliacao} da classe {@link Avaliacao}, pesquisado atraǘes da senha e data de criação.
     * @param avaliacao
     * @return Integer
     * @throws Exception
     */
    public Integer idAvaliacaoLocal(Avaliacao avaliacao) throws Exception {
        Integer id = null;
        StringBuffer sql = new StringBuffer("SELECT idavaliacao FROM avaliacao ");
        sql.append("WHERE senha = '");
        sql.append(avaliacao.getSenha());
        sql.append("' AND dataCriacao = '");
        sql.append(avaliacao.getDataCriacao());
        sql.append("'");
        SQLQuery query = session.createSQLQuery(sql.toString());
        id = (Integer) query.uniqueResult();
        return id;
    }

    public List<GraficoAvaliacao> retornaGraficoAvaliacao(Integer idavaliacao) throws Exception {
        List<GraficoAvaliacao> lista = new ArrayList<GraficoAvaliacao>();
        StringBuffer sql = new StringBuffer("SELECT COUNT(*) qtde, sd.descricao, ap.sigla,");
        sql.append(" ap.titulo");
        sql.append(" FROM AvaliacaoEspecifica ae");
        sql.append(" INNER JOIN StatusDefinicao sd ON ae.IDSTATUSDEFINICAO = sd.IDSTATUS");
        sql.append(" INNER JOIN PRATICAESPECIFICA pe ON ae.IDPRATICAESPECIFICA_IDESPECIFICA = pe.IDESPECIFICA");
        sql.append(" INNER JOIN AREAPROCESSO ap on pe.IDAREAPROCESSO = ap.IDAREAPROCESSO");
        sql.append(" WHERE ae.IDAVALIACAO_IDAVALIACAO = ");
        sql.append(idavaliacao);
        sql.append(" GROUP BY sd.descricao, ap.sigla, ap.titulo");
        sql.append(" ORDER BY ap.titulo, sd.descricao");
        SQLQuery query = session.createSQLQuery(sql.toString());
        System.out.println(sql.toString());
        query.setResultTransformer(new AvaliacaoTransformer());
        lista = query.list();
        
        return lista;
    }
}
