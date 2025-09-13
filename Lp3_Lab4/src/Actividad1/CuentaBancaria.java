package Actividad1;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

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

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new IllegalArgumentException("el retiro debe ser mayor a 0");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("no tienes suficiente dinero para retirar " + monto);
        }
        saldo -= monto;
        System.out.println("retiro exitoso, tu saldo ahora es: " + saldo);
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
