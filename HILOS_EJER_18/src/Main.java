
public class Main {

	public static void main(String[] args) {
		Autobus a = new Autobus("123456");
		Speed hilo1 = new Speed(a,"acelerar");
		Speed hilo2 = new Speed(a,"frenar");
		
		hilo1.start();
		
		
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hilo2.start();
	}

}
