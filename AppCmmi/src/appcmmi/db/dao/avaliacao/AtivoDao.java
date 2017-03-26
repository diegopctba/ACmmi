/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.Dao;
import appcmmi.db.pojo.Ativo;
import org.hibernate.Query;

/**
 * Classe responsável pela conexão e manipulação da tabela {@link Ativo}
 * @author diego
 */
public class AtivoDao extends Dao {

    public AtivoDao() {
        super(Ativo.class);
    }

    /**
     * Salva um novo {@link Ativo}
     * @param ativo
     * @throws Exception
     */
    public void salvar(Ativo ativo) throws Exception {
        super.salvar(ativo);
    }

    /**
     * Remove um  {@link Ativo}
     * @param ativo
     * @throws Exception
     */
    public void apagar(Ativo ativo) throws Exception {
        super.excluir(ativo);
    }

    /**
     * Verifica se já existe um {@link Ativo} com o mesmo nome.
     * @param nome
     * @return boolean
     * @throws Exception
     */
    public boolean confere(String nome) throws Exception {
        StringBuffer sql = new StringBuffer("SELECT COUNT(idativo) FROM ");
        sql.append(Ativo.class.getName());
        sql.append(" WHERE nome LIKE '%");
        sql.append(nome);
        sql.append("%'");
        Query q = session.createQuery(sql.toString());
        int qtde = q.list().size();
        
        return qtde > 0;
    }
}
