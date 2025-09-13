package Actividad4;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private boolean primerDeposito = true;
    protected double acumuladoRetiros = 0;
    protected static final double LIMITE_DIARIO = 2000;
    protected static final double SALDO_MINIMO = 100;

    protected List<String> historial = new ArrayList<>();

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
            throw new IllegalArgumentException("el deposito debe ser mayor a 0");
        }
        saldo += monto;
        historial.add(LocalDateTime.now() + " deposito " + monto + " saldo " + saldo);
        
        if (primerDeposito && monto > 500) {
            saldo += 20;
            historial.add("bono por primer deposito saldo " + saldo);
            System.out.println("bono aplicado por primer deposito");
        }
        primerDeposito = false;
    }

    public void retirar(double monto) throws SaldoInsuficienteException, LimiteDiarioExcedidoException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("el retiro debe ser mayor a 0");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("no tienes suficiente saldo");
        }
        if (acumuladoRetiros + monto > LIMITE_DIARIO) {
            throw new LimiteDiarioExcedidoException("limite diario de retiros excedido");
        }
        saldo -= monto;
        acumuladoRetiros += monto;
        historial.add(LocalDateTime.now() + " retiro " + monto + " saldo " + saldo);

        if (saldo < SALDO_MINIMO) {
            System.out.println("alerta saldo minimo alcanzado");
        }
    }

    public void transferir(CuentaBancaria destino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteDiarioExcedidoException, LimiteCreditoExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("la cuenta destino no existe");
        }
        this.retirar(monto);
        destino.depositar(monto);
        historial.add(LocalDateTime.now() + " transferencia enviada " + monto + " a cuenta " + destino.getNumeroCuenta());
        destino.historial.add(LocalDateTime.now() + " transferencia recibida " + monto + " de cuenta " + this.numeroCuenta);

    }

    public void cerrarCuenta() throws SaldoNoCeroException {
        if (saldo != 0) {
            throw new SaldoNoCeroException("no se puede cerrar la cuenta con saldo distinto de cero");
        }
        historial.add("cuenta cerrada");
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public List<String> getHistorial() {
        return historial;
    }

    @Override
    public String toString() {
        return "cuenta " + numeroCuenta + " titular " + titular + " saldo " + saldo;
    }
    
    public void resetAcumuladoRetiros() {
        acumuladoRetiros = 0;
    }
}
