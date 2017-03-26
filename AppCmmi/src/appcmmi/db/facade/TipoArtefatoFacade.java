/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade;

import appcmmi.db.dao.artefato.TipoArtefatoDao;
import appcmmi.db.pojo.artefato.TipoArtefato;
import java.util.List;

/**
 * Classe de fachada do {@link TipoArtefato}
 * @author diego
 */
public class TipoArtefatoFacade {

    /**
     * Salva ou atualiza um {@link TipoArtefato}
     * @param tipoArtefato
     * @throws Exception
     */
    public void salvarAtualizar(TipoArtefato tipoArtefato) throws Exception {
        new TipoArtefatoDao().salvarAtualizar(tipoArtefato);
    }

    /**
     * Retorna uma lista com todos os {@link TipoArtefato}
     * @return List
     * @throws Exception
     */
    public List<TipoArtefato> retornaTodosTiposArtefatos() throws Exception {
        return new TipoArtefatoDao().retornaTodosTipoArtefato();
    }

    /**
     * Salva ou atualiza uma lista de {@link TipoArtefato}
     * @param listaArtefato
     * @throws Exception
     */
    public void salvarAtualizar(List<TipoArtefato> listaArtefato) throws Exception {
        new TipoArtefatoDao().salvarAtualizar(listaArtefato);
    }

    /**
     * Importa uma lista de {@link TipoArtefato}
     * @param lista
     * @throws Exception
     */
    public void importaTipoArtefato(List<TipoArtefato> lista) throws Exception {
        new TipoArtefatoDao().importa(lista);
    }
}
