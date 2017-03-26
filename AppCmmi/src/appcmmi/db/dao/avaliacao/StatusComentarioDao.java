/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.dao.avaliacao;

import appcmmi.db.dao.Dao;
import appcmmi.db.pojo.avaliacao.StatusComentario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 * Classe responsável pela conexão e manipulação da tabela {@link StatusComentario}
 * @author diego
 */
public class StatusComentarioDao extends Dao {

    public StatusComentarioDao() {
        super(StatusComentario.class);
    }

    /**
     * Retorna uma lista de todas {@link StatusComentario}
     * @return List
     * @throws Exception
     */
    public List<StatusComentario> retornaTodosStatusComentario() throws Exception {
        List<StatusComentario> lista = new ArrayList<StatusComentario>();
        String sql = "FROM " + StatusComentario.class.getName();
        Query q = session.createQuery(sql);
        lista = q.list();
        return lista;
    }

    /**
     * Salva uma lista de {@link StatusComentario}
     * @param listastatuscomentario
     * @throws Exception
     */
    public void salvarStatus(List<StatusComentario> listastatuscomentario) throws Exception {
        try {
            Transaction t = session.beginTransaction();
            for (StatusComentario sc : listastatuscomentario) {
                session.save(sc);
            }
            t.commit();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
