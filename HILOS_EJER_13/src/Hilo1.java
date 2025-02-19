import java.util.ArrayList;
import java.util.Random;

public class Hilo1 extends Thread{
	
	private ArrayList<Casilla> lista;
	private int inf;
	private int sup;
	
	public Hilo1(String nombre,ArrayList<Casilla> lista, int inf, int sup) {
		super(nombre);
		this.lista = lista;
		this.inf = inf;
		this.sup = sup;
	}
	
	public void run() {
		Random r = new Random();
		int num;
		for ( int i = 0; i < 10 ; i++) {
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			num = (int)(r.nextDouble()*(sup-inf+1)+inf);
			if(lista.get(i).getValor_hilo() == ' ') {
				lista.get(i).setValor_hilo('1', num);
			}else {
				break;
			}
			
			pintar_tabla();
		}
	}
	
	public void pintar_tabla() {
		
		for (int j=0; j < 10; j++) {
			Casilla caux = lista.get(j);
			System.out.print(caux.getIndice()+"\t");
		}
		
			System.out.println("");
			
		for (int j= 0; j < 75;j++) {
			System.out.print("-");
		}
			System.out.println("");
			
		for (int j=0; j < 10; j++) {
			Casilla caux = lista.get(j);
			System.out.print(caux.getValor()+"\t");
		}
		
			System.out.println("");
		
		for (int j=0; j < 10; j++) {
			Casilla caux = lista.get(j);
			System.out.print(caux.getValor_hilo()+"\t");
		}
		
			System.out.println("\n");
	}

	
	

}
