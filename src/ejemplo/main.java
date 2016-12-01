package ejemplo;

import java.util.ArrayList;
import java.util.List;
import tools.Fichero;
import static tools.InputData.pedirCadena;
import static tools.InputData.pedirDouble;
import static tools.InputData.pedirEntero;

public class main {

    private static ListaPersonas personas;
    private static Fichero miFichero;

    public static void main(String[] args) {

        miFichero = new Fichero("personas.xml");
        personas = (ListaPersonas) miFichero.leer();
        if (personas == null) {
            personas = new ListaPersonas();
        }

        Persona persona = new Persona();
        int opcion = 0;
        do {
            do{
                opcion = menu();
            }while(opcion < 1 || opcion > 8);
            switch (opcion) {

                case 1:
                    persona = registrar();
                    personas.altaPersona(persona);
                    miFichero.grabar(personas);
                    break;
                case 2:
                    int tfno = pedirEntero("Numero del cliente?");
                    if (personas.encontrar(tfno)) {
                        Persona p = personas.obtenerNumero(tfno);
                        Presupuesto pto = presupuesto();
                        p.getPresupuestos().altaPresupuesto(pto);
                    } else {
                        persona = registrar();
                        personas.altaPersona(persona);
                        Presupuesto p = presupuesto();
                        persona.getPresupuestos().altaPresupuesto(p);
                    }
                    miFichero.grabar(personas);
                    break;
                case 3:
                    for (Persona cliente : personas.getLista()) {
                        for (Presupuesto presupuesto : cliente.getPresupuestos().getLista()) {
                            if (presupuesto.getEstado().equalsIgnoreCase("pendiente")) {
                                System.out.println(presupuesto.getNum());
                                System.out.println(cliente.getNombre());
                                System.out.println(cliente.getApellido());
                            }
                        }
                    }
                    break;
                case 4:
                    int num = pedirEntero("Numero de telefono?");
                    for (Persona cliente : personas.getLista()) {
                        if (num == cliente.getNumero()) {
                            for (Presupuesto presupuesto :  cliente.getPresupuestos().getLista()) {
                                System.out.println(presupuesto);
                            }
                        }
                    }
                    break;
                case 5:
                    for (Persona cliente : personas.getLista()) {
                        for (Presupuesto presupuesto :  cliente.getPresupuestos().getLista()) {
                            if(presupuesto.getEstado().equalsIgnoreCase("rechazado"))
                                System.out.println(presupuesto);
                        }
                    }
                    break;
                case 6:
                    int presupuestos = 0;
                    for(Persona cliente : personas.getLista()){
//                        for(Presupuesto presupuesto : cliente.getPresupuestos().getLista()){
//                            presupuestos++;
//                        }
                        System.out.println(cliente + " " + cliente.getPresupuestos().getLista().size());
                    }
                    break;
                case 7:
                    num = pedirEntero("Numero de telefono?");
                    for (Persona cliente : personas.getLista()) {
                        if (num == cliente.getNumero()) {
                            int num2 = pedirEntero("Numero de presupuesto?");
                            for (Presupuesto presupuesto :  cliente.getPresupuestos().getLista()) {
                                if(num2 == presupuesto.getNum()){
                                    System.out.println("Estado del presupuesto?" + " actual: " + presupuesto.getEstado());
                                    int j = 0;
                                    do {
                                        System.out.print("1- Aceptado");
                                        System.out.print("2- Rechazado");
                                        System.out.print("3- Pendiente");
                                        j = pedirEntero("");
                                    } while (j < 1 || j > 3);
                                    presupuesto = acerecha(j,presupuesto);
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    grabar2();
                    break;
            }
        } while (opcion != 8);
    }

    public static Persona registrar() {

        Persona persona = new Persona();

        persona.setNombre(pedirCadena("Nombre del cliente?"));
        persona.setApellido(pedirCadena("Apellido del cliente?"));
        boolean repetido = true;
        Integer numero;
        String vip;
        do {
            numero = pedirEntero("Numero de telefono?");
            if (personas.encontrar(numero)) {
                repetido = false;
            } else {
                repetido = true;
            }
        } while (!repetido);
        persona.setNumero(numero);
        do {
            vip = pedirCadena("Eres vip? escribe si o no");
            if (vip.equalsIgnoreCase("si")) {
                persona.setVip(true);
            } else if (vip.equalsIgnoreCase("no")) {
                persona.setVip(false);
            }
        } while (!vip.equalsIgnoreCase("no") && !vip.equalsIgnoreCase("si"));

        return persona;
    }

    public static Presupuesto presupuesto() {

        Presupuesto presupuesto = new Presupuesto();

        presupuesto.setNum(pedirEntero("numero de presupuesto?"));
        presupuesto.setConcepto(pedirCadena("Concepto?"));
        presupuesto.setPrecioNeto(pedirDouble("precio total?"));
        System.out.println("Esta aceptado, rechazado, o pendiente?");
        int j = 0;
        do {
            System.out.print("1- Aceptado");
            System.out.print("2- Rechazado");
            System.out.print("3- Pendiente");
            j = pedirEntero("");
        } while (j < 1 || j > 3);
        presupuesto = acerecha(j, presupuesto);

        return presupuesto;
    }

    public static Presupuesto acerecha(int j, Presupuesto presupuesto) {
        if (j == 1) {
            presupuesto.setEstado("Aceptado");
        }
        if (j == 2) {
            presupuesto.setEstado("Rechazado");
        }
        if (j == 3) {
            presupuesto.setEstado("Pendiente");
        }
        return presupuesto;
    }
    public static int menu(){

        System.out.println("1. Alta cliente");
        System.out.println("2. Nuevo presupuesto");
        System.out.println("3. Presupuestos pendientes (de aceptar o rechazar)");
        System.out.println("4. Listado de presupuestos de un cliente determinado");
        System.out.println("5. Listado de presupuestos rechazados.");
        System.out.println("6. Listado de clientes, donde aparezca también el total de presupuestos que tiene cada uno");
        System.out.println("7. Cambiar estado de un presupuesto.");
        System.out.println("8. Salir");


        return pedirEntero("");
    }
    public static void grabar2(){
        miFichero.grabar(personas);
    }
}