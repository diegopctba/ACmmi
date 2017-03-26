/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import appcmmi.funcoes.Propriedades;
import org.hibernate.Hibernate;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diego
 */
public class gerar {

    public gerar() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void gerarBanco() {
        boolean gerou = false;
        try {
            Configuration conf = new AnnotationConfiguration();
            //String url = Propriedades.JDBC + Propriedades.getPreferences().get(Propriedades.URL_BD, "");

            /* if (url.length() < 10 ) {
            url = new String("jdbc:derby:/home/diego/banconovo");
            }*/
            conf.setProperty("hibernate.connection.url", "jdbc:derby:/home/diego/bd/cmmi;");
            conf.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
            conf.configure();
            SchemaUpdate up = new SchemaUpdate(conf);
            up.execute(true, true);
//            SchemaExport ex = new SchemaExport(conf);
  //          ex.create(true, true);
            gerou = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(gerou);
    }
}
