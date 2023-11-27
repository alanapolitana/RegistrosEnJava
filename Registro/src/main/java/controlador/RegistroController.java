package controlador;

import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class RegistroController {
    private List<Persona> personasRegistradas;

    public RegistroController() {
        this.personasRegistradas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        personasRegistradas.add(persona);
    }

    public List<Persona> obtenerPersonasRegistradas() {
        return new ArrayList<>(personasRegistradas);
    }
}
