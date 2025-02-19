class Jugador extends Thread {
    private Juego juego;
    private int id;
    private int posicionActualX;
    private int posicionActualY;
    private boolean vivo;

    public Jugador(Juego juego, int id, int posX, int posY) {
        this.juego = juego;
        this.id = id;
        this.posicionActualX = posX;
        this.posicionActualY = posY;
        this.vivo = true;
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void matar() {
        vivo = false;
    }

    @Override
    public void run() {
        while (!juego.juegoTerminado() && vivo) {
            if (posicionActualX < juego.getLargo()) {
                int siguienteY = (posicionActualY) % juego.getAncho();
                if (juego.saltarBaldosa(posicionActualX, siguienteY, id)) {
                    matar();
                    juego.eliminarJugador(this);
                } else {
                    posicionActualX++;
                    posicionActualY = siguienteY;
                    juego.actualizarUltimaPosicionCorrecta(posicionActualX, posicionActualY);
                    try {
                        Thread.sleep(1000); // Simula el tiempo que tarda el jugador en saltar
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                matar();
                juego.eliminarJugador(this);
            }
        }
    }
}