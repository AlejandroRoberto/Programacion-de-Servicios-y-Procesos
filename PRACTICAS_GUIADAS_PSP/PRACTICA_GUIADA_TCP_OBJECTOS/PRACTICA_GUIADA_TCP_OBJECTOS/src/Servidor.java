import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int puerto = 6000;
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Esperando al cliente....");
            try (Socket cliente = servidor.accept();
                 ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
                 ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream())) {

                Alumno alumnoRecibido = (Alumno) inObjeto.readObject();
                System.out.println("Matriculando al alumno...");
                alumnoRecibido.matricular();

                outObjeto.writeObject(alumnoRecibido);
            }
        }
    }
}
