package Ejercicio1;

public class Procesador {
    private LeerEntrada lector = new LeerEntrada();
 
    public void procesar() throws Exception {
        char c = lector.getChar();
 
        if ("aeiouAEIOU".indexOf(c) >= 0) {
            throw new ExcepcionVocal("se ingreso una vocal: " + c);
        } else if (Character.isDigit(c)) {
            throw new ExcepcionNumero("se ingreso un numero: " + c);
        } else if (Character.isWhitespace(c)) {
            throw new ExcepcionBlanco("se ingreso un espacio en blanco");
        } else if (c == 'x' || c == 'X') {
            throw new ExcepcionSalida("se ingreso caracter de salida: " + c);
        } else {
            System.out.println("caracter valido: " + c);
        }
    }
 
    public static void main(String[] args) {
        Procesador p = new Procesador();
        boolean seguir = true;
 
        System.out.println("ingrese caracteres (use 'x' o 'X' para salir):");
 
        while (seguir) {
            try {
                System.out.print("> "); // prompt para el usuario
                p.procesar();
            } catch (ExcepcionVocal e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionNumero e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionBlanco e) {
                System.out.println(e.getMessage());
            } catch (ExcepcionSalida e) {
                System.out.println(e.getMessage());
                seguir = false;
            } catch (Exception e) {
                System.out.println("error : " + e.getMessage());
            }
        }
    }
}
