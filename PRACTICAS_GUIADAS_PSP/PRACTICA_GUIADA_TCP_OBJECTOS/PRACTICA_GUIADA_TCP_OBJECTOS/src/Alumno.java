import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Alumno implements Serializable {
    private String nombre;
    private int edad;
    private char repetidor;
    private ArrayList<String> listaAsignaturas = new ArrayList<>();

    public Alumno(String nombre, int edad, char repetidor) {
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
    }

    public void matricular() {
        try (Scanner scanner = new Scanner(System.in)) {
            String nombreAsignatura;
            do {
                System.out.println("Introduzca nombre de asignatura para matricular a " + nombre + ":");
                nombreAsignatura = scanner.nextLine().trim();
                if (!nombreAsignatura.equalsIgnoreCase("salir")) {
                    listaAsignaturas.add(nombreAsignatura);
                }
            } while (!nombreAsignatura.equalsIgnoreCase("salir"));
        }
    }

    public String datosSinAsignaturas() {
        String repetidorTexto = (repetidor == 's' || repetidor == 'S') ? "sí" : "no";
        return nombre + " de edad " + edad + " que " + repetidorTexto + " es repetidor.\n";
    }

    public String datosConAsignaturas() {
        StringBuilder cadena = new StringBuilder(datosSinAsignaturas());
        cadena.append("Lo hemos matriculado de: ");
        
        Iterator<String> iter = listaAsignaturas.iterator();
        while (iter.hasNext()) {
            cadena.append(iter.next()).append(" ");
        }
        cadena.append("\n");
        return cadena.toString();
    }
}
