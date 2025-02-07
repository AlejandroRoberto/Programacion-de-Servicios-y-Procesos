import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	
        String host = "localhost";
        int puerto = 6000;
        Scanner scanner = new Scanner(System.in);

        System.out.println("PROGRAMA CLIENTE INICIADO");
        Socket cliente = new Socket(host, puerto);

        System.out.println("Introduzca nombre del alumno a matricular:");
        String nombre = scanner.nextLine();
        System.out.println("Introduzca edad de " + nombre + ":");
        int edad = scanner.nextInt();
        scanner.nextLine();

        char repetidor;
        while (true) {
            System.out.println("¿" + nombre + " es repetidor (s/n)?");
            repetidor = scanner.nextLine().charAt(0);
            if (repetidor == 's' || repetidor == 'S' || repetidor == 'n' || repetidor == 'N') {
                break;
            } else {
                System.out.println("El valor introducido no es valido, recuerde: s/n");
            }
        }

        Alumno alumno = new Alumno(nombre, edad, repetidor);
        System.out.println("El alumno que se envia al servidor es el siguiente:");
        System.out.println(alumno.datosSinAsignaturas());

        try (ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
             ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream())) {

            outObjeto.writeObject(alumno);

            Alumno alumnoRecibido = (Alumno) inObjeto.readObject();
            System.out.println("El alumno que vuelve del servidor es el siguiente:");
            System.out.println(alumnoRecibido.datosConAsignaturas());
        }

        cliente.close();
    }
}
