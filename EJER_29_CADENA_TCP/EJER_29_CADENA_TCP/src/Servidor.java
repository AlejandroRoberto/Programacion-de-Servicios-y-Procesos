import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		
		File lista_compra = new File("lista_compra.txt");
		
		if(!lista_compra.exists()) {
			lista_compra.createNewFile();
		}
		
		
		String producto = "";
		producto = flujoEntrada.readUTF();
		
		System.out.println("Añadido a la lista de la compra : \n\t"+producto);
		
		FileWriter fw = new FileWriter("lista_compra.txt",true);
        fw.write(producto+"\n");
        fw.close();
		
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		
		// ENVIO UN SALUDO AL CLIENTE
		
		flujoSalida.writeUTF("Se ha añadido a la lista de la compra : "+producto);
		
		
		// CERRAR STREAMS Y SOCKETS
		
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
	}

}
