package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class GestorCuatrimestres extends ModeloCuatrimestres{

    Scanner teclado = new Scanner(System.in);
    ArrayList<Cuatrimestres> cuatri = new ArrayList<>();

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
                        |  6.   Exit            |
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
                case "5"->
                    this.eliminar();
                case "6" ->
                    this.buscar();

            }

        } while (!"6".equals(op));

    }

    public void listar() {
        carteraCuatrimestres.clear();
        cuatri = index();
        int contador = 0;
        System.out.println("\n\tLISTADO DE CUATRIMESTRES 'contador'");
        System.out.println("+----+------------------+");
        System.out.printf("| %-2s | %-15s |\n", "NUM", "Cuatrimestre");
        System.out.println("+----+------------------+");
        for (Cuatrimestres temp : carteraCuatrimestres) {
            System.out.printf("| %-2d | %-16s |\n", contador++, temp.getNombre());
        }
        System.out.println("+----+------------------+");
    }

    public void crear() {
        carteraCuatrimestres.clear();
        System.out.println("\nINGRESA EL NOMBRE DEL NUEVO CUATRIMESTRE: ");
        String newcuatri = teclado.next();
        cuatri = create(newcuatri);
    }

    public void leer() {
        carteraCuatrimestres.clear();
        cuatri = read();
        System.out.println("\tCONSULTA DE CUATRIMESTRES CON 'ID'");
        System.out.println("\t+----+------------------+");
        System.out.printf("\t| %-2s | %-15s  |\n", "ID", "Cuatrimestre");
        System.out.println("\t+----+------------------+");

        for (Cuatrimestres temp : carteraCuatrimestres) {
            System.out.printf("\t| %-2d | %-16s |\n", temp.getId(), temp.getNombre());
        }
        System.out.println("\t+----+------------------+");
    }

    public void actualizar() throws InterruptedException {
        carteraCuatrimestres.clear();

        System.out.println("\nGESTOR PARA ACTUALIZAR CUATRIMESTRE");
        this.leer();
        System.out.println("\nIngresa el ID del cuatrimestre que deseas actualizar: ");
        int ide = teclado.nextInt();
        System.out.println("\nIngresa el nuevo nombre del cuatrimestre");
        String upcuatri = teclado.next();
        cuatri = update(ide, upcuatri);
    }

    public void eliminar() throws InterruptedException {
        carteraCuatrimestres.clear();
        System.out.println("\nGESTOR PARA ELIMINAR CUATRIMESTRES");
        this.leer();
        System.out.println("\n Ingresa el ID del cuatrimestre que deseas eliminar");
        int iddelete = teclado.nextInt();
        cuatri = delete(iddelete);
    }
    
    public void buscar(){
    carteraCuatrimestres.clear();
        System.out.println("\nGESTOR DE BUSQUEDA DE CUATRIMESTRES\n");
        
        System.out.println("Ingresa el cuatrimestre que deseas buscar: ");
        String cuatrib = teclado.next();
        cuatri = search(cuatrib);
    }
}
