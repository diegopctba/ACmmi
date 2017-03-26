/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db.dao;

import appcmmi.db.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe genérica para métodos do banco de dados.
 * Ao instanciar esta classe, deve-se enviar como parâmetro
 * a classe mapeada do banco de dados (persistência).
 * @author diego
 * @since 23/09/2009
 */
public class Dao<T> {

    protected Session session;
    private Class<T> persistentClass;
    private Transaction transaction;

    /**
     * Instancia com passagem da Session e da persistência.
     * @param session
     * @param persistent
     */
    public Dao(Session session, Class persistent) {
        this.persistentClass = persistent;
        this.session = session;
    }

    /**
     * Instancia com passagem da persistência, criando uma nova Session.
     * @param persistent
     */
    public Dao(Class persistent) {
        this.persistentClass = persistent;
        this.session = HibernateUtil.openSession();
    }

    //public abstract T load(Integer id);
    /**
     * Retorna um objeto do banco de dados à partir do id
     * @author diegopinheiro
     * @param id
     * @return T
     * @throws Exception
     */
    protected T carregar(Integer id) throws Exception {
        return (T) session.load(persistentClass, id);
    }

    /**
     * Salva um objeto no banco de dados
     * @param t
     * @throws Exception
     */
    protected void salvar(T t) throws Exception {
        transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
    }

    /**
     * Atualiza um objeto no banco de dados
     * @param t
     * @throws Exception
     */
    protected void atualizar(T t) throws Exception {
        transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
    }

    /**
     * Apaga o objeto no banco de dados
     * @param t
     * @throws Exception
     */
    protected void excluir(T t) throws Exception {
        transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
    }

    /**
     * Salva ou atualiza um objeto
     * @param t
     * @throws Exception
     */
    protected void salvarAtualizar(T t) throws Exception {
        transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
    }

    /**
     * Salva uma lista de objetos
     * @param lista
     * @throws Exception
     */
    protected void salvar(List<T> lista) throws Exception {
        try {
            transaction = session.beginTransaction();

            for (T t : lista) {
                session.save(t);
            }

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw new Exception(e);
        }

    }
}
