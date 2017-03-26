/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.modelo;

import appcmmi.db.dao.modelo.GenericaDao;
import appcmmi.db.pojo.modelo.PraticaGenerica;
import appcmmi.modelo.tabela.ModeloTabelaGenerica;
import java.util.List;

/**
 * Classe de fachada da {@link PraticaGenerica}
 * @author diego
 */
public class GenericaFacade {

    private GenericaDao dao;

    /**
     * Retorna uma lista com todas as {@link PraticaGenerica}
     * @return List
     * @throws Exception
     */
    public List<PraticaGenerica> retornaTodasGenericas() throws Exception {
        dao = new GenericaDao();
        return dao.retornaTodasEspecificas();
    }

    /**
     * Retorna uma lista de práticas genéricas de uma maturidade.
     * Parâmetro passado deve ser o numMaturidade.
     * @param idMaturidade
     * @return List
     * @throws Exception
     */
    public List<PraticaGenerica> retornaGenericasMaturidade(Integer idMaturidade) throws Exception {
        dao = new GenericaDao();
        return dao.retornaGenericaMaturidade(idMaturidade);
    }

    /**
     * Retorna um modelo de tabela ({@link ModeloTabelaGenerica}) com todas as {@link PraticaGenerica}
     * @return ModeloTabelaGenerica
     * @throws Exception
     */
    public ModeloTabelaGenerica retornaTabelaGenericas() throws Exception {
        ModeloTabelaGenerica modelo = new ModeloTabelaGenerica(retornaTodasGenericas());
        return modelo;
    }

    /**
     * Retorna um modelo de tabela ({@link ModeloTabelaGenerica}) com as {@link PraticaGenerica} de acordo com {@code idMaturidade}
     * @param idMaturidade
     * @return ModeloTabelaGenerica
     * @throws Exception
     */
    public ModeloTabelaGenerica retornaTabelaGenericaMaturidade(Integer idMaturidade) throws Exception {
        ModeloTabelaGenerica modelo = new ModeloTabelaGenerica(retornaGenericasMaturidade(idMaturidade));
        return modelo;
    }

    /**
     * Salva uma nova {@link PraticaGenerica}
     * @param generica
     * @throws Exception
     */
    public void salvarGenerica(PraticaGenerica generica) throws Exception {
        dao = new GenericaDao();
        dao.salvar(generica);
    }

    /**
     * Atualiza uma {@link PraticaGenerica}
     * @param generica
     * @throws Exception
     */
    public void atualizarGenerica(PraticaGenerica generica) throws Exception {
        dao = new GenericaDao();
        dao.atualizar(generica);
    }

    /**
     * Retorna uma {@link PraticaGenerica} de acordo com {@code idPraticaGenerica}
     * @param id
     * @return PraticaGenerica
     * @throws Exception
     */
    public PraticaGenerica carregarGenericaId(Integer id) throws Exception {
        dao = new GenericaDao();
        return dao.retornaPraticaId(id);
    }

    /**
     * Exclui uma {@link PraticaGenerica}
     * @param generica
     * @throws Exception
     */
    public void excluirGenerica(PraticaGenerica generica) throws Exception {
        dao = new GenericaDao();
        dao.excluir(generica);
    }

    /**
     * Retorna uma lista de {@link PraticaGenerica} de acordo com {@code idMaturidade}
     * @param idMaturidade
     * @return List
     * @throws Exception
     */
    public List<PraticaGenerica> retornaGenericaAvaliacao(Integer idMaturidade) throws Exception {
        dao = new GenericaDao();
        return dao.retornaGenericaAvaliacao(idMaturidade);
    }

    /**
     * Salva uma lista de {@link PraticaGenerica}
     * @param praticaGenericaList
     * @throws Exception
     */
    public void salvarGenerica(List<PraticaGenerica> praticaGenericaList) throws Exception {
        dao = new GenericaDao();
        dao.salvarLista(praticaGenericaList);
    }
}
