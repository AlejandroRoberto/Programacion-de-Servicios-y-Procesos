
public class Jugador {

	private int numero;
	private char vivo;
	
	public Jugador(int numero) {
		this.numero = numero;
		this.vivo = 'S';
	}

	public char getvivo() {
		return vivo;
	}
	
	public void eliminar() {
		vivo = 'N';
	}
	
}


