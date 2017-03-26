/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.facade;

import appcmmi.db.dao.EmpresaDao;
import appcmmi.db.pojo.Empresa;
import java.util.List;

/**
 * Classe de fachada da {@link Empresa}
 * @author diego
 */
public class EmpresaFacade {

    private EmpresaDao dao;

    /**
     * Retorna uma {@link Empresa} de acordo com {@code idEmpresa}
     * @param id
     * @return Empresa
     * @throws Exception
     */
    public Empresa carregarEmpresa(Integer id) throws Exception {
        dao = new EmpresaDao();
        return dao.carrega(id);
    }

    /**
     * Salva uma nova {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void salvarEmpresa(Empresa empresa) throws Exception {
        dao = new EmpresaDao();
        dao.salvar(empresa);
    }

    /**
     * Salva ou atualiza uma {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void salvarAtualizarEmpresa(Empresa empresa) throws Exception {
        dao = new EmpresaDao();
        dao.salvarAtualizar(empresa);
    }

    /**
     * Atualiza uma {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void atualizar(Empresa empresa) throws Exception {
        dao = new EmpresaDao();
        dao.atualizar(empresa);
    }

    /**
     * Remove uma {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void removerEmpresa(Empresa empresa) throws Exception {
        dao = new EmpresaDao();
        dao.remover(empresa);
    }

    /**
     * Retorna uma lista com todas as {@link Empresa}
     * @return List
     * @throws Exception
     */
    public List<Empresa> listarTodasEmpresas() throws Exception {
        dao = new EmpresaDao();
        return dao.listarTodas();
    }

    /**
     * Retorna o próximo {@code idEmpresa}
     * @return Integer
     * @throws Exception
     */
    public Integer buscarProximoId() throws Exception {
        dao = new EmpresaDao();
        return dao.buscarProximoId();
    }

    /**
     * Exclui uma {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void excluirEmpresa(Empresa empresa) throws Exception {
        dao = new EmpresaDao();
        dao.remover(empresa);
    }

    /**
     * Retorna uma lista de {@link Empresa} de acordo com os parâmetos.
     * @param id
     * @param razaoSocial
     * @param fantasia
     * @param cnpj
     * @param insEstadual
     * @param endereco
     * @param num
     * @param complemento
     * @param telefone
     * @param contato
     * @param email
     * @param patrocinador
     * @return List
     * @throws Exception
     */
    public List<Empresa> pesquisarEmpresa(String id, String razaoSocial, String fantasia, String cnpj, String insEstadual,
            String endereco, String num, String complemento, String telefone, String contato, String email, String patrocinador) throws Exception {

        dao = new EmpresaDao();
        return dao.pesquisar(id, razaoSocial, fantasia, cnpj, insEstadual, endereco, num, complemento, telefone, contato, email, patrocinador);
    }
}
