package Ejercicio5;

public class Empresa {
    private String nombreEmpresa;
    private String sector;

    public Empresa(String nombreEmpresa, String sector) {
        if (nombreEmpresa == null || nombreEmpresa.trim().isEmpty()) throw new IllegalArgumentException("el nombre de la empresa no puede estar vacio");
        if (sector == null || sector.trim().isEmpty()) throw new IllegalArgumentException("el sector no puede estar vacio");

        this.nombreEmpresa = nombreEmpresa.trim();
        this.sector = sector.trim();
    }

    @Override
    public String toString() {
        return nombreEmpresa + " - " + sector;
    }
}
