package Ejercicio6;

public class Propiedad {
    private String direccion;
    private double precio;
    private double tamano;

    public Propiedad(String direccion, double precio, double tamano) throws DatosInvalidosException {
        if (precio <= 0) { throw new DatosInvalidosException("el precio debe ser positivo"); }
        if (tamano <= 0) { throw new DatosInvalidosException("el tamano debe ser positivo"); }
        this.direccion = direccion;
        this.precio = precio;
        this.tamano = tamano;
    }

    public String getDireccion() { return direccion; }
    public double getPrecio() { return precio; }
    public double getTamano() { return tamano; }

    @Override
    public String toString() {
        return "direccion: " + direccion + ", precio: " + precio + ", tamano: " + tamano;
    }
}
