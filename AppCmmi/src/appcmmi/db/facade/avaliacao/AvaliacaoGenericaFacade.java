/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.AvaliacaoGenericaDao;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.AvaliacaoGenerica;
import appcmmi.modelo.tabela.ModeloTabelaAvaliacaoGenerica;
import java.util.List;

/**
 * Fachada para objetos do tipo {@link AvaliacaoGenerica}.
 * @author diego
 * @since 18/11/2009
 */
public class AvaliacaoGenericaFacade {

    /**
     * Caso a AvaliacaoGenerica não possua referência no banco de dados, salva a avaliação genérica.
     * Se houver referência, atualiza-o.
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAtualizar(AvaliacaoGenerica avaliacao) throws Exception {
        new AvaliacaoGenericaDao().salvarAtualizar(avaliacao);
    }

    /**
     * Com base no parâmetro <code>idMaturidade</code>, retorna a lista de avaliações de práticas genérica de uma avaliação.
     * Atenção: <b>idMaturidade deve ser a maturidade de nível mais alto da avaliação.</b>
     * @param idMaturidade
     * @return List
     * @throws Exception
     */
    public List<AvaliacaoGenerica> retornaAvaliacaoGenericaMaturidade(Integer idMaturidade, Integer idAvaliacao, Integer idAreaprocesso) throws Exception {
        return new AvaliacaoGenericaDao().retornaAvaliacaoGenericaMaturidade(idMaturidade, idAvaliacao, idAreaprocesso);
    }

    /**
     * Salva ou atualiza todos os itens de uma lista de {@link AvaliacaoGenerica}.
     * @param listaAvaliacao
     * @throws Exception
     */
    public void salvarListaAvaliacaoGenerica(List<AvaliacaoGenerica> listaAvaliacao) throws Exception {
        AvaliacaoGenericaDao dao = new AvaliacaoGenericaDao();
        dao.salvarAtualizar(listaAvaliacao);
    }

    /**
     * Retorna um {@link ModeloTabelaAvaliacaoGenerica} preenchida com todos as {@link AvaliacaoGenerica} de uma avaliação,
     * para utilização em tabelas na interface.
     * <b>Atenção</b>: o parâmetor <code>idMaturidade</code> deve indicar o nível mais alto da maturidade na avaliação.
     * @param idMaturidade
     * @param idAvaliacao
     * @return ModeloTabelaAvaliacaoGenerica
     * @throws Exception
     */
    public ModeloTabelaAvaliacaoGenerica retornaModeloAvaliacaoMaturidade(Integer idMaturidade, Integer idAvaliacao, Integer idAreaprocesso) throws Exception {
        Avaliacao avaliacao = new AvaliacaoFacade().carregaAvaliacao(idAvaliacao);
        ModeloTabelaAvaliacaoGenerica model = new ModeloTabelaAvaliacaoGenerica(
                avaliacao.getDefinicao(), avaliacao.getInstitucionalizacao());
        model.setList(this.retornaAvaliacaoGenericaMaturidade(idMaturidade, idAvaliacao, idAreaprocesso));
        for (AvaliacaoGenerica a : model.getList()) {
            a.getArtefatoList().size();
        }
        return model;
    }

    /**
     * Retorna uma avaliação de prática genérica de acordo com a avaliação e a prática
     * @param idAvaliacao
     * @param idGenerica
     * @return AvaliacaoGenerica
     * @throws Exception
     */
    public AvaliacaoGenerica retornaAvaliacaoGenerica(Integer idAvaliacao, Integer idGenerica) throws Exception {
        return new AvaliacaoGenericaDao().retornaAvaliacaoGenerica(idAvaliacao, idGenerica);
    }
}
