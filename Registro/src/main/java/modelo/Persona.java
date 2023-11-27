package modelo;

import java.util.Date;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;

    public Persona(String nombre, String apellido, String dni, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean validarDatos() {
        return !nombre.isBlank() && !apellido.isBlank() && dni.matches("\\d{8}")
                && fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + dni + ", Fecha de Nacimiento: " + fechaNacimiento;
    }
}
