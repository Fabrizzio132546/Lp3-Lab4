package Ejercicio6;

public class TransaccionInmobiliaria {
    private int id;
    private Propiedad propiedad;
    private double precioTransaccion;

    public TransaccionInmobiliaria(int id, Propiedad propiedad, double precioTransaccion) throws PrecioInferiorException {
        if (precioTransaccion < propiedad.getPrecio()) { throw new PrecioInferiorException("el precio de la transaccion no puede ser menor al precio de la propiedad"); }
        this.id = id;
        this.propiedad = propiedad;
        this.precioTransaccion = precioTransaccion;
    }

    @Override
    public String toString() {
        return "transaccion id: " + id + ", propiedad: [" + propiedad + "], precio transaccion: " + precioTransaccion;
    }
}
