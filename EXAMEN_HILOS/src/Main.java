import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Jugador> lista_jugadores = new ArrayList<Jugador>();
		
		//Creamos la lista de jugadores
		for (int i=1; i <= 456; i++) {
			Jugador j = new Jugador(i);
			lista_jugadores.add(j);
		}
		
		Juego calamar = new Juego(lista_jugadores);
		Hilo h1 = new Hilo(calamar,"ninya");
		Hilo h2 = new Hilo(calamar,"eliminar");
		h1.start();
		
		 //retrasamos 1 segundo el hilo h2 para que comience la niña.
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		h2.start();

	}

}
