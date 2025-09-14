package Ejercicio4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	
    	public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("**************************");
            System.out.println("menu registro de estudiantes");
            System.out.println("1. agregar estudiante");
            System.out.println("2. buscar estudiante");
            System.out.println("3. mostrar todos los estudiantes");
            System.out.println("4. salir");
            System.out.println("**************************");
            System.out.print("elige una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("ingresa el nombre del estudiante: ");
                        String nombre = sc.nextLine();
                        try {
                            registro.agregarEstudiante(nombre);
                            System.out.println("estudiante agregado correctamente");
                        } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
                        break;

                    case 2:
                        System.out.print("ingresa el nombre a buscar: ");
                        String buscar = sc.nextLine();
                        try {
                            Estudiante encontrado = registro.buscarEstudiante(buscar);
                            System.out.println("encontrado: " + encontrado);
                        } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
                        break;

                    case 3:
                        System.out.println("lista de estudiantes:");
                        if (registro.obtenerEstudiantes().isEmpty()) {
                            System.out.println("no hay estudiantes registrados");
                        } else {
                            for (Estudiante e : registro.obtenerEstudiantes()) {
                                System.out.println("- " + e);
                            }
                        }
                        break;

                    case 4:
                        System.out.println("saliendo del programa");
                        break;

                    default:
                        System.out.println("opcion no valida");
                }
            } catch (NumberFormatException e) { System.out.println("debes ingresar un numero valido"); }

        } while (opcion != 4);

        sc.close();
    }
}
