import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		//ESPERANDO DATAGRAMA
		
		System.out.println("SERVIDOR ESPERANDO DATAGRAMA...");
		DatagramPacket recibo;
		
		byte[] bufer = new byte[1024];
		recibo = new DatagramPacket(bufer,bufer.length);
		
		
		// ASOCIO EL SOCKET AL PUERTO 12345 Y ME QUEDO ESPERANDO 
		
		DatagramSocket socket = new DatagramSocket(12345);
		socket.receive(recibo);
		
		String mensaje = new String(recibo.getData()).trim();
		System.out.println("SERVIDOR recibe : "+mensaje);
		
		
		// CONTAR EL NUMERO DE LETRAS A
		
		int contador = 0;
		for(int i=0;i<mensaje.length();i++) {
			if(mensaje.charAt(i) == 'a') {
				contador++;
			}
		}
		
		// DIRECCION ORIGEN DEL MENSAJE
		
		InetAddress ipOrigen = recibo.getAddress();
		int puerto = recibo.getPort();
		
		// ENVIANDO DATAGRAM AL CLIENTE 
		
		System.out.println("Enviando el numero de apariciones de la letra a : "+contador);
		byte b = (byte) contador;
		byte[] enviados = new byte[1024];
		enviados[0] = b;
		
		DatagramPacket envio = new DatagramPacket(enviados,enviados.length,ipOrigen,puerto);
		socket.send(envio);
		
		
		// CERRAR SOCKET
		
		System.out.println("CERRANDO LA CONEXION...");
		socket.close();
	}

}
