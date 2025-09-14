package Ejercicio4;

public class Estudiante {
    private String nombre;

    public Estudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre del estudiante no puede ser nulo o vacio");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "estudiante: " + nombre;
    }
}
