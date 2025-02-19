
public class Casilla {

	private int indice;
	private int valor;
	private char valor_hilo;
	static int id=0;
	
	
	public Casilla() {
		super();
		this.indice = id;
		this.valor_hilo = ' ';
		id++;
	}


	public int getIndice() {
		return indice;
	}

	public int getValor() {
		return valor;
	}

	public char getValor_hilo() {
		return valor_hilo;
	}

	public void setValor_hilo(char valor_hilo , int valor) {
		this.valor_hilo = valor_hilo;
		this.valor = valor;
	}
	
	
	
	
}
