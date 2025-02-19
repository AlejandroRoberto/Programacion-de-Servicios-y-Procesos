
public class Hilo extends Thread{
	
	private Juego j;
	private String operacion;
	
	public Hilo(Juego j, String operacion) {
		this.j = j;
		this.operacion = operacion;
	}
	
	public void run() {
		synchronized(j) {
		for (int i=1; i <=5; i++) {
			if (j.cuentavivos() == 0) {
			break;
			}
			
			if (operacion.equals("ninya")) {
				j.ninya(i);
			}
			
			if (operacion.equals("eliminar")) {
				j.eliminar();
			}
			
			j.notify();
			
			try {
				j.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}//for
		j.notifyAll();
		}//synchronized
		if (operacion.equals("eliminar")) {
			System.out.println(j.concursantesVivos());
		}
	}//run
	}

