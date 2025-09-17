package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Numero n1 = null;
        boolean correcto = false;

        while (!correcto) {
            try {
                System.out.print("Ingresa un numero: ");
                double x = sc.nextDouble();
                n1 = new Numero(x);
                correcto = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: se debe poner un numero");
                sc.next();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                sc.next();
            }
        }
        n1.imprimir();

        sc.close();
    }
}
