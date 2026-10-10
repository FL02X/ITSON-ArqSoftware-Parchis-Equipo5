package parchis;

public class Main {
    public static void main(String[] args) {
        IReglasParchisFachada fachadaMock = new ReglasParchisMock();
        JuegoModel modelo = new JuegoModel(fachadaMock);
        TurnoController controlador = new TurnoController(modelo);

        TableroView vistaJugador1 = new TableroView(1, controlador);
        TableroView vistaJugador2 = new TableroView(2, controlador);

        modelo.agregarObservador(vistaJugador1);
        modelo.agregarObservador(vistaJugador2);

        vistaJugador1.setLocation(100, 200);
        vistaJugador2.setLocation(550, 200);

        vistaJugador1.actualizar(modelo);
        vistaJugador2.actualizar(modelo);

        vistaJugador1.setVisible(true);
        vistaJugador2.setVisible(true);
    }
}
