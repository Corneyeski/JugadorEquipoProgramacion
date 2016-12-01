package ejemplo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 13/10/2016.
 */
public class Persona {

    private String nombre;
    private String apellido;
    private Integer numero;
    private boolean vip;
    private ListaPresupuestos presupuestos;

    public Persona(String nombre, String apellido, Integer numero, boolean vip, ListaPresupuestos presupuestos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.vip = vip;
        presupuestos = new ListaPresupuestos();
    }

    public Persona() {
        presupuestos = new ListaPresupuestos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public ListaPresupuestos getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(ListaPresupuestos presupuestos) {
        this.presupuestos = presupuestos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numero=" + numero +
                ", vip=" + vip  +
                '}';
    }
}
