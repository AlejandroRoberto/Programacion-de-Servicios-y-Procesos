import java.io.*;
import java.net.*;

public class Cliente {

	public static void main(String[] args) throws IOException {
		
		String host = "localhost";
		int puerto = 6000; // PUERTO REMOTO
		
		System.out.println("PROGRAMA DEL CLIENTE INICIADO...");
		
		Socket cliente = new Socket(host,puerto);
		
		
		// CREO EL FLUJO DE SALIDA AL SERVIDOR
		
		DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
				
		
		// ENVIO UN SALUDO AL SERVIDOR
			
		flujoSalida.writeUTF("Saludos al Servidor desde el Cliente");
		
		
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
