
public class Autobus {

	private String matricula;
	private int velocidad;
	
	public Autobus(String matricula) {
		super();
		this.matricula = matricula;
		this.velocidad = 50;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int nuevavelo) {
		this.velocidad = nuevavelo;
	}
	
	
}
