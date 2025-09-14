package Ejercicio5;

public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;

    public Direccion(String calle, String ciudad, String codigoPostal) {
        if (calle == null || calle.trim().isEmpty()) throw new IllegalArgumentException("la calle no puede estar vacia");
        if (ciudad == null || ciudad.trim().isEmpty()) throw new IllegalArgumentException("la ciudad no puede estar vacia");
        if (codigoPostal == null || codigoPostal.trim().isEmpty()) throw new IllegalArgumentException("el codigo postal no puede estar vacio");

        this.calle = calle.trim();
        this.ciudad = ciudad.trim();
        this.codigoPostal = codigoPostal.trim();
    }

    @Override
    public String toString() {
        return calle + ", " + ciudad + " (" + codigoPostal + ")";
    }
}
