package Ejercicio6;

public class ContratoAlquiler {
    private int duracionMeses;
    private double montoAlquiler;

    public ContratoAlquiler(int duracionMeses, double montoAlquiler) throws ContratoInvalidoException {
        if (duracionMeses <= 0) { 
        	throw new ContratoInvalidoException("la duracion del contrato debe ser positiva"); }
        if (montoAlquiler <= 0) { 
        	throw new ContratoInvalidoException("el monto del alquiler debe ser positivo"); }
        this.duracionMeses = duracionMeses;
        this.montoAlquiler = montoAlquiler;
    }

    @Override
    public String toString() {
        return "contrato alquiler: duracion " + duracionMeses + " meses, monto " + montoAlquiler;
    }
}
