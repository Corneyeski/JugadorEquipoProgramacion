import domain.Equipo;
import domain.Jugador;
import domain.Posicion;
import tools.Fichero;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import static tools.InputData.pedirCadena;
import static tools.InputData.pedirEntero;

/**
 * Created by Alan on 01/12/2016.
 */
public class main {

    private static Fichero fichero;
    private static HashMap<String,Equipo> equipos;

    public static void main(String []args){

        fichero = new Fichero("personas.xml");
        equipos = (HashMap<String, Equipo>) fichero.leer();
        if (equipos == null) {
            equipos = new HashMap<>();
        }
        int opcion = 0;
        do {
            do{
               opcion = menu();
            }while(opcion < 1 || opcion > 5);
            switch (opcion) {
                case 1:
                    registrarE();
                    break;
                case 2:
                    registrarJ();
                    break;
                case 3:
                    consultaJ();
                    break;
                case 4:
                    consultaE();
                    break;
            }
        }while(opcion != 5);
        System.out.println("fin del programa");
        fichero.grabar(equipos);
    }
    public static int menu(){

        System.out.println("1. Alta equipo");
        System.out.println("2. Nuevo jugador");
        System.out.println("3. menu consultas de jugadores");
        System.out.println("4. menu consultas de equipos");
        System.out.println("5. Salir");


        return pedirEntero("");
    }
    public static int menu2(){

        System.out.println("1. Buscar jugadores por nombre");
        System.out.println("2. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas especificado como parámetro");
        System.out.println("3. asistencias por rango");
        System.out.println("4. buscar por posicion");
        System.out.println("5. buscar por fecha de nacimiento anterior a la introducida");
        System.out.println("6. agrupados por posicion y con media");
        System.out.println("7. agrupados por posicion y con media, maximo y minimo");
        System.out.println("8. Salir");


        return pedirEntero("");
    }
    public static int menu3(){

        System.out.println("1. Buscar equipo por localidad");
        System.out.println("2. Buscar jugadores de un equipo");
        System.out.println("3. asistencias por rango");
        System.out.println("4. buscar por posicion");
        System.out.println("5. salir");


        return pedirEntero("");
    }
    public static Posicion posicion(){

        String p = pedirCadena("posicion del jugador?");
        do {
            if (p.equalsIgnoreCase("ala")) {
                return Posicion.ala;
            }
            if (p.equalsIgnoreCase("pibot")) {
                return Posicion.pibot;
            }
            if(p.equalsIgnoreCase("base")){
                return Posicion.base;
            }
        }while(0 == 0 /*while troll*/);
    }
    public static ArrayList<Jugador> listaJ(ArrayList<Jugador> lista){

        ArrayList<Equipo> listae = new ArrayList<>(equipos.values());

        for(Equipo e : listae){
            for(Jugador j : e.getJugadores()){
                lista.add(j);
            }
        }
        return lista;
    }
    public static int parametros(){
        int uno;
        do{
            uno = pedirEntero("Introduce el parametro mayor que zero");
        }while (uno < 0);

        return uno;
    }
    public static void registrarE() {

        Equipo equipo = new Equipo();

        equipo.setNombre(pedirCadena("Nombre del equipo?"));
        equipo.setLocalidad(pedirCadena("Donde esta ubicado?"));

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date testDate = null;
        String date = "02/30/2012";
        try{
            date = pedirCadena("introduce la fecha con este formato: MM/dd/yyyy");
            testDate = df.parse(date);
        } catch (ParseException e){ System.out.println("invalid format");}

        if (!df.format(testDate).equals(date)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
            equipo.setCreacion(testDate);
        }

        equipo.setCreacion(testDate);
        equipos.put(equipo.getNombre(),equipo);
    }
    public static void registrarJ(){

        Jugador jugador = new Jugador();
        String equipo = pedirCadena("Nombre del equipo al que pertenece?");
        if(!equipos.containsKey(equipo)){
            System.out.println("Equipo no encontrado");
        }else{
            jugador.setNombre(pedirCadena("Nombre del jugador?"));

            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date testDate = null;
            String date = "02/30/2012";
            try{
                date = pedirCadena("introduce la fecha con este formato: MM/dd/yyyy");
                testDate = df.parse(date);
            } catch (ParseException e){ System.out.println("invalid format");}

            if (!df.format(testDate).equals(date)){
                System.out.println("invalid date!!");
            } else {
                System.out.println("valid date");
                jugador.setNacimiento(testDate);
            }
            jugador.setCanasto(pedirEntero("canastas del jugador?"));
            jugador.setAsisto(pedirEntero("asistencias del jugador?"));
            jugador.setReboto(pedirEntero("rebotes del jugador?"));
            jugador.setPosicion(posicion());
            equipos.get(equipo).getJugadores().add(jugador);
        }
    }
    public static void media(ArrayList<Integer> jugadores, String posicion, String que){
        int media = 0;
        for(int i : jugadores){
            media += i;
        }
        System.out.println("La media de " + que + " de " + posicion + " es " + media / jugadores.size());
    }
    public static void max(ArrayList<Integer> jugadores, String posicion, String que){
        int max = 0;
        for(int i : jugadores){
            if(i > max){
                max = i;
            }
        }
        System.out.println("La media de " + que + " de " + posicion + " es " + max);
    }
    public static void min(ArrayList<Integer> jugadores, String posicion, String que){

        int max = 0;
        for(int i : jugadores){
            if(i > max){
                max = i;
            }
        }
        int min = max;
        for(int i : jugadores){
            if(i < min){
                min = i;
            }
        }
        System.out.println("La media de " + que + " de " + posicion + " es " + min);
    }
    public static void consultaJ(){

        int opcion2 = 0;
        ArrayList<Jugador> lista = new ArrayList<>();
        lista = listaJ(lista);
        do {
            do{
                opcion2 = menu2();
            }while(opcion2 < 1 || opcion2 > 8);
            switch (opcion2) {
                case 1:

                    break;
                case 2:
                    int uno = parametros();
                    for(Jugador j : lista){
                        if(j.getCanasto() >= uno){
                            System.out.println(j);
                        }
                    }
                    break;
                case 3:
                    int dos = parametros();
                    int tres = parametros();
                    for(Jugador j : lista){
                        if(j.getAsisto() > dos && j.getAsisto() < tres){
                            System.out.println(j);
                        }
                    }
                    break;
                case 4:
                    String posicion = pedirCadena("posicion que quieres buscar?");
                    for (Jugador j : lista){
                        if(posicion.equalsIgnoreCase(String.valueOf(j.getPosicion()))){
                            System.out.println(j);
                        }
                    }
                    break;
                case 5:
                    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    Date testDate = null;
                    String date = "02/30/2012";
                    try{
                        date = pedirCadena("introduce la fecha con este formato: MM/dd/yyyy");
                        testDate = df.parse(date);
                    } catch (ParseException e){ System.out.println("invalid format");}

                    if (!df.format(testDate).equals(date)){
                        System.out.println("invalid date!!");
                    } else {
                        System.out.println("valid date");
                    }
                    for(Jugador j : lista){
                        if(j.getNacimiento().before(testDate)){
                            System.out.println(j);
                        }
                    }
                    break;
                case 6:
                    ArrayList<Integer> alac = new ArrayList<>();
                    ArrayList<Integer> alar = new ArrayList<>();
                    ArrayList<Integer> alaa = new ArrayList<>();

                    ArrayList<Integer> basec = new ArrayList<>();
                    ArrayList<Integer> baser = new ArrayList<>();
                    ArrayList<Integer> basea = new ArrayList<>();

                    ArrayList<Integer> pibotc = new ArrayList<>();
                    ArrayList<Integer> pibotr = new ArrayList<>();
                    ArrayList<Integer> pibota = new ArrayList<>();

                   for(Jugador j : lista){
                       if(Posicion.ala == j.getPosicion()){
                            alac.add(j.getCanasto());
                            alar.add(j.getReboto());
                            alaa.add(j.getAsisto());
                       }
                       if(Posicion.base == j.getPosicion()){
                            basec.add(j.getCanasto());
                            baser.add(j.getReboto());
                            basea.add(j.getAsisto());
                       }
                       if(Posicion.pibot == j.getPosicion()){
                           pibotc.add(j.getCanasto());
                           pibotr.add(j.getReboto());
                           pibota.add(j.getAsisto());
                       }
                   }
                    media(alac,"ala","canastas");
                    media(alaa,"ala","asistencias");
                    media(alar,"ala","rebotes");

                    media(basec,"base","canastas");
                    media(basea,"base","asistencias");
                    media(baser,"base","rebotes");

                    media(pibotc,"pibot","rebocanastastes");
                    media(basea,"pibot","asistencias");
                    media(baser,"pibot","rebotes");
                    break;
                case 7:
                    ArrayList<Integer> alac2 = new ArrayList<>();
                    ArrayList<Integer> alar2 = new ArrayList<>();
                    ArrayList<Integer> alaa2 = new ArrayList<>();

                    ArrayList<Integer> basec2 = new ArrayList<>();
                    ArrayList<Integer> baser2 = new ArrayList<>();
                    ArrayList<Integer> basea2 = new ArrayList<>();

                    ArrayList<Integer> pibotc2 = new ArrayList<>();
                    ArrayList<Integer> pibotr2 = new ArrayList<>();
                    ArrayList<Integer> pibota2 = new ArrayList<>();

                    for(Jugador j : lista){
                        if(Posicion.ala == j.getPosicion()){
                            alac2.add(j.getCanasto());
                            alar2.add(j.getReboto());
                            alaa2.add(j.getAsisto());
                        }
                        if(Posicion.base == j.getPosicion()){
                            basec2.add(j.getCanasto());
                            baser2.add(j.getReboto());
                            basea2.add(j.getAsisto());
                        }
                        if(Posicion.pibot == j.getPosicion()){
                            pibotc2.add(j.getCanasto());
                            pibotr2.add(j.getReboto());
                            pibota2.add(j.getAsisto());
                        }
                    }
                    media(alac2,"ala","canastas");
                    media(alaa2,"ala","asistencias");
                    media(alar2,"ala","rebotes");

                    max(alac2,"ala","canastas");
                    max(alaa2,"ala","asistencias");
                    max(alar2,"ala","rebotes");

                    min(alac2,"ala","canastas");
                    min(alaa2,"ala","asistencias");
                    min(alar2,"ala","rebotes");

                    media(basec2,"base","canastas");
                    media(basea2,"base","asistencias");
                    media(baser2,"base","rebotes");

                    max(basec2,"base","canastas");
                    max(basea2,"base","asistencias");
                    max(baser2,"base","rebotes");

                    min(basec2,"base","canastas");
                    min(basea2,"base","asistencias");
                    min(baser2,"base","rebotes");

                    media(pibotc2,"pibot","rebocanastastes");
                    media(pibota2,"pibot","asistencias");
                    media(pibotr2,"pibot","rebotes");

                    max(pibotc2,"pibot","rebocanastastes");
                    max(pibota2,"pibot","asistencias");
                    max(pibotr2,"pibot","rebotes");

                    min(pibotc2,"pibot","rebocanastastes");
                    min(pibota2,"pibot","asistencias");
                    min(pibotr2,"pibot","rebotes");
                    break;
            }
        }while(opcion2 != 8);
    }
    public static void consultaE(){

        int opcion2 = 0;

        do {
            do{
                opcion2 = menu3();
            }while(opcion2 < 1 || opcion2 > 5);
            switch (opcion2) {
                case 1:
                    String localidad = pedirCadena("en que localidad buscas?");
                    for(Equipo e : equipos.values()){
                        if(e.getLocalidad().equalsIgnoreCase(localidad)){
                            System.out.println(e);
                        }
                    }
                    break;
                case 2:
                    String equipo = pedirCadena("Que equipo buscas?");
                    if(equipos.containsKey(equipo)){
                        System.out.println(equipos.get(equipo).getJugadores());
                    }else{
                        System.out.println("equipo no encontrado");
                    }
                    break;
                case 3:
                    String nombre = pedirCadena("Que equipo buscas?");
                    String posicion = pedirCadena("Que poscion buscas?");
                    if(equipos.containsKey(nombre)){
                        for(Jugador j : equipos.get(nombre).getJugadores()){
                            if(posicion.equalsIgnoreCase(String.valueOf(j.getPosicion()))){
                                System.out.println(j);
                            }
                        }
                    }
                    break;
                case 4:
                    String elegido = pedirCadena("Que equipo buscas?");
                    int canastas = 0;
                    Jugador top = new Jugador();
                    if(equipos.containsKey(elegido)){
                        for(Jugador j : equipos.get(elegido).getJugadores()){
                            if(j.getCanasto() > canastas){
                                canastas = j.getCanasto();
                                top = j;
                            }
                        }
                        System.out.println("el jugador con mas canastas es");
                        System.out.println(top);
                    }
                    break;
            }
        }while(opcion2 != 5);
    }
}