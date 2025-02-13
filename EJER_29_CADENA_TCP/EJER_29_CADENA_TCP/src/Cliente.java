import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	
		String host = "localhost";
		int puerto = 6000; // PUERTO REMOTO
		
		System.out.println("PROGRAMA DEL CLIENTE INICIADO...");
		
		Socket cliente = new Socket(host,puerto);
		
		
		// CREO EL FLUJO DE SALIDA AL SERVIDOR
		
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
				
		
		// ENVIO UN SALUDO AL SERVIDOR
		
		System.out.println("Que producto quieres añadir a la lista de la compra?");
		String producto = sc.nextLine();
			
		flujoSalida.writeUTF(producto);
		
		
		// CREO EL FLUJO DE ENTRADA AL SERVIDOR
		
		DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
			
		// EL SERVIDOR ME ENVIA UN MENSAJE
			
		System.out.println("Recibiendo del Servidor : \n\t "+flujoEntrada.readUTF());
			
		
		// CERRAMOS STREAMS Y SOCKETS
		
		flujoEntrada.close();
		flujoSalida.close();
		cliente.close();
	}

}
