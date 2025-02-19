
public class Pasajero {

	private String clase;
	private String apellido;
	private String nombre;
	private String edad;
	private String embarque;
	private String survivor;
	
	
	public Pasajero(String clase, String apellido, String nombre, String edad, String embarque, String survivor) {
		super();
		this.clase = clase;
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.embarque = embarque;
		this.survivor = survivor;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getEmbarque() {
		return embarque;
	}


	public void setEmbarque(String embarque) {
		this.embarque = embarque;
	}


	public String getSurvivor() {
		return survivor;
	}


	public void setSurvivor(String survivor) {
		this.survivor = survivor;
	}
	
	
	
	
	
}
