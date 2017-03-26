/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.facade.modelo;

import appcmmi.db.dao.avaliacao.AtivoDao;
import appcmmi.db.pojo.Ativo;

/**
 * Classe de fachada da {@link Ativo}
 * @author diego
 */
public class AtivoFacade {

    /**
     * Salva um novo {@link Ativo}
     * @param ativo
     * @throws Exception
     */
    public void salvarAtivo(Ativo ativo) throws Exception {
        new AtivoDao().salvar(ativo);
    }

    /**
     * Exclui um {@link Ativo}
     * @param ativo
     * @throws Exception
     */
    public void excluirAtivo(Ativo ativo) throws Exception {
        new AtivoDao().apagar(ativo);
    }

    /**
     * Confere se já existe um {@link Ativo} com o mesmo {@code nome}.
     * @param text
     * @return boolean
     * @throws Exception
     */
    public boolean confereAtivo(String text) throws Exception {
        return new AtivoDao().confere(text);
    }
}
