package parchis;

import java.util.ArrayList;
import java.util.List;

public class JuegoModel {
    private List<ObservadorJuego> observadores;
    private IReglasParchisFachada fachadaReglas;
    private List<Jugador> jugadores;
    private int indiceTurnoActual;
    private int ultimoDado;
    private String mensajeEstado;

    public JuegoModel(IReglasParchisFachada fachadaReglas) {
        this.fachadaReglas = fachadaReglas;
        this.observadores = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.jugadores.add(new Jugador(1, "Jugador 1 (Rojo)", "Rojo"));
        this.jugadores.add(new Jugador(2, "Jugador 2 (Azul)", "Azul"));
        this.indiceTurnoActual = 0;
        this.ultimoDado = 0;
        this.mensajeEstado = "Inicia el juego. Turno de " + this.jugadores.get(0).getNombre();
    }

    public void agregarObservador(ObservadorJuego observador) {
        this.observadores.add(observador);
    }

    public void notificarObservadores() {
        for (int i = 0; i < this.observadores.size(); i++) {
            this.observadores.get(i).actualizar(this);
        }
    }

    public void ejercerTurno() {
        Jugador jugadorActual = this.jugadores.get(this.indiceTurnoActual);
        this.ultimoDado = this.fachadaReglas.lanzarDado();
        int nuevaPosicion = this.fachadaReglas.calcularNuevaPosicion(jugadorActual.getCasillaActual(), this.ultimoDado);
        jugadorActual.setCasillaActual(nuevaPosicion);

        this.mensajeEstado = jugadorActual.getNombre() + " saco un " + this.ultimoDado + " y avanzo a la casilla " + nuevaPosicion;

        if (this.indiceTurnoActual == 0) {
            this.indiceTurnoActual = 1;
        } else {
            this.indiceTurnoActual = 0;
        }

        notificarObservadores();
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public Jugador getJugadorActual() {
        return this.jugadores.get(this.indiceTurnoActual);
    }

    public int getUltimoDado() {
        return this.ultimoDado;
    }

    public String getMensajeEstado() {
        return this.mensajeEstado;
    }
}
