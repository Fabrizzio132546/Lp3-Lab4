package Ejercicio5;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorContactos gestor = new GestorContactos();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("**************************");
            System.out.println("menu gestor de contactos");
            System.out.println("1. agregar contacto");
            System.out.println("2. buscar contacto");
            System.out.println("3. modificar contacto");
            System.out.println("4. eliminar contacto");
            System.out.println("5. mostrar todos los contactos");
            System.out.println("6. salir");
            System.out.println("**************************");
            System.out.print("elige una opcion: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        try {
                            System.out.print("ingresa nombre: ");
                            String nombre = sc.nextLine();
                            System.out.print("ingresa telefono: ");
                            String telefono = sc.nextLine();
                            System.out.print("ingresa email: ");
                            String email = sc.nextLine();

                            gestor.agregarContacto(new Contacto(nombre, telefono, email));
                            System.out.println("contacto agregado correctamente");
                        } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
                        break;

                    case 2:
                        System.out.print("ingresa el nombre a buscar: ");
                        String buscar = sc.nextLine();
                        try {
                            Contacto encontrado = gestor.buscarContacto(buscar);
                            System.out.println("encontrado: " + encontrado);
                        } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
                        break;

                    case 3:
                        System.out.print("ingresa el nombre del contacto a modificar: ");
                        String nombreMod = sc.nextLine();
                        System.out.print("nuevo telefono: ");
                        String tel = sc.nextLine();
                        System.out.print("nuevo email: ");
                        String mail = sc.nextLine();
                        try {
                            gestor.modificarContacto(nombreMod, tel, mail);
                            System.out.println("contacto modificado correctamente");
                        } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
                        break;

                    case 4:
                        System.out.print("ingresa el nombre del contacto a eliminar: ");
                        String nombreElim = sc.nextLine();
                        try {
                            gestor.eliminarContacto(nombreElim);
                            System.out.println("contacto eliminado correctamente");
                        } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
                        break;

                    case 5:
                        System.out.println("lista de contactos:");
                        if (gestor.obtenerContactos().isEmpty()) {
                            System.out.println("no hay contactos registrados");
                        } else {
                            for (Contacto c : gestor.obtenerContactos()) {
                                System.out.println("- " + c);
                            }
                        }
                        break;

                    case 6:
                        System.out.println("saliendo del programa");
                        break;

                    default:
                        System.out.println("opcion no valida");
                }
            } catch (NumberFormatException e) { System.out.println("debes ingresar un numero valido"); }

        } while (opcion != 6);

        sc.close();
    }
}
