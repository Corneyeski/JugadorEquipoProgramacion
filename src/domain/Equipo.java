package domain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Equipo {

    private Long id;
    private String nombre;
    private String localidad;
    private Date creacion;
    private ArrayList<Jugador> jugadores;

    public Equipo(Long id, String nombre, String localidad, Date creacion) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        jugadores = new ArrayList<>();
    }

    public Equipo() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", creacion=" + creacion +
                ", jugadores=" + jugadores +
                '}';
    }
}
