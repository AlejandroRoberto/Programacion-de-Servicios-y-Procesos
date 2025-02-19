import java.util.ArrayList;

public class Cuenta {
	private int id;
	static int ident_global=0;
	private ArrayList<Cliente> beneficiarios;
	private int saldo;
	private boolean deudora;
	
	public Cuenta() {
		beneficiarios = new ArrayList<Cliente>();
		saldo = 100;
		deudora = false;
		ident_global++;
		id = ident_global;
		System.out.println("Vamos a dar de alta la cuenta: "+id);
	}
	
	public void añadir_beneficiarios(Cliente c) {
		beneficiarios.add(c);
	}

	public int getId() {
		return id;
	}

	public int getSaldo() {
		return saldo;
	}

	public boolean isDeudora() {
		return deudora;
	}
	
	public synchronized void RetirarDinero(int cantidad, String nombre) {
		if (getSaldo() >= cantidad) {
			System.out.println(nombre + ": SE VA A RETIRAR SALDO. (Actual es: "+getSaldo()+" €).");
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
			saldo = saldo - cantidad;
		
			System.out.println("\t" + nombre + " retira "+cantidad+"€. Saldo actualizado es: ("+getSaldo()+" €).");
			
		}else {
			
			System.out.println(nombre + " no puede retirar dinero. No hay saldo("+getSaldo()+" €.)");
		}
		
		if (getSaldo() < 0) {
			
			System.out.println("Saldo negativo=>"+ getSaldo());
			deudora = true;
		}
	}
		
	public void info_cuenta() {
		
		if (deudora == false) {
			
			System.out.println("*** CUENTA: "+id+", ESTADO: ACTIVA, SALDO: "+saldo+" €.***");
			
		}else {
			
		System.out.println("*** CUENTA: "+id+", ESTADO: DEUDORA, SALDO: "+saldo+" €.***");
		
		}
		
		System.out.println("+Beneficiarios:");
		
		for (int i=0; i < beneficiarios.size();i++) {
			
			Cliente cli = (Cliente)beneficiarios.get(i);
			cli.info_cliente();
		}
	}
		
	public ArrayList<Cliente> devolver_beneficiarios(){
		return beneficiarios;
	}
}

