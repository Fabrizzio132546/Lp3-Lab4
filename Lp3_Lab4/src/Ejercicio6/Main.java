package Ejercicio6;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**********");
        System.out.println("sistema de propiedades");
        System.out.println("**********");

        try {
            System.out.print("ingrese direccion: ");
            String direccion = sc.nextLine();
            System.out.print("ingrese precio de la propiedad: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.print("ingrese tamano de la propiedad: ");
            double tamano = Double.parseDouble(sc.nextLine());

            Propiedad propiedad = new Propiedad(direccion, precio, tamano);
            System.out.println("propiedad registrada: " + propiedad);

            System.out.print("ingrese id de la transaccion: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("ingrese precio de la transaccion: ");
            double precioTransaccion = Double.parseDouble(sc.nextLine());

            TransaccionInmobiliaria transaccion = new TransaccionInmobiliaria(id, propiedad, precioTransaccion);
            System.out.println("transaccion registrada: " + transaccion);

            System.out.print("ingrese duracion del contrato en meses: ");
            int meses = Integer.parseInt(sc.nextLine());
            System.out.print("ingrese monto del alquiler: ");
            double montoAlquiler = Double.parseDouble(sc.nextLine());

            ContratoAlquiler contrato = new ContratoAlquiler(meses, montoAlquiler);
            System.out.println("contrato registrado: " + contrato);

            System.out.print("ingrese monto de pago: ");
            double montoPago = Double.parseDouble(sc.nextLine());
            HistorialDePagos pago = new HistorialDePagos(LocalDate.now(), montoPago);
            System.out.println("pago registrado: " + pago);

        } catch (DatosInvalidosException e) { System.out.println(e.getMessage()); }
        catch (PrecioInferiorException e) { System.out.println(e.getMessage()); }
        catch (ContratoInvalidoException e) { System.out.println(e.getMessage()); }
        catch (PagoInvalidoException e) { System.out.println(e.getMessage()); }
        catch (NumberFormatException e) { System.out.println("error: formato de numero invalido"); }
        finally { sc.close(); }
    }
}
