/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade.modelo;

import appcmmi.db.dao.modelo.AreaProcessoDao;
import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.modelo.comboBox.ModeloComboAreaProcesso;
import appcmmi.modelo.lista.ListaAreaProcesso;
import appcmmi.modelo.tabela.ModeloTabelaAreaProcesso;
import java.util.List;

/**
 * Classe de fachada da {@link AreaProcesso}
 * @author diego
 */
public class AreaProcessoFacade {

    private AreaProcessoDao dao;

    /**
     * Retorna uma lista com todas as {@link AreaProcesso}
     * @return List
     * @throws Exception
     */
    public List<AreaProcesso> retornaTodasAreaProcesso() throws Exception {
        dao = new AreaProcessoDao();
        return dao.getTodasAreaProcesso();
    }

    /**
     * Retorna uma lista de {@link AreaProcesso} de acordo com {@code idMaturidade}
     * @param idMaturidade
     * @return List
     * @throws Exception
     */
    public List<AreaProcesso> retornaAreaProcessoPorMaturidade(Integer idMaturidade) throws Exception {
        dao = new AreaProcessoDao();
        return dao.getAreaProcessoPorMaturidade(idMaturidade);
    }

    /**
     * Retorna um modelo de tabela ({@link ModeloTabelaAreaProcesso}) com todas as {@link AreaProcesso}
     * @return ModeloTabelaAreaProcesso
     * @throws Exception
     */
    public ModeloTabelaAreaProcesso retornaTabelaTodasAreaProcesso() throws Exception {
        return new ModeloTabelaAreaProcesso(retornaTodasAreaProcesso());
    }

    /**
     * Retorna um modelo de combobox ({@link ModeloComboAreaProcesso}) com todas as {@link AreaProcesso}
     * @return ModeloComboAreaProcesso
     * @throws Exception
     */
    public ModeloComboAreaProcesso retornaComboTodasAreaProcesso() throws Exception {
        return new ModeloComboAreaProcesso(retornaTodasAreaProcesso());
    }

    /**
     * Retorna um modelo de combobox ({@link ModeloComboAreaProcesso}) com as {@link AreaProcesso} de acordo com {@code idMaturidade}
     * @param idMaturidade
     * @return ModeloComboAreaProcesso
     * @throws Exception
     */
    public ModeloComboAreaProcesso retornaComboAreaProcessoPorMaturidade(Integer idMaturidade) throws Exception {
        return new ModeloComboAreaProcesso(retornaAreaProcessoPorMaturidade(idMaturidade));
    }

    /**
     * Retorna um modelo de tabela ({@link ModeloTabelaAreaProcesso}) com as {@link AreaProcesso} de acordo com {@code idMaturidade}
     * @param lista
     * @return ModeloTabelaAreaProcesso
     * @throws Exception
     */
    public ModeloTabelaAreaProcesso retornaModeloAreaProcesso(List<AreaProcesso> lista) throws Exception {
        return new ModeloTabelaAreaProcesso(lista);
    }

    /**
     * Salva uma nova {@link AreaProcesso}
     * @param areaProcesso
     * @throws Exception
     */
    public void salvarAreaProcesso(AreaProcesso areaProcesso) throws Exception {
        dao = new AreaProcessoDao();
        dao.salvarAreaProcesso(areaProcesso);
    }

    /**
     * Atualiza uma {@link AreaProcesso}
     * @param areaProcesso
     * @throws Exception
     */
    public void atualizarAreaProcesso(AreaProcesso areaProcesso) throws Exception {
        dao = new AreaProcessoDao();
        dao.atualizarAreaProcesso(areaProcesso);
    }

    /**
     * Retorna uma {@link ListaAreaProcesso} com todas as {@link AreaProcesso}
     * @return ListaAreaProcesso
     * @throws Exception
     */
    public ListaAreaProcesso retornaModeloListaTodasAreaProcessos() throws Exception {
        ListaAreaProcesso area = new ListaAreaProcesso();
        area.setList(retornaTodasAreaProcesso());
        return area;
    }

    /**
     * Exclui uma {@link AreaProcesso}
     * @param areaProcesso
     * @throws Exception
     */
    public void excluirAreaProcesso(AreaProcesso areaProcesso) throws Exception {
        dao = new AreaProcessoDao();
        dao.excluirAreaProcesso(areaProcesso);
    }

    /**
     * Salva uma lista de {@link AreaProcesso} 
     * @param areaProcessoList
     * @throws Exception
     */
    public void salvarAreaProcesso(List<AreaProcesso> areaProcessoList) throws Exception {
        dao = new AreaProcessoDao();
        dao.salvarAreaProcesso(areaProcessoList);
    }
}
