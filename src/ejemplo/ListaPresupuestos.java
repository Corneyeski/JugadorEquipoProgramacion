package ejemplo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 13/10/2016.
 */
public class ListaPresupuestos {

    private ArrayList<Presupuesto> lista;

    public ListaPresupuestos() {
        lista = new ArrayList<>();
    }

    public void altaPresupuesto(Presupuesto p) {
        lista.add(p);
    }

    public ArrayList<Presupuesto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.lista = lista;
    }
}
