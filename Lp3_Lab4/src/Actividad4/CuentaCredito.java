package Actividad4;

import java.time.LocalDateTime;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        if (limiteCredito < 0) {
            throw new IllegalArgumentException("el limite de credito no puede ser negativo");
        }
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto)
            throws SaldoInsuficienteException, LimiteCreditoExcedidoException, LimiteDiarioExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("el retiro debe ser mayor a 0");
        }
        if (acumuladoRetiros + monto > LIMITE_DIARIO) {
            throw new LimiteDiarioExcedidoException("limite diario excedido");
        }
        if (monto > saldo + limiteCredito) {
            throw new LimiteCreditoExcedidoException("no puedes exceder tu limite de credito " + limiteCredito);
        }

        saldo -= monto;
        acumuladoRetiros += monto;
        historial.add(LocalDateTime.now() + " retiro " + monto + " saldo " + saldo);


        if (saldo < SALDO_MINIMO) {
            System.out.println("alerta saldo minimo alcanzado");
        }
    }

    @Override
    public void transferir(CuentaBancaria destino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteCreditoExcedidoException,
                   LimiteDiarioExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("la cuenta destino no existe");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("el monto de transferencia debe ser mayor a 0");
        }
        if (acumuladoRetiros + monto > LIMITE_DIARIO) {
            throw new LimiteDiarioExcedidoException("limite diario excedido");
        }
        if (monto > saldo + limiteCredito) {
            throw new LimiteCreditoExcedidoException("no puedes exceder tu limite de credito " + limiteCredito);
        }

        saldo -= monto;
        acumuladoRetiros += monto;
        destino.depositar(monto);
        historial.add(LocalDateTime.now() + " transferencia enviada " + monto + " a cuenta " + destino.getNumeroCuenta());
        destino.historial.add(LocalDateTime.now() + " transferencia recibida " + monto + " de cuenta " + this.getNumeroCuenta());


        if (saldo < SALDO_MINIMO) {
            System.out.println("alerta saldo minimo alcanzado");
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
