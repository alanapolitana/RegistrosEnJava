import controlador.RegistroController;
import vista.RegistroVista;

public class RegistroAppMain {
    public static void main(String[] args) {
        RegistroController controlador = new RegistroController();
        RegistroVista vista = new RegistroVista(controlador);
      
        vista.mostrarMenuPrincipal();
    }
}
