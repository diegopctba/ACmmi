/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao;

import appcmmi.db.pojo.Avaliador;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

/**
 * Classe responsável pela conexão e manutenção da tabela {@link Avaliador}
 * @author diego
 */
public class AvaliadorDao extends Dao {

    public AvaliadorDao() {
        super(Avaliador.class);
    }

    /**
     * Salva um novo {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void salvar(Avaliador avaliador) throws Exception {
        super.salvar(avaliador);
    }

    /**
     * Salva ou atualiza um {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void salvarAtualizar(Avaliador avaliador) throws Exception {
        super.salvarAtualizar(avaliador);
    }

    /**
     * Exclui um {@link Avaliador}
     * @param avaliador
     * @throws Exception
     */
    public void excluir(Avaliador avaliador) throws Exception {
        super.excluir(avaliador);
    }
    
    /**
     * Retorna um {@link Avaliador} através do {@code idAvaliador}
     * @param id
     * @return Avaliador
     * @throws Exception
     */
    @Override
    public Avaliador carregar(Integer id) throws Exception {
        return (Avaliador) super.carregar(id);
    }

    /**
     * Retorna uma lista de {@link Avaliador}
     * @return List
     * @throws Exception
     */
    public List<Avaliador> listar() throws Exception {
        List<Avaliador> lista = new ArrayList<Avaliador>();

        Query q = session.createQuery("FROM "+Avaliador.class.getName());
        lista = q.list();

        return lista;
    }

    /**
     * Retorna uma lista de {@link Avaliador} de acordo com os parâmetros.
     * @param id
     * @param nome
     * @param cpf
     * @param rg
     * @return List
     * @throws Exception
     */
    public List<Avaliador> pesquisar(String id, String nome, String cpf, String rg) throws Exception {
        List<Avaliador> lista = new ArrayList<Avaliador>();
        StringBuffer sql = new StringBuffer("FROM ");
        sql.append(Avaliador.class.getName());
        StringBuffer where = new StringBuffer(" WHERE ");
        if (id != null && !id.isEmpty() && !id.equals("0")) {
            where.append(" idAvaliador = ");
            where.append(id);
            where.append(" AND ");
        }
        if (nome != null && !nome.isEmpty()) {
            where.append(" nome LIKE '%");
            where.append(nome);
            where.append("%' AND ");
        }
        if (cpf != null && !cpf.isEmpty() && !cpf.equals("0")) {
            where.append(" cpf = ");
            where.append(cpf);
            where.append(" AND ");
        }
        if (rg != null && !rg.isEmpty() && !rg.equals("0")) {
            where.append(" rg = ");
            where.append(rg);
            where.append(" AND ");
        }
        if (where.length() > 7) {
            sql.append(where.substring(0, where.length()-5));
        }
        Query q = session.createQuery(sql.toString());
        lista = q.list();
        return lista;
    }
}
