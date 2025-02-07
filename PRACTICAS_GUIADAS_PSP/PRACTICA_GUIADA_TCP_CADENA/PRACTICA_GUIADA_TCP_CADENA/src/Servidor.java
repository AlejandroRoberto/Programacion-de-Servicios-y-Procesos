import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		int puerto = 6000;	
		ServerSocket servidor = new ServerSocket(puerto);
		
		Socket clienteConectado = null;
		System.out.println("Esperando al Cliente...");
		clienteConectado = servidor.accept();
		
		
		// CREO EL FLUJO DE ENTRADA DEL CLIENTE
		
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		
		// EL CLIENTE ENVIA EL MENSAJE
		
		System.out.println("Recibiendo del Cliente : \n\t"+flujoEntrada.readUTF());
		
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		
		// ENVIO UN SALUDO AL CLIENTE
		
		flujoSalida.writeUTF("Saludos al Cliente desde el Servidor");
		
		
		// CERRAR STREAMS Y SOCKETS
		
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
	}

}
