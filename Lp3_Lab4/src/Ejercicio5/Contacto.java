package Ejercicio5;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("el nombre no puede estar vacio");
        if (telefono == null || telefono.trim().isEmpty()) throw new IllegalArgumentException("el telefono no puede estar vacio");
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("el email no puede estar vacio");

        this.nombre = nombre.trim();
        this.telefono = telefono.trim();
        this.email = email.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) throw new IllegalArgumentException("el telefono no puede estar vacio");
        this.telefono = telefono.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("el email no puede estar vacio");
        this.email = email.trim();
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", telefono: " + telefono + ", email: " + email;
    }
}
