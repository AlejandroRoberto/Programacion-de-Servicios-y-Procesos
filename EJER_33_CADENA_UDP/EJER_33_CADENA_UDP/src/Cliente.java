import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// DATOS DEL SERVIDOR AL QUE ENVIARLE EL MENSAJE 
		
		InetAddress ipServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		
		String nombre="";
		
		
		int opciones = 0;
		
		
		DatagramSocket clienteSocket = new DatagramSocket(34567);
		
		while(opciones != 4) {
			String cadena = "";
			nombre = "";
			
			System.out.println("== TICKET SERVER ==");
			System.out.println("1. Listar butacas");
			System.out.println("2. Reservar butacas");
			System.out.println("3. Anular butacas");
			System.out.println("4. Salir");
			
			System.out.println("Introduce la opcion");
			opciones = sc.nextInt();
			sc.nextLine();
			
			switch(opciones) {
			case 1: cadena = "1@vacio";
				break;
				
			case 2:System.out.println("Introduzca nombre para la reserva:");
				nombre = sc.nextLine();
				cadena = "2@"+nombre;
				break;
				
			case 3:System.out.println("Introduzca nombre para la cancelacion:");
				nombre = sc.nextLine();
				cadena = "3@"+nombre;
				break;
			
			case 4:System.out.println("GRACIAS POR UTILIZAR TICKET SERVER");
				break;
			
			case 123:System.out.println("ACCEDIENDO AL MODO ROOT");
				cadena = "123@vacio";
				break;
			
			default:System.out.println("OPCION INCORRECTA");
				continue;
			
			}
			
			
			
			byte[] enviados = new byte[1024];
			enviados = cadena.getBytes(); // CONVERTIR LA CADENA A BYTES
			
			
			// CREAMOS EL DATAGRAM QUE IRÁ AL SERVIDOR 
			
			DatagramPacket envio =new DatagramPacket(enviados,enviados.length,ipServidor,puerto);
			
			
			// REALIZAMOS EL ENVIO 
			
			
			
			
			
			if(opciones == 4) {
				clienteSocket.close();
			}else {
				clienteSocket.send(envio);
				if(opciones == 123) {
					clienteSocket.close();
					break;
				}
			}
				
		}
		
	}

}
