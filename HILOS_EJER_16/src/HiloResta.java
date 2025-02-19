
public class HiloResta extends Thread{
	
	private Contador contador;
	private int cantidad;
	
	public HiloResta(String n,Contador c, int cantidad) {
		super(n);
		this.contador = c;
		this.cantidad = cantidad;
	}
	
	public void run() {
		synchronized(contador) {
			for (int j=0; j < cantidad; j++) {
				contador.decrementa();
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
