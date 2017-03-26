/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.StatusDao;
import appcmmi.db.pojo.avaliacao.StatusDefinicao;
import java.util.List;

/**
 * Classe de fachada de {@link Status}
 * @author diego
 * @since 14/11/2009
 */
public class StatusFacade {

    /**
     * Salva um novo Status
     * @param status
     * @throws Exception
     */
    public void salvarStatus(StatusDefinicao status) throws Exception {
        new StatusDao().salvarAtualizar(status);
    }

    /**
     * Atualiza um Status
     * @param status
     * @throws Exception
     */
    public void atualizarStatus(StatusDefinicao status) throws Exception {
        new StatusDao().atualizar(status);
    }

    /**
     * Remove o Status no banco de dados
     * @param status
     * @throws Exception
     */
    public void removerStatus(StatusDefinicao status) throws Exception {
        new StatusDao().excluir(status);
    }

    /**
     * Retorna uma lista com todos os Status
     * @return List<Status>
     * @throws Exception
     */
    public List<StatusDefinicao> retornaTodosStatus() throws Exception {
        return new StatusDao().retornaTodosStatus();
    }

    /**
     * Salva todos os objetos {@link Status} da lista.
     * @param listaStatus
     * @throws Exception
     */
    public void salvarListaStatus(List<StatusDefinicao> listaStatus) throws Exception {
        for (StatusDefinicao s : listaStatus) {
            salvarStatus(s);
        }
    }

    /**
     * Importa uma lista de {@link Status}
     * @param lista
     * @throws Exception
     */
    public void importaStatus(List<StatusDefinicao> lista) throws Exception {
        new StatusDao().importa(lista);
    }
}
