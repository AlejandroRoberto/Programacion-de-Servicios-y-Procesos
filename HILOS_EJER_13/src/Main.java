import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Casilla> lista_casillas = new ArrayList<Casilla>();
		Random r = new Random();
		int inf = 0;
		int sup = 0;
		int num = 0;
		
		System.out.println("Introduzca el limite inferior");
		inf = sc.nextInt();
		
		System.out.println("Introduzca el limite superior");
		sup = sc.nextInt();
		
		for ( int i= 0; i < 10 ; i++) {
			Casilla c = new Casilla();
			lista_casillas.add(c);
		}
		
		Hilo1 h1 = new Hilo1("Hilo1:",lista_casillas,inf,sup);
		Hilo2 h2 = new Hilo2("Hilo2:",lista_casillas,inf,sup);
		
		h1.start();
		h2.start();
	
	}

}
