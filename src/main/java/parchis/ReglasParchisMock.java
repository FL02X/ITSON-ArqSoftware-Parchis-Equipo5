package parchis;

import java.util.Random;

public class ReglasParchisMock implements IReglasParchisFachada {
    private Random random;

    public ReglasParchisMock() {
        this.random = new Random();
    }

    public int lanzarDado() {
        return this.random.nextInt(6) + 1;
    }

    public int calcularNuevaPosicion(int posicionActual, int pasos) {
        int nuevaPosicion = posicionActual + pasos;
        if (nuevaPosicion > 68) {
            nuevaPosicion = nuevaPosicion - 68;
        }
        return nuevaPosicion;
    }
}
