package parchis;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroView extends JFrame implements ObservadorJuego {
    private int idJugadorPropietario;
    private TurnoController controlador;

    private JLabel lblTitulo;
    private JLabel lblEstadoTurno;
    private JLabel lblUltimoDado;
    private JLabel lblInfoJugador1;
    private JLabel lblInfoJugador2;
    private JButton btnEjercerTurno;

    public TableroView(int idJugadorPropietario, TurnoController controlador) {
        this.idJugadorPropietario = idJugadorPropietario;
        this.controlador = controlador;

        setTitle("Parchis - Ventana Jugador " + idJugadorPropietario);
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelCentro = new JPanel(new GridLayout(5, 1));
        this.lblTitulo = new JLabel("VISTA DEL JUGADOR " + idJugadorPropietario, JLabel.CENTER);
        this.lblEstadoTurno = new JLabel("Estado: Iniciando...", JLabel.CENTER);
        this.lblUltimoDado = new JLabel("Ultimo Dado: -", JLabel.CENTER);
        this.lblInfoJugador1 = new JLabel("Jugador 1: Casilla 0", JLabel.CENTER);
        this.lblInfoJugador2 = new JLabel("Jugador 2: Casilla 0", JLabel.CENTER);

        panelCentro.add(this.lblTitulo);
        panelCentro.add(this.lblEstadoTurno);
        panelCentro.add(this.lblUltimoDado);
        panelCentro.add(this.lblInfoJugador1);
        panelCentro.add(this.lblInfoJugador2);

        this.btnEjercerTurno = new JButton("Lanzar Dado y Mover");
        this.btnEjercerTurno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.ejercerTurno();
            }
        });

        add(panelCentro, BorderLayout.CENTER);
        add(this.btnEjercerTurno, BorderLayout.SOUTH);
    }

    public void actualizar(JuegoModel modelo) {
        Jugador j1 = modelo.getJugadores().get(0);
        Jugador j2 = modelo.getJugadores().get(1);

        this.lblInfoJugador1.setText("Jugador 1 (" + j1.getColor() + "): Casilla " + j1.getCasillaActual());
        this.lblInfoJugador2.setText("Jugador 2 (" + j2.getColor() + "): Casilla " + j2.getCasillaActual());

        if (modelo.getUltimoDado() > 0) {
            this.lblUltimoDado.setText("Ultimo Dado: " + modelo.getUltimoDado() + " (" + modelo.getMensajeEstado() + ")");
        }

        Jugador enTurno = modelo.getJugadorActual();
        if (enTurno.getId() == this.idJugadorPropietario) {
            this.lblEstadoTurno.setText(">>> ES TU TURNO DE JUGAR <<<");
            this.btnEjercerTurno.setEnabled(true);
        } else {
            this.lblEstadoTurno.setText("Esperando el turno de " + enTurno.getNombre() + "...");
            this.btnEjercerTurno.setEnabled(false);
        }
    }
}
