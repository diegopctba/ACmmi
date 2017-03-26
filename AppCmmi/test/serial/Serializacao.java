/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serial;

import appcmmi.db.pojo.modelo.AreaProcesso;
import appcmmi.db.pojo.modelo.Maturidade;
import appcmmi.db.pojo.modelo.PraticaEspecifica;
import appcmmi.db.pojo.modelo.PraticaGenerica;
import appcmmi.funcoes.Funcoes;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class Serializacao {

    public Serializacao() {
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
    public void serializa() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/diego/cmmiteste.cmmi"));
            List<Maturidade> lista = (List<Maturidade>) ois.readObject();
            for (Maturidade m : lista) {
                System.out.println(m.getTitulo());
                for (AreaProcesso a : m.getAreaProcessoList()) {
                    System.out.println(a.getTitulo());
                    for (PraticaEspecifica e : a.getPraticaEspecificaList()) {
                        System.out.println(e.getTitulo());
                    }
                }
                for (PraticaGenerica g : m.getPraticaGenericaList()) {
                    System.out.println(g.getTitulo());
                }
                System.out.println("fim");
            }

        } catch (Exception e) {
        }
    }

    @Test
    public void criptografa(){
        try {
            System.out.println(Funcoes.criptografar("diego"));
        } catch (NoSuchAlgorithmException ex) {
            Funcoes.erro("Erro", ex.getMessage());
        } catch (Exception ex) {
            Funcoes.erro("Erro", ex.getMessage());
        }
    }
}
