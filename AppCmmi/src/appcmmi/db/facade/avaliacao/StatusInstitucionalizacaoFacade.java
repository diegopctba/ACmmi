/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.StatusInstitucionalizacaoDao;
import appcmmi.db.pojo.avaliacao.StatusInstitucionalizacao;
import java.util.List;

/**
 *
 * @author diego
 */
public class StatusInstitucionalizacaoFacade {

    public void salvarStatus(StatusInstitucionalizacao status) throws Exception {
        new StatusInstitucionalizacaoDao().salvar(status);
    }

    public void atualizarStatus(StatusInstitucionalizacao status) throws Exception {
        new StatusInstitucionalizacaoDao().atualizar(status);
    }

    public void importar(List<StatusInstitucionalizacao> lista) throws Exception {
        new StatusInstitucionalizacaoDao().importa(lista);
    }

    public List<StatusInstitucionalizacao> retornaTodosStatus() throws Exception {
        return new StatusInstitucionalizacaoDao().retornaTodos();
    }

    public void salvarListaStatus(List<StatusInstitucionalizacao> listaStatus) throws Exception {
        new StatusInstitucionalizacaoDao().salvarLista(listaStatus);
    }
}
