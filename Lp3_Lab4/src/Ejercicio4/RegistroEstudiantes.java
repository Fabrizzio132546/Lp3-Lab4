package Ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private List<Estudiante> estudiantes;

    public RegistroEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) {
        Estudiante nuevo = new Estudiante(nombre); 
        estudiantes.add(nuevo);
    }

    public Estudiante buscarEstudiante(String nombre) {
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equalsIgnoreCase(nombre.trim())) {
                return e;
            }
        }
        throw new NoSuchElementException("el estudiante '" + nombre + "' no esta registrado");
    }

    public List<Estudiante> obtenerEstudiantes() {
        return new ArrayList<>(estudiantes);
    }
}