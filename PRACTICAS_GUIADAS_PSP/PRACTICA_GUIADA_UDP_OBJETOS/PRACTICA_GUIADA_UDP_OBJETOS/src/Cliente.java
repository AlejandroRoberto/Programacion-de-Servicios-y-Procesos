import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		// DATOS DEL SERVIDOR AL ENVIAR EL MENSAJE
		
		InetAddress ipServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		
		
		// CREACION DE UN OBJETO
		System.out.println("Bienvenido a Burguer King Xpress! Haga su pedido en 3 pasos: ");
		System.out.println("1 - Introduzca el nombre de su Burguer:");
		String nomburguer = sc.nextLine();
		
		System.out.println("2 - Introduzca el nombre de su Entrante:");
		String nomentrante = sc.nextLine();
		
		System.out.println("3 - Introduzca el nombre de su Refresco:");
		String nomrefresco = sc.nextLine();
		
		
		Pedido pedido = new Pedido(nomburguer,nomentrante,nomrefresco);
		
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bs);
		out.writeObject(pedido);
		out.close();
		byte[] enviados = bs.toByteArray();
		
		
		// CREAMOS EL DATAGRAMA QUE IRÁ AL SERVIDOR 
			
		DatagramPacket envio = new DatagramPacket(enviados,enviados.length,ipServidor,puerto);
		
		// REALIZAMOS EL ENVIO
		
		DatagramSocket clienteSocket = new DatagramSocket(34567);
		clienteSocket.send(envio);
		
		
		// RECIBIENDO DATAGRAMA DEL SERVIDOR
		
		byte[] recibidos = new byte[1024];
		DatagramPacket pqt_recibido = new DatagramPacket(recibidos,recibidos.length);
		System.out.println("Esperamos datagrama...");
		clienteSocket.receive(pqt_recibido);
		
		
		
		// OBTENER EL NUMERO DE CARACTERES
		
		ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
		ObjectInputStream in = new ObjectInputStream(bais);
		Pedido pedido2 = (Pedido) in.readObject();
		
		System.out.println("Recibido el pedidio... "+pedido2.toString());
		
		in.close();
		clienteSocket.close();
		
		
	}

}
