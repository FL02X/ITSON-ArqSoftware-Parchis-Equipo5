package parchis;

public class TurnoController {
    private JuegoModel modelo;

    public TurnoController(JuegoModel modelo) {
        this.modelo = modelo;
    }

    public void ejercerTurno() {
        this.modelo.ejercerTurno();
    }
}
