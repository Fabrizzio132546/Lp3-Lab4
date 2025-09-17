package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
 
        try {
            System.out.println("Suma: " + calc.sumar(10, 5));
            System.out.println("Resta: " + calc.restar(10, 5));
            System.out.println("Multiplicacion: " + calc.multiplicar(10, 5));
            System.out.println("Division: " + calc.dividir(10, 0));
        } catch (DivisionPorCeroException e) {
            System.out.println("Error personalizado: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmetico: " + e.getMessage());
        }
    }
}
