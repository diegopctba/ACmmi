/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.dao.modelo;

import appcmmi.db.dao.*;
import appcmmi.db.pojo.modelo.PraticaEspecifica;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 * Classe de acesso ao banco de dados, responsável pela Prática Específica
 * @author diego
 * @since 28/10/2009
 */
public class EspecificaDao extends Dao {

    public EspecificaDao() {
        super(PraticaEspecifica.class);
    }

    /**
     * Retorna todas as práticas específicas,
     * ordenadas por Maturidade, Área de Processo e por número da prática.
     * @return List
     * @throws Exception
     */
    public List<PraticaEspecifica> retornaTodasEspecificas() throws Exception {
        List<PraticaEspecifica> lista = new ArrayList<PraticaEspecifica>();
        StringBuffer hql = new StringBuffer(" FROM ");
        hql.append(PraticaEspecifica.class.getName());
        hql.append(" ORDER BY idareaprocesso.idmaturidade.idmaturidade, ");
        hql.append(" idareaprocesso.idareaprocesso, ");
        hql.append(" numpraticaespecifica");
        Query q = session.createQuery(hql.toString());
        lista = q.list();
        return lista;
    }

    /**
     * Salva uma nova {@link PraticaEspecifica}
     * @param especifica
     * @throws Exception
     */
    public void salvar(PraticaEspecifica especifica) throws Exception {
        super.salvar(especifica);
    }

    /**
     * Atualiza uma {@link PraticaEspecifica}
     * @param especifica
     * @throws Exception
     */
    public void atualizar(PraticaEspecifica especifica) throws Exception {
        super.atualizar(especifica);
    }

    /**
     * Retorna uma {@link PraticaEspecifica} através do {@code idPraticaEspecifica}
     * @param id
     * @return PraticaEspecifica
     * @throws Exception
     */
    public PraticaEspecifica retornaPraticaId(Integer id) throws Exception {
        return (PraticaEspecifica) super.carregar(id);
    }

    /**
     * Exclui uma {@link PraticaEspecifica}
     * @param especifica
     * @throws Exception
     */
    public void excluir(PraticaEspecifica especifica) throws Exception {
        super.excluir(especifica);
    }

    /**
     * Retorna as práticas específicas para avaliação.
     * @param numMaturidade
     * @return List<PraticaEspecifica>
     * @throws Exception
     */
    public List<PraticaEspecifica> retornaEspecificaAvaliacao(Integer numMaturidade) throws Exception {
        List<PraticaEspecifica> lista = new ArrayList<PraticaEspecifica>();
        StringBuffer sql = new StringBuffer(" FROM ");
        sql.append(PraticaEspecifica.class.getName());
        sql.append(" WHERE idareaprocesso.idmaturidade.nummaturidade <= ");
        sql.append(numMaturidade);
        sql.append(" ORDER BY idareaprocesso.idmaturidade.nummaturidade, ");
        sql.append(" idareaprocesso.numareaprocesso, numpraticaespecifica");
        Query query = session.createQuery(sql.toString());
        lista = query.list();
        return lista;
    }

    /**
     * Salva uma lista de {@link PraticaEspecifica}
     * @param praticaEspecificaList
     * @throws Exception
     */
    public void salvarLista(List<PraticaEspecifica> praticaEspecificaList) throws Exception {
        super.salvar(praticaEspecificaList);
    }


}
