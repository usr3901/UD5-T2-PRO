package modelo;

public class Videojuego {

    private String nombre;
    private String genero;
    private String plataforma;
    private int puntuacion;

    public Videojuego(String nombre, String genero, String plataforma, int puntuacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.plataforma = plataforma;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {

        return "Nombre: " + nombre +
                "\nGénero: " + genero +
                "\nPlataforma: " + plataforma +
                "\nPuntuación: " + puntuacion + "/5";
    }
}