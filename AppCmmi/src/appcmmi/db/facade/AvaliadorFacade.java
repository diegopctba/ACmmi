/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade;

import appcmmi.db.dao.AvaliadorDao;
import appcmmi.db.pojo.Avaliador;
import java.util.List;

/**
 * Classe de fachada de {@link Avaliador}
 * @author diego
 */
public class AvaliadorFacade {

    private AvaliadorDao dao;

    /**
     * salva um novo {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void salvar(Avaliador avaliador) throws Exception {
        dao = new AvaliadorDao();
        dao.salvar(avaliador);
    }

    /**
     * Salva ou atualiza um {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void salvarAtualizar(Avaliador avaliador) throws Exception {
        dao = new AvaliadorDao();
        dao.salvarAtualizar(avaliador);
    }

    /**
     * Exclui um {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void excluir(Avaliador avaliador) throws Exception {
        dao = new AvaliadorDao();
        dao.excluir(avaliador);
    }

    /**
     * Retorna uma lista com todas as {@link Avaliador}
     * @return List
     * @throws Exception
     */
    public List<Avaliador> listar() throws Exception {
        dao = new AvaliadorDao();
        return dao.listar();
    }

    /**
     * Retorna uma lista de {@link Avaliador} de acordo com os parâmetros.
     * @param id
     * @param nome
     * @param cpf
     * @param rg
     * @return List
     * @throws Exception
     */
    public List<Avaliador> pesquisarAvaliador(String id, String nome, String cpf, String rg) throws Exception {
        dao = new AvaliadorDao();
        return dao.pesquisar(id, nome, cpf, rg);
    }
}
