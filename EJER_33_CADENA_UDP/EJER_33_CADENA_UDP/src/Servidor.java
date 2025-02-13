import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Servidor {

	public static void main(String[] args) throws IOException {
		
		String[] butacas = new String[4];
		Queue<String> reservas = new LinkedList<String>();
		Arrays.fill(butacas,"");
		int opciones = 0;
		
		DatagramPacket recibo;
		
		DatagramSocket socket = new DatagramSocket(12345);
		System.out.println("SERVIDOR ESPERANDO DATAGRAMA...");
		
		
		while(true) {
			byte[] bufer = new byte[1024];
			recibo = new DatagramPacket(bufer,bufer.length);
			socket.receive(recibo);
			
			String mensaje = new String(recibo.getData()).trim();
			String[] partes = mensaje.split("@");
			
			opciones = Integer.parseInt(partes[0]);
			
			switch(opciones) {
			case 1: lista_butacas(butacas,reservas);
			break;
			
			case 2:System.out.println("Entra1");
				reservar_butaca(butacas,partes[1],reservas);
			break;
			
			case 3:anular_butaca(butacas,partes[1],reservas);
			break;
			
			case 123:break;
			
			default: System.out.println("La opcion "+opciones+ " es incorrecta");
			break;
			}
			
			if(opciones == 123) {
				break;
			}
		}
		socket.close();		
		
	}
	
	public static void lista_butacas(String[] butacas,Queue<String> reservas) {
		int esperando = 1;
		
		for(int i = 0;i < butacas.length;i++) {
			if(butacas[i].equals("")) {
				System.out.println((i+1)+":"+"LIBRE!");
			}else {
				System.out.println((i+1)+":"+butacas[i]);
			}
		}
		
		if(reservas.size() > 0) {
			System.out.println("Reservas:");
			Iterator iter = reservas.iterator();
			while(iter.hasNext()) {
				String persona = (String)iter.next();
				System.out.println(esperando+" : "+persona);
				esperando++;
			}
		}
	}
	
	public static void reservar_butaca(String[] butacas,String nombre,Queue<String> reservas) {
		System.out.println("Entra");
		int encontrado = -1;
		int pos_libre = 0;
		encontrado = buscar_butaca(butacas,nombre);
		if(encontrado == -1) {
			pos_libre = buscar_libre(butacas);
			if(pos_libre == -1) {
				System.out.println("Lo siento , ya no quedan butacas libres, pasa a la lista de reservas.");
				reservas.add(nombre);
				return;
			}
			butacas[pos_libre] = nombre;
			System.out.println(nombre + "tiene asignada la butaca "+(pos_libre+1));
		}
	
	}
	
	public static int buscar_butaca(String[] butacas,String nombre) {
		int resultado = -1;
		
		for(int i = 0; i < butacas.length; i++) {
			if(butacas[i].equalsIgnoreCase(nombre)) {
				System.out.println(nombre+ " tenia asignada la butaca "+ (i+1));
				resultado = i;
				break;
			}
		}
		
		return resultado;
	}
	
	public static int buscar_libre(String[] butacas) {
		int resultado = -1;
		
		for(int i = 0; i < butacas.length; i++) {
			if(butacas[i].equals("")) {
				resultado = i;
				break;
			}
		}
		
		return resultado;
	}
	
	public static void anular_butaca(String[] butacas,String nombre,Queue<String> reservas) {
		int encontrado;
		encontrado = buscar_butaca(butacas,nombre);
		
		if(encontrado == -1) {
			System.out.println(nombre+" no tiene comprada ninguna butaca");
		}else {
			butacas[encontrado] = "";
			System.out.println("La butaca "+(encontrado+1)+" queda libre.");
			if(reservas.size() > 0) {
				System.out.println("Se adjudica a la primera persona de la lista de reservas que es: ");
				System.out.println(reservas.peek());
				butacas[encontrado] = reservas.peek();
				reservas.remove();
			}
		}
	}
	
	

}
