package Actividad1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("creando una cuenta de prueba");
            CuentaBancaria cuenta1 = new CuentaBancaria("100", "Fabrizzio", 1657);

            System.out.println("intentando depositar un monto negativo");
            try {
                cuenta1.depositar(-50);
            } catch (IllegalArgumentException e) {
                System.out.println("error: " + e.getMessage());
            }

            System.out.println("intentando retirar mas de lo que hay en la cuenta");
            try {
                cuenta1.retirar(200);
            } catch (SaldoInsuficienteException e) {
                System.out.println("error: " + e.getMessage());
            }

            System.out.println("haciendo un deposito correcto de 50");
            cuenta1.depositar(50);

            System.out.println("haciendo un retiro correcto de 30");
            cuenta1.retirar(30);

            System.out.println("saldo final de la cuenta: " + cuenta1.getSaldo());

            System.out.println("intentando crear cuenta con saldo negativo...");
            try {
                CuentaBancaria cuenta2 = new CuentaBancaria("002", "maria", -100);
            } catch (IllegalArgumentException e) {
                System.out.println("error: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("ocurrio un error inesperado: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("fin de la prueba");
        }
    }
}
