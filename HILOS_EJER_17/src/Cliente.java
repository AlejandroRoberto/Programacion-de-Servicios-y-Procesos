
public class Cliente {
	private String nombre;
	private int edad;
	private char spanish;
	
	
	public Cliente(String nombre, int edad, char spanish) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.spanish = spanish;
	}
	
	public void info_cliente() {
		System.out.println("\t-"+nombre+" ("+spanish+"), "+edad);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	
}
