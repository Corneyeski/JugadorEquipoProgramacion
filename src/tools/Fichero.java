package tools;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Alan on 05/10/2016.
 */
public class Fichero {
    private String nombre;

    public Fichero(String nombre) {
        this.nombre = nombre;
    }

    public void grabar(Object o) {
        try  {
            XMLEncoder coder = new XMLEncoder(new FileOutputStream(new File(nombre)));
            coder.writeObject(o);
            coder.close();
        } catch (FileNotFoundException ex) {
            System.out.print("Error no se ha podido grabar" + ex.getMessage());
        }
    }

    //Devuelve null si no existe el fichero todavia
    public Object leer() {
        try {
            XMLDecoder decodificador = new XMLDecoder(new FileInputStream(new File(nombre)));
            return decodificador.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
