package Actividad4;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReporteTransacciones {
    public static void generarReporte(CuentaBancaria cuenta, String archivo)
            throws IOException, HistorialVacioException {
        if (cuenta.getHistorial().isEmpty()) {
            throw new HistorialVacioException("no hay transacciones para la cuenta");
        }
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("numero cuenta " + cuenta.getNumeroCuenta() + "\n");
            writer.write("titular " + cuenta.getTitular() + "\n");
            writer.write("saldo " + cuenta.getSaldo() + "\n");
            writer.write("historial:\n");
            for (String t : cuenta.getHistorial()) {
                writer.write(t + "\n");
            }
        }
    }

    public static void leerReporte(String archivo) throws IOException {
        File file = new File(archivo);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
