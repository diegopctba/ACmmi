/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appcmmi.funcoes;

import java.util.prefs.Preferences;

/**
 * Classe responsável pelo acesso ao Java Preferences.
 * @author diego
 */
public class Propriedades {

    public static final String JDBC = "jdbc:derby:";
    public static final String URL_BD = "url_bd";
    public static final String MODELO = "arquivoModelo";
    public static final String AVALIACAO = "avaliacao";

    /**
     * Retorna {@link Preferences} da máquina virtual do java
     * @return Preferences
     */
    public static Preferences getPreferences() {
        return Preferences.userRoot().node("appcmmi/preferencias");
    }

}
