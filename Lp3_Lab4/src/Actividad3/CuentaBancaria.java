package Actividad3;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    double saldo; 

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("no se puede crear cuenta con saldo negativo");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("el deposito tiene que ser mayor a 0");
        }
        saldo += monto;
        System.out.println("deposito exitoso, tu saldo ahora es: " + saldo);
    }
    

    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("el retiro debe ser mayor a 0");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("no tienes suficiente dinero para retirar " + monto);
        }
        saldo -= monto;
        System.out.println("retiro exitoso, tu saldo ahora es: " + saldo);
    }

    public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("la cuenta destino no existe");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("el monto de transferencia debe ser mayor a 0");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("saldo insuficiente para transferir " + monto);
        }
        this.saldo -= monto;
        destino.saldo += monto;
        System.out.println("transferencia realizada de " + monto + " a la cuenta " + destino.getNumeroCuenta());
    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) {
            throw new SaldoNoCeroException("no se puede cerrar la cuenta porque aun tienes saldo");
        }
        System.out.println("la cuenta " + numeroCuenta + " ha sido cerrada con exito");
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }
}
