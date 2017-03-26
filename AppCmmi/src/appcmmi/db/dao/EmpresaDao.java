/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao;

import appcmmi.db.pojo.Empresa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 * Classe responsável pela conexão e manutenção da tabela {@link Empresa}
 * @author diego
 */
public class EmpresaDao extends Dao {

    public EmpresaDao() {
        super(Empresa.class);
    }

    /**
     * Salva ou atualiza {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void salvarAtualizar(Empresa empresa) throws Exception {
        super.salvarAtualizar(empresa);
    }

    /**
     * Salva uma nova {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void salvar(Empresa empresa) throws Exception {
        super.salvar(empresa);
    }

    /**
     * Atualiza {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void atualizar(Empresa empresa) throws Exception {
        super.atualizar(empresa);
    }

    /**
     * Remove {@link Empresa}
     * @param empresa
     * @throws Exception
     */
    public void remover(Empresa empresa) throws Exception {
        super.excluir(empresa);
    }

    /**
     * Retorna uma {@link Empresa} através do {@code idEmpresa}
     * @param id
     * @return Empresa
     * @throws Exception
     */
    public Empresa carrega(Integer id) throws Exception {
        return (Empresa) super.carregar(id);
    }

    /**
     * Retorna todas as {@link Empresa}
     * @return Empresa
     */
    public List<Empresa> listarTodas() {
       List<Empresa> lista = new ArrayList<Empresa>();
       Query q = session.createQuery("FROM " + Empresa.class.getName());
       lista = q.list();
       return lista;
    }

    /**
     * Retorna o {@code idEmpresa}
     * @return Integer
     * @throws Exception
     */
    public Integer buscarProximoId() throws Exception {

        StringBuffer sql = new StringBuffer("SELECT MAX(e.idempresa) FROM ");
        sql.append(Empresa.class.getName());
        sql.append(" e");
        Query q = session.createQuery(sql.toString());
        Integer id = (Integer) q.uniqueResult();
        if (id == null) {
            id = 0;
        }
        return ++id;
    }

    /**
     * Retorna lista de {@link Empresa} de acordo com os parâmetros passados.
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
    public List<Empresa> pesquisar(String id, String razaoSocial, String fantasia, String cnpj, String insEstadual, String endereco,
            String num, String complemento, String telefone, String contato, String email, String patrocinador) throws Exception {
        List<Empresa> lista = new ArrayList<Empresa>();

        StringBuffer sql = new StringBuffer(" FROM ");
        sql.append(Empresa.class.getName());
        StringBuffer where = new StringBuffer(" WHERE");
        if (id != null && !id.isEmpty()) {
            where.append(" idEmpresa = ");
            where.append(id);
            where.append(" OR ");
        }
        if (razaoSocial != null && !razaoSocial.isEmpty()) {
            where.append(" razaosocial like '%");
            where.append(razaoSocial.toUpperCase());
            where.append("%' OR ");
        }
        if (fantasia != null && !fantasia.isEmpty()) {
            where.append(" nomefantasia like '%");
            where.append(fantasia.toUpperCase());
            where.append("%' OR ");
        }
        if (cnpj != null && !cnpj.isEmpty() && !cnpj.equals("0")) {
            where.append(" cnpj = '");
            where.append(cnpj);
            where.append(" OR ");
        }
        if (insEstadual != null && !insEstadual.isEmpty() && !insEstadual.equals("0")) {
            where.append(" inscricaoestadual = ");
            where.append(insEstadual);
            where.append(" OR ");
        }
        if (endereco != null && !endereco.isEmpty()) {
            where.append(" endereco like '%");
            where.append(endereco.toUpperCase());
            where.append("%' OR ");
        }
        if (num != null && !num.isEmpty() && !num.equals("0")) {
            where.append(" numero = ");
            where.append(num);
            where.append(" OR ");
        }
        if (complemento != null && !complemento.isEmpty()) {
            where.append(" complemento like '%");
            where.append(complemento);
            where.append("%' OR ");
        }
        if (contato != null && !contato.isEmpty()) {
            where.append(" contato like '%");
            where.append(contato);
            where.append("%' OR ");
        }
        if (telefone != null && !telefone.isEmpty()) {
            where.append(" telefone = '");
            where.append(telefone);
            where.append("' OR ");
        }
        if (email != null && !email.isEmpty()) {
            where.append(" email = '");
            where.append(email);
            where.append("' OR ");
        }
        if (patrocinador!= null && !patrocinador.isEmpty()) {
            where.append(" patrocinador like '%");
            where.append(patrocinador);
            where.append("%' OR ");
        }
        if (where.length() > 7) sql.append(where.substring(0, where.length() - 4));
        Query q = session.createQuery(sql.toString());
        lista = q.list();
        return lista;
    }

}
