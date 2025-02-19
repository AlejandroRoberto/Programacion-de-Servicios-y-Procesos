
public class HiloSuma extends Thread{

	private Contador contador;
	private int cantidad;
	
	public HiloSuma(String n,Contador contador, int cantidad) {
		super(n);
		this.contador = contador;
		this.cantidad = cantidad;
	}



	public void run() {
		synchronized(contador) {
			for (int j=0; j < cantidad; j++) {
				contador.incrementa();
				try {
					sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
					System.out.println(getName() + " contador vale " + contador.valor());
				}
			}
	}
}
