package Actividad4;

public class LimiteCreditoExcedidoException extends Exception {
    public LimiteCreditoExcedidoException(String mensaje) {
        super(mensaje);
    }
}