package Actividad4;

import java.time.LocalDateTime;

public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres; 

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, titular, saldoInicial);
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("la tasa de interes no puede ser negativa");
        }
        this.tasaInteres = tasaInteres;
    }

    public void aplicarInteres() {
        double interes = saldo * tasaInteres;
        saldo += interes;
        historial.add(LocalDateTime.now() + " interes aplicado " + interes + " saldo " + saldo);


        System.out.println("se aplico interes de " + (tasaInteres * 100) + " porciento saldo ahora " + saldo);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}
