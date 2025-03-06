package pkg2024ft22vfinal;

import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int op;

        do {
            System.out.println("""
                               +-----------------------------------+
                               SISTEMA DE CONTROL ESCOLAR
                               +-----------------------------------+
                               1. Ciclo-Cuatrimestres
                               2. Grupos
                               3. Asignaciones
                               4. Alumnos
                               """);
            op = teclado.nextInt();

            switch (op) {
                case 1:

                    System.out.println("\t\tBIENVENIDO...");
                    GestorCC gcc = new GestorCC();
                    gcc.menu();
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
