import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Contador cont = new Contador(100);
		
		System.out.println("Tenemos dado de alta un contador = 100");
		System.out.println("Introduzca cantidad a sumar:");
		int cant_sumar = s.nextInt();
		
		System.out.println("Introduzca cantidad a restar:");
		int cant_restar = s.nextInt();
		
		HiloSuma hsuma = new HiloSuma("Hilosuma",cont,cant_sumar);
		HiloResta hresta = new HiloResta("Hiloresta",cont,cant_restar);
		hsuma.start();
		hresta.start();

	}

}
