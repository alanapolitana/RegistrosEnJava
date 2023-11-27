// En el paquete vista
package vista;

import controlador.RegistroController;
import modelo.Persona;

import java.util.List;
import java.util.Scanner;

public class RegistroVista {
    private RegistroController controlador;
    private Scanner scanner;

    public RegistroVista(RegistroController controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("1. Ingresar persona");
            System.out.println("2. Listar personas registradas");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarPersona();
                    break;
                case 2:
                    listarPersonas();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 3);
    }

    private void ingresarPersona() {
        System.out.println("Ingrese los datos de la persona:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("Fecha de Nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.next();

        Persona persona = new Persona(nombre, apellido, dni, fechaNacimiento);

        if (persona.validarDatos()) {
            controlador.agregarPersona(persona);
            System.out.println("Persona registrada con éxito.");
        } else {
            System.out.println("Error: Datos no válidos. Inténtelo de nuevo.");
        }
    }

    private void listarPersonas() {
        List<Persona> personasRegistradas = controlador.obtenerPersonasRegistradas();
        if (personasRegistradas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Personas registradas:");
            for (Persona persona : personasRegistradas) {
                System.out.println(persona);
            }
        }
    }
}
