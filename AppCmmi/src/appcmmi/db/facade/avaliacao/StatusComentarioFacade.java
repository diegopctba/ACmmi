/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.StatusComentarioDao;
import appcmmi.db.pojo.avaliacao.StatusComentario;
import java.util.List;

/**
 * Classe de fachada da {@link StatusComentario}
 * @author diego
 */
public class StatusComentarioFacade {

    /**
     * Retorna uma lista com todas {@link StatusComentario}
     * @return List
     * @throws Exception
     */
    public List<StatusComentario> retornaTodosStatusComentario() throws Exception {
        return new StatusComentarioDao().retornaTodosStatusComentario();
    }

    /**
     * Salva uma lista de {@link StatusComentario}
     * @param listastatuscomentario
     * @throws Exception
     */
    public void salvarStatusComentario(List<StatusComentario> listastatuscomentario) throws Exception {
        new StatusComentarioDao().salvarStatus(listastatuscomentario);
    }
}
