package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class GestorMaterias extends ModeloMaterias {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Materias> mate = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        GestorMaterias gm = new GestorMaterias();
        gm.menu();
    }

    public void menu() throws InterruptedException {
        String op;
        do {
            System.out.println("\n\n\tMATERIAS\n\n");
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
                case "6" ->
                    this.buscar();

            }
        } while (!"7".equals(op));

    }

    private void listar() {
        carteraMaterias.clear();
        mate = index();
        int contador = 0;
        System.out.println("\n\tLISTADO DE MATERIAS 'contador'\n");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s |\n", "NUM", "Materia");
        System.out.println("\t+----+------------------+");
        for (Materias temp : carteraMaterias) {
            System.out.printf("\t| %-2d | %-16s |\n", contador++, temp.getNombre());
        }
        System.out.println("\t+----+------------------+");

    }

    private void crear() {

        carteraMaterias.clear();
        System.out.println("\nINGRESA EL NOMBRE DE LA CARRERA: ");
        String newmateria = teclado.next();
        mate = create(newmateria);
    }

    private void leer() {
        carteraMaterias.clear();
        mate = read();
        System.out.println("\tCONSULTA DE MATERIAS CON 'ID'");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s  |\n", "ID", "Materias");
        System.out.println("\t+----+------------------+");

        for (Materias temp : carteraMaterias) {
            System.out.printf("\t| %-2d | %-16s |\n", temp.getId(), temp.getNombre());
        }
        System.out.println("\t+----+------------------+");
    }

    private void actualizar() throws InterruptedException {
        carteraMaterias.clear();
        System.out.println("\nGESTOR PARA ACTUALIZAR MATERIAS");
        this.leer();
        System.out.println("\nIngresa el ID de la materia que deseas actualizar: ");
        int ide = teclado.nextInt();
        System.out.println("\nIngresa el nuevo nombre de la materia");
        String upmateria = teclado.next();
        mate = update(ide, upmateria);
    }

    private void eliminar() throws InterruptedException {
        carteraMaterias.clear();
        System.out.println("\nGESTOR PARA ELIMINAR MATERIAS");
        this.leer();
        System.out.println("\n Ingresa el ID de la materia que deseas eliminar");
        int iddelete = teclado.nextInt();
        mate = delete(iddelete);
    }

    private void buscar() {
        carteraMaterias.clear();
        System.out.println("\nGESTOR DE BUSQUEDA DE MATERIAS\n");

        System.out.println("Ingresa la materia que deseas buscar: ");
        String materiab = teclado.next();
        mate = search(materiab);
    }
}
