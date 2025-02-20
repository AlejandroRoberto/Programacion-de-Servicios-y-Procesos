import java.util.ArrayList;
import java.util.Random;

class Juego {
    private int largo;
    private int ancho;
    private char[][] tablero;
    private boolean juegoTerminado;
    private int[] baldosasSeguras; // Array para almacenar la posición de las baldosas seguras en cada fila
    private ArrayList<Jugador> jugadores;
    private int ultimaPosicionCorrectaX;
    private int ultimaPosicionCorrectaY;

    public Juego(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
        this.tablero = new char[largo][ancho];
        this.juegoTerminado = false;
        this.baldosasSeguras = new int[largo];
        this.jugadores = new ArrayList<>();
        this.ultimaPosicionCorrectaX = 0;
        this.ultimaPosicionCorrectaY = 0;

        // Inicializa el tablero con baldosas y define baldosas seguras
        Random random = new Random();
        for (int i = 0; i < largo; i++) {
            baldosasSeguras[i] = random.nextInt(ancho); // Define una baldosa segura al azar en cada fila
            for (int j = 0; j < ancho; j++) {
                tablero[i][j] = 'O'; // 'O' representa una baldosa intacta
            }
        }

        // Crea 10 jugadores
        for (int i = 1; i <= 10; i++) {
            jugadores.add(new Jugador(this, i, ultimaPosicionCorrectaX, ultimaPosicionCorrectaY));
        }
    }

    public synchronized boolean saltarBaldosa(int x, int y, int jugadorId) {
        if (x >= largo-1) {
            juegoTerminado = true;
            System.out.println("Jugador " + jugadorId + " llegó al final del pasillo. ¡Juego terminado!");
            return false;
        }

        if (tablero[x][y] == 'O') {
            if (y == baldosasSeguras[x]) {
                System.out.println("Jugador " + jugadorId + " saltó en (" + x + ", " + y + "). Baldosa segura.");
                // Marca la otra baldosa de la fila como rota
                int otraBaldosaY = (y == 0) ? 1 : 0; // Si la baldosa segura es la 0, la rota será la 1 y viceversa
                if (tablero[x][otraBaldosaY] == 'O') {
                    tablero[x][otraBaldosaY] = 'X'; // Marca solo si no está rota ya
                }
                actualizarUltimaPosicionCorrecta(x, y);
                imprimirTablero();
                return false;
            } else {
                tablero[x][y] = 'X'; // 'X' representa una baldosa rota
                System.out.println("Jugador " + jugadorId + " saltó en (" + x + ", " + y + "). Baldosa rota. Jugador eliminado.");
                imprimirTablero();
                return true;
            }
        }
        return false;
    }

    public synchronized boolean juegoTerminado() {
        return juegoTerminado;
    }

    public int getAncho() {
        return ancho;
    }

    public synchronized void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
        if (!jugadores.isEmpty()) {
            Jugador siguienteJugador = jugadores.get(0);
            siguienteJugador.setPosicion(ultimaPosicionCorrectaX, ultimaPosicionCorrectaY);
            siguienteJugador.start();
        } else {
            juegoTerminado = true;
            System.out.println("Todos los jugadores han sido eliminados. ¡Juego terminado!");
        }
    }

    public synchronized void actualizarUltimaPosicionCorrecta(int x, int y) {
        ultimaPosicionCorrectaX = x;
        ultimaPosicionCorrectaY = y;
    }

    public void iniciarJuego() {
        if (!jugadores.isEmpty()) {
            jugadores.get(0).start();
        }
    }

    public void imprimirTablero() {
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getLargo() {
        return largo;
    }
}
