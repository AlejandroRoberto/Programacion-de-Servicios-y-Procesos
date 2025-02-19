import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Pasajero> lista_pasajeros = new ArrayList<Pasajero>();
		
		System.out.println("BIENVENIDO AL TITANIC");
		
		
		//PRIMERA PARTE: PARSEAMOS EL FICHERO CSV A UN ARRAYLIST
		
		try(BufferedReader br = new BufferedReader(new FileReader("Titanic.csv"))){
			String linea;
			while((linea = br.readLine())!= null){
				String[] cadena = linea.split(",");
			
				Pasajero p = new Pasajero(cadena[0],cadena[1],cadena[2],cadena[3],cadena[4],cadena[5]);
				lista_pasajeros.add(p);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		
		
		//SEGUNDA PARTE: LANZAMOS LOS 3 HILOS
		
		Hilo h1 = new Hilo("Primera clase",lista_pasajeros);
		Hilo h2 = new Hilo("Segunda clase",lista_pasajeros);
		Hilo h3 = new Hilo("Tercera clase",lista_pasajeros);
		
		h1.setPriority(Thread.MAX_PRIORITY);
		h2.setPriority(Thread.MIN_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		h1.start();
		h2.start();
		h3.start();
		
		try {
			
			h1.join();
			h2.join();
			h3.join();
		
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("FIN DE LA TRAVESIA");
	}
		
}

