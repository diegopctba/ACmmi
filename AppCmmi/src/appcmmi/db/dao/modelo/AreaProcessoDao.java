/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.modelo;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.modelo.AreaProcesso;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 * Classe responsável pela conexão e manipulação da tabela {@link AreaProcesso}
 * @author diego
 */
public class AreaProcessoDao extends Dao {

    public AreaProcessoDao() {
        super(AreaProcesso.class);
    }

    /**
     * Salva uma nova {@link AreaProcesso}
     * @param areaProcesso
     * @throws Exception
     */
    public void salvarAreaProcesso(AreaProcesso areaProcesso) throws Exception {
        super.salvar(areaProcesso);
    }

    /**
     * Atualiza uma {@link AreaProcesso}
     * @param areaProcesso
     * @throws Exception
     */
    public void atualizarAreaProcesso(AreaProcesso areaProcesso) throws Exception {
        super.atualizar(areaProcesso);
    }

    /**
     * Retorna uma {@link AreaProcesso} através do {@code idAvaliacao}
     * @param id
     * @return AreaProcesso
     * @throws Exception
     */
    public AreaProcesso getAreaProcessoId(Integer id) throws Exception {
        return (AreaProcesso) super.carregar(id);
    }

    /**
     * Retorna todas as {@link AreaProcesso}
     * @return List
     * @throws Exception
     */
    public List<AreaProcesso> getTodasAreaProcesso() throws Exception {
        List<AreaProcesso> lista = new ArrayList<AreaProcesso>();
        StringBuffer sql = new StringBuffer("SELECT ap FROM ");
        sql.append(AreaProcesso.class.getName());
        sql.append(" ap ");
        Query query = session.createQuery(sql.toString());
        lista = query.list();
        return lista;
    }

    /**
     * Exclusão da área de processo
     * @param area
     * @throws Exception
     */
    public void excluirAreaProcesso(AreaProcesso area) throws Exception {
        super.excluir(area);
    }

    /**
     * Retorna todas as áreas de processo de uma maturidade
     * @param idMaturidade
     * @return List
     */
    public List<AreaProcesso> getAreaProcessoPorMaturidade(Integer idMaturidade) {
        List<AreaProcesso> lista = new ArrayList<AreaProcesso>();
        StringBuffer sql = new StringBuffer("SELECT a FROM ");
        sql.append(AreaProcesso.class.getName());
        sql.append(" a WHERE a.idmaturidade.idmaturidade = :idMaturidade");
        Query query = session.createQuery(sql.toString());
        query.setParameter("idMaturidade", idMaturidade);
        lista = query.list();
        return lista;
    }

    /**
     * Salva uma lista de {@link AreaProcesso}
     * @param areaProcessoList
     * @throws Exception
     */
    public void salvarAreaProcesso(List<AreaProcesso> areaProcessoList) throws Exception {
        super.salvar(areaProcessoList);
    }

}
