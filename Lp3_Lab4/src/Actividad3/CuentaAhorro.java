package Actividad3;


public class CuentaAhorro extends CuentaBancaria {
    private double tasaInteres; 

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, titular, saldoInicial);
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa");
        }
        this.tasaInteres = tasaInteres;
    }

    public void aplicarInteres() {
        double interes = getSaldo() * tasaInteres;
        saldo += interes;
        System.out.println("Interés aplicado (" + (tasaInteres * 100) + "%): +" + interes 
                           + " | Saldo actual: " + saldo);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }
}
