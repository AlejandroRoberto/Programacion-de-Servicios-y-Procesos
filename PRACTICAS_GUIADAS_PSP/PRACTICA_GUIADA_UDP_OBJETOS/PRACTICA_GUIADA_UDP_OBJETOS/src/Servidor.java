import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String[] burguers = {"CheeseBurguer","Whoper","LongChiken"};
		String[] company = {"Nuguets","Patatas Supreme","Patatas Clasicas"};
		String[] refresco = {"Cocacola","Agua","Fanta"};
		
		String burguer_def = "";
		String company_def = "";
		String refresco_def = "";
		
		boolean burguer_ok = false;
		boolean company_ok = false;
		boolean refresco_ok = false;
		
		// ESPERANDO DATAGRAMA
		System.out.println("Servidor esperando el datagrama...");
		
		
		byte[] recibidos = new byte[1024];
		DatagramPacket pqt_recibido = new DatagramPacket(recibidos,recibidos.length);
		
		// ASOCIO EL SOCKET AL PUERTO  12345 Y ME QUEDO ESPERANDO
		
		DatagramSocket socket = new DatagramSocket(12345);
		socket.receive(pqt_recibido);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
		ObjectInputStream in = new ObjectInputStream(bais);
		Pedido pedido = (Pedido) in.readObject();
		
		
		for ( int i = 0; i < burguers.length ; i++) {
			if(pedido.getburger().equalsIgnoreCase(burguers[i])) {
				burguer_ok = true;
				burguer_def = pedido.getburger(); 
			}
		}
		if(burguer_ok == false) {
			System.out.println("ERROR! La hamburguesa "+pedido.getburger()+" no existe!");
		}
		
		
		for ( int i = 0; i < company.length ; i++) {
			if(pedido.getcompany().equalsIgnoreCase(company[i])) {
				company_ok = true;
				company_def = pedido.getcompany(); 
			}
		}
		if(company_ok == false) {
			System.out.println("ERROR! El entrante "+pedido.getcompany()+" no existe!");
		}
		
		
		for ( int i = 0; i < refresco.length ; i++) {
			if(pedido.getrefresco().equalsIgnoreCase(refresco[i])) {
				refresco_ok = true;
				refresco_def = pedido.getrefresco(); 
			}
		}
		if(burguer_ok == false) {
			System.out.println("ERROR! El refresco "+pedido.getrefresco()+" no existe!");
		}
		
		
		// DIRECCION ORIGEN DEL MENSAJE
		
		InetAddress ipOrigen = pqt_recibido.getAddress();
		int puerto = pqt_recibido.getPort();
		
		// ENVIANDO EL DATAGRAMA AL CLIENTE
		
		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(bs);
		Pedido pedido_out = new Pedido(burguer_def,company_def,refresco_def);
		out.writeObject(pedido_out);
		out.close();
		
		byte[] enviados = bs.toByteArray();
		
		DatagramPacket envio = new DatagramPacket(enviados,enviados.length,ipOrigen,puerto);
		socket.send(envio);
		
		// CERRAR SOCKET
		
		System.out.println("Cerrando la conexion... ");
		socket.close();
	

		
	}

}
