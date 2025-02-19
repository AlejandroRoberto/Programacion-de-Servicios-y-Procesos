import java.util.ArrayList;
import java.util.Iterator;

public class Hilo extends Thread{
	
	private ArrayList<Pasajero> lista = new ArrayList<Pasajero>();
	
	public Hilo(String nombre, ArrayList<Pasajero> lista) {
		super(nombre);
		this.lista = lista;
	}
	
	public void run() {
		
		int cont1 = 0;
		int cont2 = 0;
		int cont3 = 0;
		int survivor1_si = 0;
		int survivor1_no = 0;
		int survivor2_si = 0;
		int survivor2_no = 0;
		int survivor3_si = 0;
		int survivor3_no = 0;
		
		Iterator iter = lista.iterator();
		
		while (iter.hasNext()) {
			Pasajero Paux = (Pasajero)iter.next();
			if (Paux.getClase().equalsIgnoreCase("1")) {
				cont1++;
				if (currentThread().getName().equals("Primera clase")){
					if (Paux.getSurvivor().equalsIgnoreCase("N")) {
						survivor1_no++;
					}else {
						survivor1_si++;
					}
				}
			}//fin del if de la primera clase
			
			if (Paux.getClase().equalsIgnoreCase("2")) {
				cont2++;
				if (currentThread().getName().equals("Segunda clase")){
					if (Paux.getSurvivor().equalsIgnoreCase("N")) {
						survivor2_no++;
					}else {
						survivor2_si++;
					}
				}
			}//fin del if de la segunda clase
			
			if (Paux.getClase().equalsIgnoreCase("3")) {
				cont3++;
				if (currentThread().getName().equals("Tercera clase")){
					if (Paux.getSurvivor().equalsIgnoreCase("N")) {
						survivor3_no++;
					}else {
						survivor3_si++;
					}
				}
			}//fin del if de la tercera clase
		}//while
		
	if (currentThread().getName().equals("Primera clase")) {
		System.out.println("+En Primera clase viajaban "+cont1+" pasajeros.Sobrevivieron "+survivor1_si+"("+((float)survivor1_si/cont1)*100+"%) y fallecieron"+survivor1_no+"("+((float)survivor1_no/cont1)*100+"%) pasajeros.");
	}
	if (currentThread().getName().equals("Segunda clase")) {
	System.out.println("+En Segunda clase viajaban "+cont2+" pasajeros.Sobrevivieron "+survivor2_si+"("+((float)survivor2_si/cont2)*100+"%) y fallecieron"+survivor2_no+"("+((float)survivor2_no/cont2)*100+"%) pasajeros.");
	}
	if (currentThread().getName().equals("Tercera clase")) {
	System.out.println("+En Tercera clase viajaban "+cont3+" pasajeros.Sobrevivieron "+survivor3_si+"("+((float)survivor3_si/cont3)*100+"%) y fallecieron"+survivor3_no+"("+((float)survivor3_no/cont3)*100+"%) pasajeros.");
	}
	}
}
