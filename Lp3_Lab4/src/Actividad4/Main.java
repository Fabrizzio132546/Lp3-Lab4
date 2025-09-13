package Actividad4;

public class Main {
    public static void main(String[] args) {
        try {
            String numeroCuenta1 = ValidadorEntrada.validarNumeroCuenta("1234567890");
            String titular1 = ValidadorEntrada.validarNombre("Lizardo Castillo");
            double saldoInicial1 = ValidadorEntrada.validarMonto("1000");
            CuentaCredito cuentaCredito = new CuentaCredito(numeroCuenta1, titular1, saldoInicial1, 500);

            CuentaAhorro cuentaAhorro = new CuentaAhorro("0987654321", "Julio Juarez", 500, 0.05);

            System.out.println("cuentas creadas: \n");

            try {
                cuentaCredito.retirar(200);
                System.out.println("retiro de 200 hecho en cuenta credito\n");
            } catch (Exception e) {
                System.out.println("fallo retiro: " + e.getMessage());
            }

            try {
                cuentaCredito.retirar(2000);
                System.out.println("retiro de 2000 hecho, no deberia salir esto\n");
            } catch (Exception e) {
                System.out.println("fallo retiro: " + e.getMessage());
            }

            try {
                cuentaCredito.transferir(cuentaAhorro, 100);
                System.out.println("transferencia de 100 ok\n");
            } catch (Exception e) {
                System.out.println("fallo transferencia: " + e.getMessage());
            }

            try {
                cuentaCredito.transferir(null, 50);
                System.out.println("transferencia hecha no deberia salir esto\n");
            } catch (Exception e) {
                System.out.println("fallo transferencia: " + e.getMessage());
            }

            System.out.println("\n--- historial cuenta credito ---");
            for (String h : cuentaCredito.getHistorial()) {
                System.out.println(h);
            }

            System.out.println("\n--- historial cuenta ahorro ---");
            for (String h : cuentaAhorro.getHistorial()) {
                System.out.println(h);
            }
            
            System.out.println("\n--- aplicando interes en cuenta ahorro ---");
            try {
                cuentaAhorro.aplicarInteres();
                System.out.println("interes aplicado, saldo ahora: " + cuentaAhorro.getSaldo());
            } catch (Exception e) {
                System.out.println("fallo al aplicar interes: " + e.getMessage());
            }


            try {
                ReporteTransacciones.generarReporte(cuentaCredito, "reporte_credito.txt");
                ReporteTransacciones.generarReporte(cuentaAhorro, "reporte_ahorro.txt");
                System.out.println("\nreportes guardados en txt\n");
            } catch (Exception e) {
                System.out.println("fallo al guardar reporte: " + e.getMessage());
            }

            try {
                System.out.println("--- reporte cuenta credito ---");
                ReporteTransacciones.leerReporte("reporte_credito.txt");

                System.out.println("\n--- reporte cuenta ahorro ---");
                ReporteTransacciones.leerReporte("reporte_ahorro.txt");
            } catch (Exception e) {
                System.out.println("fallo al leer reporte: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("fallo al crear cuentas: " + e.getMessage());
        }
    }
}


