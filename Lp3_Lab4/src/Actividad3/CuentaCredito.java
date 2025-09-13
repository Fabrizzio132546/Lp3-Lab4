package Actividad3;

public class CuentaCredito extends CuentaBancaria {
    private double limiteCredito;

    public CuentaCredito(String numeroCuenta, String titular, double saldoInicial, double limiteCredito) {
        super(numeroCuenta, titular, saldoInicial);
        if (limiteCredito < 0) {
            throw new IllegalArgumentException("El límite de crédito no puede ser negativo");
        }
        this.limiteCredito = limiteCredito;
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (monto <= 0) {
            throw new IllegalArgumentException("El retiro debe ser mayor a 0");
        }
        if (getSaldo() - monto < -limiteCredito) {
            throw new LimiteCreditoExcedidoException("No puedes exceder tu límite de crédito: " + limiteCredito);
        }

        saldo -= monto;
        System.out.println("Retiro exitoso en cuenta de crédito, tu saldo ahora es: " + saldo);
    }

    @Override
    public void transferir(CuentaBancaria destino, double monto)
            throws CuentaNoEncontradaException, SaldoInsuficienteException, LimiteCreditoExcedidoException {
        if (destino == null) {
            throw new CuentaNoEncontradaException("La cuenta destino no existe");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto de transferencia debe ser mayor a 0");
        }
        if (getSaldo() - monto < -limiteCredito) {
            throw new LimiteCreditoExcedidoException("No puedes exceder tu límite de crédito: " + limiteCredito);
        }
        saldo -= monto;
        destino.depositar(monto);
        System.out.println("Transferencia realizada de " + monto + " a la cuenta " + destino.getNumeroCuenta());
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }
}
