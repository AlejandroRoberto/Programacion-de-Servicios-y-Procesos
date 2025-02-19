import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		File primeros = new File("primeros.txt");
		File segundos = new File("segundos.txt");
		File postres = new File("postres.txt");
		
		FileWriter file_primeros = null;
		FileWriter file_segundo = null;
		FileWriter file_postres = null;
		
		if(!primeros.exists()) {
			try {
				primeros.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!segundos.exists()) {
			try {
				segundos.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(!postres.exists()) {
			try {
				postres.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			file_primeros = new FileWriter(primeros);
			file_segundo = new FileWriter(segundos);
			file_postres = new FileWriter(postres);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ThreadGroup grupo = new ThreadGroup("Menu Diario");
		
		Hilo h = new Hilo(file_primeros,file_segundo,file_postres);
		
		Thread h1 = new Thread(grupo,h,"Hilo1");
		Thread h2 = new Thread(grupo,h,"Hilo2");
		Thread h3 = new Thread(grupo,h,"Hilo3");
		
		
		h1.start();
		h2.start();
		h3.start();
		
		
	}

}
