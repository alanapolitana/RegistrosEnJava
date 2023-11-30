package vista;

import controlador.RegistroController;
import modelo.Persona;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        String nombre;
        String apellido;
        String dni;
        String fechaNacimiento;

        // Validación del nombre
        do {
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.next();
            if (nombre.isBlank() || !esLetras(nombre)) {
                System.out.println("Error: El nombre debe contener solo letras. Inténtelo de nuevo.");
            }
        } while (nombre.isBlank() || !esLetras(nombre));

        // Validación del apellido
        do {
            System.out.print("Ingrese el apellido: ");
            apellido = scanner.next();
            if (apellido.isBlank() || !esLetras(apellido)) {
                System.out.println("Error: El apellido debe contener solo letras. Inténtelo de nuevo.");
            }
        } while (apellido.isBlank() || !esLetras(apellido));

        // Validación del DNI
        do {
            System.out.print("Ingrese el DNI (entre 8 y 12 dígitos): ");
            dni = scanner.next();
            if (!dni.matches("\\d{8,12}")) {
                System.out.println("Error: El DNI debe contener entre 8 y 12 dígitos numéricos. Inténtelo de nuevo.");
            }
        } while (!dni.matches("\\d{8,12}"));

        // Validación de la fecha de nacimiento
        do {
            System.out.print("Ingrese la Fecha de Nacimiento (dd/mm/yyyy): ");
            fechaNacimiento = scanner.next();
            if (!validarFecha(fechaNacimiento)) {
                System.out.println("Error: La fecha de nacimiento debe tener el formato dd/mm/yyyy. Inténtelo de nuevo.");
            }
        } while (!validarFecha(fechaNacimiento));

        Persona persona = new Persona(nombre, apellido, dni, fechaNacimiento);
        controlador.agregarPersona(persona);
        System.out.println("Persona registrada con éxito.");
    }

    private boolean esLetras(String texto) {
        return Pattern.matches("[a-zA-Z]+", texto);
    }

    private boolean validarFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            Date parsedDate = dateFormat.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
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
