import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// DATOS DEL SERVIDOR AL QUE ENVIARLE EL MENSAJE 
		
		InetAddress ipServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		
		
		// INTRODUCIR DATOS POR TECLADO
		System.out.println("Introduce el mensaje");
		String cadena = sc.nextLine();
		
		byte[] enviados = new byte[1024];
		enviados = cadena.getBytes(); // CONVERTIR LA CADENA A BYTES
		
		
		// CREAMOS EL DATAGRAM QUE IRÁ AL SERVIDOR 
		
		DatagramPacket envio =new DatagramPacket(enviados,enviados.length,ipServidor,puerto);
		
		
		// REALIZAMOS EL ENVIO 
		
		DatagramSocket clienteSocket = new DatagramSocket(34567);
		clienteSocket.send(envio);
		
		
		// RECIBIENDO DATAGRAMA DEL SERVIDOR
		
		byte[] recibidos = new byte[2];
		DatagramPacket recibo = new DatagramPacket(recibidos,recibidos.length);
		System.out.println("ESPERANDO DATAGRAMA...");
		clienteSocket.receive(recibo);
		
		
		// OBTENER EL NUMERO DE CARACTERES
		
		byte[] vector_bytes = recibo.getData();
		int numero = vector_bytes[0];
		System.out.println("Recibo numero de caracteres 'a' que son : "+numero);
		
		clienteSocket.close();
		
	}

}
