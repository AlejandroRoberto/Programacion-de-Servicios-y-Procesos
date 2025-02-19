
public class Contador {

	private int c;

	public Contador(int c) {
		super();
		this.c = c;
	}
	
	public void incrementa() {
		c++;
	}
	
	public void decrementa() {
		c--;
	}
	
	public int valor() {
		return c;
	}
}
