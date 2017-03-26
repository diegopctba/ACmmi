/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.modelo;

import appcmmi.db.dao.modelo.MaturidadeDao;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.modelo.comboBox.ModeloComboMaturidade;
import appcmmi.modelo.tabela.ModeloTabelaMaturidade;
import java.util.List;

/**
 * Classe de fachada da Maturidade
 * @author diego
 */
public class MaturidadeFacade {

    private MaturidadeDao dao;

    public MaturidadeFacade() {
    }

    /**
     * Retorna uma lista com todas as maturidades cadastradas
     * @return
     * @throws Exception
     */
    public List<Maturidade> retornaTodasMaturidade() throws Exception {
        dao = new MaturidadeDao();
        return dao.listaTodasMaturidade();
    }

    /**
     * Retorna um ModeloTabelaMaturidade com todas as maturidades cadastradas
     * @return ModeloTabelaMaturidade
     * @throws Exception
     */
    public ModeloTabelaMaturidade retornaModeloMaturidade() throws Exception {
        return new ModeloTabelaMaturidade(retornaTodasMaturidade());
    }

    /**
     * Retorna um ModelotabelaMaturidade com as maturidades pre determinadas
     * @param lista
     * @return ModeloTabelaMaturidade
     * @throws Exception
     */
    public ModeloTabelaMaturidade retornaModeloMaturidade(List<Maturidade> lista) throws Exception {
        return new ModeloTabelaMaturidade(lista);
    }

    /**
     * Retorna Maturidade com determinado id
     * @param id
     * @return Maturidade
     * @throws Exception
     */
    public Maturidade retornaMaturidade(Integer id) throws Exception {
        dao = new MaturidadeDao();
        return dao.carregaMaturidade(id);
    }

    /**
     * Salva uma nova Maturidade
     * @param maturidade
     * @throws Exception
     */
    public void salvarMaturidade(Maturidade maturidade) throws Exception {
        dao = new MaturidadeDao();
        dao.salvarMaturidade(maturidade);
    }

    /**
     * Atualiza uma Maturidade
     * @param maturidade
     * @throws Exception
     */
    public void atualizarMaturidade(Maturidade maturidade) throws Exception {
        dao = new MaturidadeDao();
        dao.atualizarMaturidade(maturidade);
    }

    /**
     * Remove a maturidade
     * @param maturidade
     * @throws Exception
     */
    public void deletarMaturidade(Maturidade maturidade) throws Exception {
        dao = new MaturidadeDao();
        dao.deletarMaturidade(maturidade);
    }

    /**
     * Retorna o ModeloComboMaturidade instanciada com todas as maturidades.
     * @return ModeloComboMaturidade
     * @throws Exception
     */
    public ModeloComboMaturidade retornaModeloComboMaturidade() throws Exception {
        ModeloComboMaturidade combo = new ModeloComboMaturidade(retornaTodasMaturidade());
        return combo;
    }

    /**
     * Retorna uma lista de Maturidades subsequentes ao nível indicado.
     * Exemplo: ao solicitar o nível 4, retorna os níveis 4, 3, 2...
     * <b>Atenção: deve ser enviado como parâmetro o número de maturidade, e não o id</b>
     * @param maturidade
     * @return List<Maturidade>
     * @throws Exception
     */
    public List<Maturidade> listaMaturidadesAvaliacao(Integer numMaturidade) throws Exception {
        dao = new MaturidadeDao();
        return dao.listaMaturidadesAvaliacao(numMaturidade);
    }

    /**
     * Retorna uma lista de todas as {@link Maturidade} com suas respectivas {@link AreaProcesso}, {@link PraticaEspecifica} e {@link PraticaGenerica}.
     * @return List
     * @throws Exception
     */
    public List<Maturidade> exportaMaturidades() throws Exception {
        List<Maturidade> lista = retornaTodasMaturidade();
        for (Maturidade m : lista) {
            m.getPraticaGenericaList().size();
            for (AreaProcesso a : m.getAreaProcessoList()) {
                a.getPraticaEspecificaList().size();
            }
        }

        return lista;
    }

    /**
     * Salva uma lista de {@link Maturidade}
     * @param lista
     * @throws Exception
     */
    public void salvarMaturidade(List<Maturidade> lista) throws Exception {
        new MaturidadeDao().salvarMaturidade(lista);
    }
}
