package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class GestorCiclos extends ModeloCiclos {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Ciclos> c = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        GestorCiclos gc = new GestorCiclos();
        gc.menu();
    }

    public void menu() throws InterruptedException {
        String op;
        do {
            System.out.println("""
                           \n
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

            }

        } while (!"7".equals(op));

    }

    public void listar() {
        carteraCiclos.clear();
        c = index();
        int contador = 0;
        System.out.println("\n\tLISTADO DE CICLOS 'contador'");
        System.out.println("+----+------------------+");
        System.out.printf("| %-2s | %-15s |\n", "NUM", "Ciclo");
        System.out.println("+----+------------------+");
        for (Ciclos temp : carteraCiclos) {
            System.out.printf("| %-2d | %-16s |\n", contador++, temp.getNombre());
        }
        System.out.println("+----+------------------+");
    }

    public void crear() {
        carteraCiclos.clear();
        System.out.println("\nINGRESA EL NOMBRE DEL NUEVO CICLO: ");
        String newciclo = teclado.next();
        c = create(newciclo);
    }

    public void leer() {
        carteraCiclos.clear();
        c = read();
        System.out.println("\tCONSULTA DE CICLOS CON 'ID'");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s  |\n", "ID", "Ciclo");
        System.out.println("\t+----+------------------+");

        for (Ciclos temp : carteraCiclos) {
            System.out.printf("\t| %-2d | %-16s |\n", temp.getId(), temp.getNombre());
        }
        System.out.println("\t+----+------------------+");
    }

    public void actualizar() throws InterruptedException {
        carteraCiclos.clear();

        System.out.println("\nGESTOR PARA ACTUALIZAR CICLOS");
        this.leer();
        System.out.println("\nIngresa el ID del ciclo que deseas actualizar: ");
        int ide = teclado.nextInt();
        System.out.println("\nIngresa el nuevo nombre del ciclo");
        String upciclo = teclado.next();
        c = update(ide, upciclo);
    }

    public void eliminar() throws InterruptedException {
        carteraCiclos.clear();
        System.out.println("\nGESTOR PARA ELIMINAR CICLOS");
        this.leer();
        System.out.println("\n Ingresa el ID del ciclo que deseas eliminar");
        int iddelete = teclado.nextInt();
        c = delete(iddelete);
    }
    
        public void buscar() {
        carteraCiclos.clear();
        System.out.println("\nGESTOR DE BUSQUEDA DE CICLOS\n");

        System.out.println("Ingresa el ciclo que deseas buscar: ");
        String ciclob = teclado.next();
        c = search(ciclob);
    }
}
