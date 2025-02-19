import java.util.Random;

public class Coche extends Thread{

	private int numero;
	private boolean frenar;
	private int distancia;
	
	public Coche(String nombre,int numero) {
		super(nombre);
		this.numero = numero;
		frenar = false;
		distancia = 0;
		System.out.println("Coche creado : "+nombre+" ("+numero+")");
	}
	
	public void run() {
		Random r = new Random();
		int num;
		
		while(frenar == false) {
			num = (int)(r.nextDouble()*100);
			distancia += num;
			
			if( distancia > 500) {
				frenar = true;
			}else {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(getName()+"("+numero+") lleva recorrido "+distancia+" km!");
			}
		}
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("El "+getName()+"("+numero+") ha finalizado al recorrer "+distancia+" km.");

	}
	
	
}
