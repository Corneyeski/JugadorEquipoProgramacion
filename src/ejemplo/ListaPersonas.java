package ejemplo;

import java.util.ArrayList;

/**
 * Created by Alan on 13/10/2016.
 */
public class ListaPersonas {

    private ArrayList<Persona> lista;

    public ListaPersonas(){
        lista = new ArrayList<>();
    }
    public void altaPersona(Persona p){lista.add(p); }
    public void bajaPersona(Persona p){
        lista.remove(p);
    }

    public Persona obtenerNumero(Integer numero){

        for(Persona persona : lista){
            if(persona.getNumero() == numero){
                return persona;
            }
        }
        return null;
    }
    public boolean encontrar(Integer numero){

        for(Persona persona : lista){
            if(persona.getNumero() == numero){
                return true;
            }
        }

        return false;
    }

    public ArrayList<Persona> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Persona> lista) {
        this.lista = lista;
    }
}
