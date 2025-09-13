package Actividad3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CuentaBancaria> cuentas = new ArrayList<>();

        CuentaAhorro ahorro = new CuentaAhorro("12345", "Fabrizzio", 1000, 0.05);

        CuentaCredito credito = new CuentaCredito("54321", "Julio", 500, 1000);

        cuentas.add(ahorro);
        cuentas.add(credito);


        System.out.println("operaciones");
        try {
            ahorro.retirar(200);
            System.out.println("retiro 200 en cuenta ahorro saldo " + ahorro.getSaldo());

            ahorro.aplicarInteres();
            System.out.println("interes aplicado en cuenta ahorro saldo " + ahorro.getSaldo());

            credito.retirar(1200);
            System.out.println("retiro 1200 en cuenta credito saldo " + credito.getSaldo());

            credito.retirar(2000);
            System.out.println("retiro 2000 en cuenta credito saldo " + credito.getSaldo());

        } catch (SaldoInsuficienteException e) {
            System.out.println("error saldo insuficiente " + e.getMessage());
        } catch (LimiteCreditoExcedidoException e) {
            System.out.println("error limite de credito excedido " + e.getMessage());
        }

    }
}
