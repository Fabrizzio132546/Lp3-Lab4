package Ejercicio6;

import java.time.LocalDate;

public class HistorialDePagos {
    private LocalDate fecha;
    private double monto;

    public HistorialDePagos(LocalDate fecha, double monto) throws PagoInvalidoException {
        if (fecha.isAfter(LocalDate.now())) { throw new PagoInvalidoException("la fecha de pago no puede ser futura"); }
        if (monto <= 0) { throw new PagoInvalidoException("el monto de pago debe ser positivo"); }
        this.fecha = fecha;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "pago realizado el " + fecha + " por " + monto;
    }
}
