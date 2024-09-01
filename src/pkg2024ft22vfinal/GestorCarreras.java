package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class GestorCarreras extends ModeloCarreras {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Carreras> carreras = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        GestorCarreras gcarreras = new GestorCarreras();
        gcarreras.menu();
    }

    public void menu() throws InterruptedException {
        String op;
        do {
            System.out.println("\n\n\tCARRERAS\n\n");
            System.out.println("""
                        +----+------------------+   
                        |  1.   Index           |
                        |  2.   Create          |
                        |  3.   Read            |
                        |  4.   Update          |
                        |  5.   Delete          |
                        |  6.   Search          |
                        |  7.   Exit            |
                        +----+------------------+ 
                               \n
                           """);

            op = teclado.next();

            switch (op) {
                case "1" ->
                    this.listar();
                case "2" ->
                    this.crear();
                case "3" ->
                    this.leer();
                case "4" ->
                    this.actualizar();
                case "5" ->
                    this.eliminar();
                case "6"->
                    this.buscar();

            }

        } while (!"7".equals(op));
    }

    private void listar() {
        carteraCarreras.clear();
        carreras = index();
        int contador = 0;
        System.out.println("\n\tLISTADO DE CARRERAS 'contador'\n");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s |\n", "NUM", "Carrera");
        System.out.println("\t+----+------------------+");
        for (Carreras temp : carteraCarreras) {
            System.out.printf("\t| %-2d | %-16s |\n", contador++, temp.getNombre());
        }
        System.out.println("\t+----+------------------+");

    }

    private void crear() {
        carteraCarreras.clear();
        System.out.println("\nINGRESA EL NOMBRE DE LA CARRERA: ");
        String newcarrera = teclado.next();
        carreras = create(newcarrera);
    }

    private void leer() {
        carteraCarreras.clear();
        carreras = read();
        System.out.println("\tCONSULTA DE CARRERAS CON 'ID'");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s  |\n", "ID", "Carreras");
        System.out.println("\t+----+------------------+");

        for (Carreras temp : carteraCarreras) {
            System.out.printf("\t| %-2d | %-16s |\n", temp.getId(), temp.getNombre());
        }
        System.out.println("\t+----+------------------+");
    }

    private void actualizar() throws InterruptedException {
        carteraCarreras.clear();
        System.out.println("\nGESTOR PARA ACTUALIZAR CARRERAS");
        this.leer();
        System.out.println("\nIngresa el ID de la carrera que deseas actualizar: ");
        int ide = teclado.nextInt();
        System.out.println("\nIngresa el nuevo nombre de la carrera");
        String upcarrera = teclado.next();
        carreras = update(ide, upcarrera);
    }

    private void eliminar() throws InterruptedException {
        carteraCarreras.clear();
        System.out.println("\nGESTOR PARA ELIMINAR CARRERAS");
        this.leer();
        System.out.println("\n Ingresa el ID de la carrera que deseas eliminar");
        int iddelete = teclado.nextInt();
        carreras = delete(iddelete);
    }

    public void buscar() {
        carteraCarreras.clear();
        System.out.println("\nGESTOR DE BUSQUEDA DE CARRERAS\n");

        System.out.println("Ingresa la carrera que deseas buscar: ");
        String cuatrib = teclado.next();
        carreras = search(cuatrib);
    }
}
