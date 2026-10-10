package parchis;

public class Jugador {
    private int id;
    private String nombre;
    private String color;
    private int casillaActual;

    public Jugador(int id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
        this.casillaActual = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }
}
