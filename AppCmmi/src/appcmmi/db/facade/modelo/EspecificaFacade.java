/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade.modelo;

import appcmmi.db.dao.modelo.EspecificaDao;
import appcmmi.db.pojo.modelo.PraticaEspecifica;
import java.util.List;

/**
 * Classe de fachada da {@link PraticaEspecifica}
 * @author diego
 */
public class EspecificaFacade {


    private EspecificaDao dao;

    /**
     * Retorna todas as práticas específicas.
     * @return List<PraticaEspecifica>
     * @throws Exception
     */
    public List<PraticaEspecifica> retornaTodasEspecifica() throws Exception {
        dao = new EspecificaDao();
        return dao.retornaTodasEspecificas();
    }

    /**
     * Retorna uma prática específica de acordo com o id
     * @param id
     * @return PraticaEspecifica
     * @throws Exception
     */
    public PraticaEspecifica retornaEspecificaId(Integer id) throws Exception {
        dao = new EspecificaDao();
        return dao.retornaPraticaId(id);
    }

    /**
     * Salva uma prática específica
     * @param especifica
     * @throws Exception
     */
    public void salvarEspecifica(PraticaEspecifica especifica) throws Exception {
        dao = new EspecificaDao();
        dao.salvar(especifica);
    }

    /**
     * Atualiza uma prática específica
     * @param especifica
     * @throws Exception
     */
    public void atualizarEspecifica(PraticaEspecifica especifica) throws Exception {
        dao = new EspecificaDao();
        dao.atualizar(especifica);
    }

    /**
     * Exclui uma prática específica
     * @param especifica
     * @throws Exception
     */
    public void excluirEspecifica(PraticaEspecifica especifica) throws Exception {
        dao = new EspecificaDao();
        dao.excluir(especifica);
    }

    /**
     * Retorna as práticas específicas para avaliação, ordenadas por maturidade,
     * área de processo e prática específica.
     * @param idMaturidade
     * @return List<PraticaEspecifica>
     * @throws Exception
     */
    public List<PraticaEspecifica> retornaEspecificaAvaliacao(Integer idMaturidade) throws Exception {
        dao = new EspecificaDao();
        return dao.retornaEspecificaAvaliacao(idMaturidade);
    }

    /**
     * Salva uma lista de {@link PraticaEspecifica}
     * @param praticaEspecificaList
     * @throws Exception
     */
    public void salvarEspecifica(List<PraticaEspecifica> praticaEspecificaList) throws Exception {
        dao = new EspecificaDao();
        dao.salvarLista(praticaEspecificaList);
    }
}
