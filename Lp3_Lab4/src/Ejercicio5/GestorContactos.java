package Ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GestorContactos {
    private List<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto c) {
        if (c == null) throw new IllegalArgumentException("el contacto no puede ser nulo");
        contactos.add(c);
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                return c;
            }
        }
        throw new NoSuchElementException("el contacto '" + nombre + "' no existe");
    }

    public void modificarContacto(String nombre, String nuevoTelefono, String nuevoEmail) {
        Contacto c = buscarContacto(nombre);
        if (nuevoTelefono != null && !nuevoTelefono.trim().isEmpty()) c.setTelefono(nuevoTelefono);
        if (nuevoEmail != null && !nuevoEmail.trim().isEmpty()) c.setEmail(nuevoEmail);
    }

    public void eliminarContacto(String nombre) {
        Contacto c = buscarContacto(nombre);
        contactos.remove(c);
    }

    public List<Contacto> obtenerContactos() {
        return new ArrayList<>(contactos);
    }
}
