package Actividad2;

public class Main {
    public static void main(String[] args) {
        try {

            CuentaBancaria cuenta1 = new CuentaBancaria("1234567890", "Fabrizzio Ochoa", 1000);
            CuentaBancaria cuenta2 = new CuentaBancaria("0987654321", "Julio Juarez", 500);
            System.out.println("Cuentas creadas con exito\n");


            cuenta1.depositar(200);

            try {
                cuenta1.retirar(300);
            } catch (SaldoInsuficienteException e) {
                System.out.println("Error en retiro: " + e.getMessage());
            }
            try {
                cuenta1.retirar(2000);
            } catch (Exception e) {
                System.out.println("Error en retiro: " + e.getMessage());
            }
            try {
                cuenta1.transferir(cuenta2, 400);
            } catch (Exception e) {
                System.out.println("Error en transferencia: " + e.getMessage());
            }
            try {
                cuenta1.transferir(null, 100);
            } catch (Exception e) {
                System.out.println("Error en transferencia: " + e.getMessage());
            }
            try {
                cuenta1.cerrarCuenta();
            } catch (SaldoNoCeroException e) {
                System.out.println("Error al cerrar cuenta: " + e.getMessage());
            }
            try {
                cuenta2.retirar(cuenta2.getSaldo());
                cuenta2.cerrarCuenta();
            } catch (Exception e) {
                System.out.println("Error al cerrar cuenta: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al crear cuentas: " + e.getMessage());
        }
    }
}
