package Actividad3;

public class SaldoNoCeroException extends Exception {
    public SaldoNoCeroException(String mensaje) {
        super(mensaje);
    }
}