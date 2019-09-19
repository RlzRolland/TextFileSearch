/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFileSearch;

import java.util.Properties;
import java.io.IOException;

/**
 *
 * @author RlzRolland
 */
public class Propiedades extends Properties{
    public Propiedades(String idioma) {
        if (idioma.equals("Espanol")) {
            getProperties("Espanol.properties");
        }
        else if (idioma.equals("English")) {
            getProperties("English.properties");
        }
    }
    
    private void getProperties(String idioma) {
        try {
            this.load(getClass().getResourceAsStream(idioma));
        } catch (IOException ex) {
        }
    }
}
