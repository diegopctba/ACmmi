/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.db;

import appcmmi.PrincipalFrame;
import appcmmi.form.login.TelaPropriedades;
import appcmmi.funcoes.Propriedades;
import java.util.prefs.Preferences;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author diego
 */
public class HibernateUtil {

    private static SessionFactory factory;
    private static ThreadLocal<Session> sessions = new ThreadLocal<Session>();

    /**
     * Inicialização do Hibernate
     * @author diego
     */
    static {
        inicializa();
    }
    public static Session openSession() {
        if (sessions.get() != null) {
            sessions.get().close();
            sessions.set(null);
        }
        sessions.set(factory.openSession());

        return sessions.get();
    }

    public static void closeCurrentSession() {
        sessions.get().close();
        sessions.set(null);
        factory = null;
    }

    public static Session currentSession() {
        return sessions.get();
    }

    public static Statistics getStatistics() {
        return factory.getStatistics();
    }

    private static AnnotationConfiguration getConfiguration() {
        AnnotationConfiguration conf = new AnnotationConfiguration();
        StringBuffer url = new StringBuffer(Propriedades.JDBC);
        Preferences pref = Propriedades.getPreferences();
        if ((pref == null) ||
                (pref.get(Propriedades.URL_BD, "") == null) ||
                (pref.get(Propriedades.URL_BD, "").isEmpty())) {
            new TelaPropriedades(PrincipalFrame.getFrames()[0], true);
        }
        url.append(pref.get(Propriedades.URL_BD, ""));
        System.out.println("Configuration "+url.toString());
        conf.setProperty("hibernate.connection.url", url.toString());
        conf.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
        return conf;
    }

    public static boolean criarBanco() {
        boolean gerar = false;
        try {
            AnnotationConfiguration conf = getConfiguration();
            conf.setProperty("hibernate.connection.url", (conf.getProperty("hibernate.connection.url") + "create=true;"));
            System.out.println("Criando banco " +conf.getProperty("hibernate.connection.url"));
            conf.configure();
            SchemaExport ex = new SchemaExport(conf);
            ex.create(true, true);
            //HibernateUtil.closeCurrentSession();
            //conf.configure();
            //factory = conf.buildSessionFactory();
            inicializa();
            gerar = true;
            System.out.println("Criado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gerar;
    }

    public static boolean hibernateAberto() {
        return sessions.get().isConnected();
    }

    /**
     * Inicializa o banco de dados
     */
    private static void inicializa() {
        Configuration configuration = HibernateUtil.getConfiguration();
        try {
            configuration.configure();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            factory = configuration.buildSessionFactory();
            openSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
