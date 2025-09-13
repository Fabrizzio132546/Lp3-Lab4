package Actividad4;

public class ValidadorEntrada {

    public static String validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("el nombre no puede estar vacio");
        }
        if (nombre.startsWith(" ") || nombre.endsWith(" ")) {
            throw new IllegalArgumentException("el nombre no puede empezar o terminar con espacio");
        }
        if (nombre.contains("  ")) {
            throw new IllegalArgumentException("el nombre no puede tener espacios dobles");
        }
        if (!nombre.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("el nombre solo puede contener letras y un espacio entre ellas");
        }
        return nombre;
    }

    public static String validarNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("el numero de cuenta no puede estar vacio");
        }
        if (!numeroCuenta.matches("\\d+")) {
            throw new IllegalArgumentException("el numero de cuenta solo puede contener digitos");
        }
        if (numeroCuenta.length() != 10) {
            throw new IllegalArgumentException("el numero de cuenta debe tener exactamente 10 digitos");
        }
        return numeroCuenta;
    }

    public static double validarMonto(String montoTexto) {
        try {
            double monto = Double.parseDouble(montoTexto);
            if (monto <= 0) {
                throw new IllegalArgumentException("el monto debe ser mayor que cero");
            }
            return monto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("el monto debe ser un numero valido");
        }
    }
}
