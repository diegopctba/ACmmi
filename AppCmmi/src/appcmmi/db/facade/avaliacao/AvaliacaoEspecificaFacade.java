/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.AvaliacaoEspecificaDao;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.AvaliacaoEspecifica;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoEspecifica;
import java.util.List;

/**
 * Fachada da classe {@link AvaliacaoEspecifica}
 * @author diego
 */
public class AvaliacaoEspecificaFacade {

    /**
     * Salva ou atualiza um {@link AvaliacaoEspecifica}
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAtualizar(AvaliacaoEspecifica avaliacao) throws Exception {
        new AvaliacaoEspecificaDao().salvarAtualizar(avaliacao);
    }

    /**
     * Retorna uma lista de {@link AvaliacaoEspecifica} de acordo com {@code idAvaliacao} e {@code idAreaprocesso}
     * @param idAvaliacao
     * @param idAreaProcesso
     * @return List
     * @throws Exception
     */
    public List<AvaliacaoEspecifica> retornaEspecificaAvaliacaoAreaProcesso(Integer idAvaliacao, Integer idAreaProcesso) throws Exception {
        return new AvaliacaoEspecificaDao().retornaEspecificaAvaliacaoAreaProcesso(idAvaliacao, idAreaProcesso);
    }

    /**
     * Retorna o modelo de tabela ({@link ModeloTabelaAvaliacaoEspecifica}) de acordo com {@code idAvaliacao} e {@code idAreaprocesso}
     * @param idAvaliacao
     * @param idAreaProcesso
     * @return ModeloTabelaAvaliacaoEspecifica
     * @throws Exception
     */
    public ModeloTabelaAvaliacaoEspecifica retornaTabelaAvaliacaoAreaProcesso(Integer idAvaliacao, Integer idAreaProcesso) throws Exception {
        Avaliacao avaliacao = new AvaliacaoFacade().carregaAvaliacao(idAvaliacao);
        ModeloTabelaAvaliacaoEspecifica model = new ModeloTabelaAvaliacaoEspecifica(
                avaliacao.getDefinicao(), avaliacao.getInstitucionalizacao());
        model.setList(retornaEspecificaAvaliacaoAreaProcesso(idAvaliacao, idAreaProcesso));
        if (model.getList() != null && !model.getList().isEmpty()) {
            for (AvaliacaoEspecifica ae : model.getList()) {
                ae.getArtefatoList().size();
            }
        }
        return model;
    }

    /**
     * Salva uma lista {@link AvaliacaoEspecifica}
     * @param listaAvaliacaoEspecifica
     * @throws Exception
     */
    public void salvarListaAvaliacaoEspecifica(List<AvaliacaoEspecifica> listaAvaliacaoEspecifica) throws Exception {
        new AvaliacaoEspecificaDao().salvarAtualizar(listaAvaliacaoEspecifica);
    }

    /**
     * Retorna uma {@link AvaliacaoEspecifica} de acordo com {@code idAvaliacao} e {@code idEspecifica}
     * @param idAvaliacao
     * @param idEspecifica
     * @return AvaliacaoEspecifica
     * @throws Exception
     */
    public AvaliacaoEspecifica retornaAvaliacaoEspecifica(Integer idAvaliacao, Integer idEspecifica) throws Exception {
        return new AvaliacaoEspecificaDao().retornaAvaliacaoEspecifica(idAvaliacao, idEspecifica);
    }
}
