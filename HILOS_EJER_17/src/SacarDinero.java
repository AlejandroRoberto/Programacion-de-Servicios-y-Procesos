
public class SacarDinero extends Thread{
	private Cuenta c;
	String nombre;
	
	public SacarDinero(String n,Cuenta c) {
		this.nombre = n;
		this.c = c;
	}
	
	public void run() {
		for (int x = 0; x < 3; x++) {
			c.RetirarDinero(10, nombre);
		}
	}
	
}
