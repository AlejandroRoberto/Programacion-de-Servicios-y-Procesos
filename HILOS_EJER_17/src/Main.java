import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		while(opcion != 4) {
			opcion = leer_opcion(sc);
			
			switch(opcion) {
			
			case 1:Alta_cuenta(sc,cuentas);
				break;
				
			case 2:Resumen_cuentas(cuentas);
				break;
				
			case 3:Sacar_dinero(sc,cuentas);
				break;
			}
		}
		System.out.println("Gracias, siga endeudandose.....");
		
	}
	
	public static int leer_opcion(Scanner sc) {
		int opcion=0;
		System.out.println("------------------------------");
		System.out.println("1-Dar de alta una cuenta");
		System.out.println("2-Resumen de cuentas");
		System.out.println("3-Sacar dinero de una cuenta");
		System.out.println("4-Salir");
		System.out.println("------------------------------");
		
		opcion = sc.nextInt();
		return opcion;
	}
	
	public static void Alta_cuenta(Scanner s, ArrayList<Cuenta> cuentas) {
		Cuenta c = new Cuenta();
		int numbene;
		String nombene;
		int edadbene;
		char spanishbene;
		
		System.out.println("Introduzca número de beneficiarios:");
		numbene = s.nextInt();
		s.nextLine();
		
		for (int i=1; i <= numbene; i++) {
			
			System.out.println("Introduzca nombre del beneficiario "+i+":");
			nombene = s.nextLine();
			
			System.out.println("Introduzca edad del beneficiario "+i+":");
			edadbene = s.nextInt();
			s.nextLine();
			
			System.out.println("¿"+nombene+" tiene nacionalidad española (s/n)?");
			spanishbene = s.nextLine().charAt(0);
			
			Cliente cli = new Cliente(nombene, edadbene, spanishbene);
			c.añadir_beneficiarios(cli);
			
		}
		cuentas.add(c);
		}
		
		public static void Resumen_cuentas(ArrayList<Cuenta> cuentas) {
			
		System.out.println("----Resumen global de cuentas----");
		
		Iterator iter = cuentas.iterator();
			while (iter.hasNext()) {
				Cuenta cuen = (Cuenta)iter.next();
				cuen.info_cuenta();
			}
		System.out.println("");
		}
		
	public static void Sacar_dinero(Scanner s, ArrayList<Cuenta> cuentas) {
			
		boolean cuenta_encontrada = false;
		int IdLeido = 0;
		Cuenta caux = null;
		SacarDinero h1 = null;
		
		//paso1 - validamos que la cuenta exista
		while (cuenta_encontrada == false) {
			System.out.println("Introduzca Id de la cuenta de donde quiere sacar dinero:");
			IdLeido = s.nextInt();
			Iterator iter = cuentas.iterator();
			while (iter.hasNext()) {
				caux = (Cuenta)iter.next();
				if (caux.getId() == IdLeido) {
				cuenta_encontrada = true;
				break;
				}
			}
			
			if (cuenta_encontrada == false) {
				System.out.println("La cuenta con Id "+IdLeido+" no existe...");
			}
		}
		
		//paso2 - hacer que todos los beneficiarios saquen dinero (cada uno 30 euros en billetes de 10 €)
		ArrayList<Cliente> lista_beneficiarios = caux.devolver_beneficiarios();
		for (int i=0; i < lista_beneficiarios.size(); i++) {
			h1 = new SacarDinero(lista_beneficiarios.get(i).getNombre(),caux);
			h1.start();
		}
		
		//paso3 - espero a que los clientes saquen el dinero (que finalicen los hilos) para mostrar el menu
		try {
			h1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


