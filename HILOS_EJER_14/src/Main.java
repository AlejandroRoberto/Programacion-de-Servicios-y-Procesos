import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numcoches = 0;
		String marcacoche = "";
		ArrayList<Coche> lista_coches = new ArrayList<Coche>();
		
		System.out.println("Introduzca el numero de coches a competir");
		numcoches = sc.nextInt();
		sc.nextLine();

		
		for(int i = 1; i < numcoches+1; i++) {
			System.out.println("Introduce la marca del coche "+i+" :");
			marcacoche = sc.nextLine();
			
			Coche c = new Coche(marcacoche,i);
			lista_coches.add(c);	
		}
		
		System.out.println("Que empiece la carrera!!!!");
		
		Iterator iter = lista_coches.iterator();
		while(iter.hasNext()) {
			Coche caux = (Coche) iter.next();
			caux.start();
		}
	}

}
