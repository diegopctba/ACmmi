/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.avaliacao;

import appcmmi.db.dao.avaliacao.AvaliacaoDao;
import appcmmi.db.pojo.avaliacao.Avaliacao;
import appcmmi.db.pojo.avaliacao.GraficoAvaliacao;
import java.util.List;

/**
 * Classe de fachada para tratamento de Avaliação
 * @author diego
 */
public class AvaliacaoFacade {

    /**
     * Retorna uma avaliação de acordo com o id informado.
     * @param idAvaliacao
     * @return Avaliacao
     * @throws Exception
     */
    public Avaliacao carregaAvaliacao(Integer idAvaliacao) throws Exception {
        return new AvaliacaoDao().carrega(idAvaliacao);
    }

    /**
     * Salva uma nova avaliação.
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAvaliacao(Avaliacao avaliacao) throws Exception {
        new AvaliacaoDao().salvar(avaliacao);
    }

    /**
     * Salva ou atualiza uma avaliação.
     * @param avaliacao
     * @throws Exception
     */
    public void salvarAtualizarAvaliacao(Avaliacao avaliacao) throws Exception {
        new AvaliacaoDao().salvarAtualizar(avaliacao);
    }

    /**
     * Remove do banco de dados a avaliação informada.
     * @param avaliacao
     * @throws Exception
     */
    public void removeAvaliacao(Avaliacao avaliacao) throws Exception {
        new AvaliacaoDao().apaga(avaliacao);
    }

    /**
     * Retorna uma lista de {@link Avaliacao} de acordo com os parâmetros passados.
     * @param idEmpresa
     * @param idMaturidade
     * @param de
     * @param ate
     * @param definicao
     * @param institucionalizacao
     * @return List
     * @throws Exception
     */
    public List<Avaliacao> pesquisaAvaliacao(Integer idEmpresa, Integer idMaturidade, String de, String ate,
            Boolean definicao, Boolean institucionalizacao) throws Exception {
        return new AvaliacaoDao().pesquisaAvaliacao(idEmpresa, idMaturidade, de, ate, definicao, institucionalizacao);
    }

    /**
     * Importa uma {@link Avaliacao}
     * @param avaliacao
     * @throws Exception
     */
    public void importarAvaliacao(Avaliacao avaliacao) throws Exception {
        new AvaliacaoDao().importar(avaliacao);
    }

    /**
     * Retorna o {@code idAvaliacao} da {@link Avaliacao}
     * @param avaliacao
     * @return Integer
     * @throws Exception
     */
    public Integer retornaIdAvaliacaoLocal(Avaliacao avaliacao) throws Exception {
        return new AvaliacaoDao().idAvaliacaoLocal(avaliacao);
    }

    public List<GraficoAvaliacao> retornaGraficoAvaliacao(Integer idavaliacao) throws Exception {
        return new AvaliacaoDao().retornaGraficoAvaliacao(idavaliacao);
    }
}
