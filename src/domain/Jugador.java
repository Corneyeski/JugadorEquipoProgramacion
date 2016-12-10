package domain;
import java.util.Date;

/**
 * Created by Alan on 01/12/2016.
 */
public class Jugador {

    private String nombre;
    private Date nacimiento;
    private int canasto;
    private int asisto;
    private int reboto;
    private Posicion posicion;

    public Jugador() {}

    public Jugador(String nombre, Date nacimiento, int canasto, int asisto, int reboto, Posicion posicion) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.canasto = canasto;
        this.asisto = asisto;
        this.reboto = reboto;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCanasto() {
        return canasto;
    }

    public void setCanasto(int canasto) {
        this.canasto = canasto;
    }

    public int getAsisto() {
        return asisto;
    }

    public void setAsisto(int asisto) {
        this.asisto = asisto;
    }

    public int getReboto() {
        return reboto;
    }

    public void setReboto(int reboto) {
        this.reboto = reboto;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", canasto=" + canasto +
                ", asisto=" + asisto +
                ", reboto=" + reboto +
                ", posicion=" + posicion +
                '}';
    }
}
