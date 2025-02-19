import java.util.*;

public class Juego {
    private ArrayList<Jugador> lista;

    public Juego(ArrayList<Jugador> lista) {
        this.lista = lista;
    }

    public void ninya(int numJuego) {
        System.out.println("Juego " + numJuego + " de 5...");
        String[] frases = {"Luz verde,", "ya puedes correr", "y parar!"};
        
        for (String frase : frases) {
            System.out.println(frase);
            esperar(1000);
        }
    }

    public void eliminar() {
        Random r = new Random();
        int numAEliminar = (int) (r.nextDouble() * cuentavivos());
        
        System.out.println("De " + cuentavivos() + ", vamos a eliminar a " + numAEliminar + " concursantes.");
        esperar(2000);
        
        for (int i = 0; i < numAEliminar; i++) {
            int aleat;
            do {
                aleat = r.nextInt(lista.size());
            } while (lista.get(aleat).getvivo() == 'N');
            
            System.out.println("Jugador " + aleat + ": ELIMINADO");
            lista.get(aleat).eliminar();
        }
        
        System.out.println("Quedan vivos... " + cuentavivos() + " concursantes.");
        System.out.println("------------------------------------");
        esperar(1000);
    }

    public int cuentavivos() {
        int cuenta = 0;
        for (Jugador jugador : lista) {
            if (jugador.getvivo() == 'S') {
                cuenta++;
            }
        }
        return cuenta;
    }

    public String concursantesVivos() {
        StringBuilder frase = new StringBuilder("Han sobrevivido los concursantes...");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getvivo() == 'S') {
                frase.append(" ").append(i);
            }
        }
        return frase.toString();
    }
    
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error en la pausa del hilo: " + e.getMessage());
        }
    }
}
