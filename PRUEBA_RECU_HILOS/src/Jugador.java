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

    public void setPosicion(int x, int y) {
        this.posicionActualX = x;
        this.posicionActualY = y;
    }

    @Override
    public void run() {
        while (!juego.juegoTerminado() && vivo) {
            if (posicionActualX + 1 < juego.getLargo()) {
                int siguienteY = (posicionActualY + 1) % juego.getAncho();
                if (juego.saltarBaldosa(posicionActualX + 1, siguienteY, id)) {
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
