package pkg2024ft22vfinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author aleja
 */
public class GestorCC extends ModeloCC {

    Scanner teclado = new Scanner(System.in);
    ArrayList<Ciclocuatri> cc = new ArrayList<>();
    GestorCiclos gciclos = new GestorCiclos();
    GestorCuatrimestres gcuatri = new GestorCuatrimestres();

    public static void main(String[] args) throws InterruptedException {

        GestorCC gcc = new GestorCC();
        gcc.menu();
    }

    public void menu() throws InterruptedException {
        String op;

        do {
            System.out.println("""
                    +****************************************+           
                               1. Index
                               2. Create
                               3. Read
                               4. Update
                               5. Delete
                               6. Ciclos administrator
                               7. Cuatri administrator
                               8. Exit
                    +****************************************+           
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
                    gciclos.menu();
                case "7" ->
                    gcuatri.menu();
            }

        } while (!"6".equals(op));
    }

    public void listar() {
        carteracc.clear();
        cc = index();
        int contador = 1;
        System.out.println("\t\n LISTADO DE RELACIONES CICLOS-CUATRIMESTRES\n");
        System.out.println("\t+-----------+----------------+");
        System.out.printf("\t| %-8s  | %-13s  |\n", "CICLO", "CUATRIMESTRE");
        System.out.println("\t+-----------+----------------+");
        for (Ciclocuatri temp : carteracc) {
            System.out.println(String.format("%d.\t| %-9s | %-14s |", contador, temp.getNombreciclo(), temp.getNombrecuatri()));
            contador++;
        }
        System.out.println("\t+-----------+----------------+");
    }

    public void crear() {
        carteracc.clear();
        System.out.println("\nGESTOR PARA CREAR RELACION CICLO-CUATRI");
        gciclos.leer();
        System.out.println("\nIngresa el ID del Ciclo que deseas relacionar:");
        int ciclorelacion = teclado.nextInt();
        gcuatri.leer();
        System.out.println("\nIngresa el ID del Cuatrimestre que deseas relacionar:");
        int cuatrirelacion = teclado.nextInt(ciclorelacion);
        cc = create(ciclorelacion, cuatrirelacion);
    }

    public void leer() {
        carteracc.clear();
        cc = read();
        System.out.println("\nCONSULTA DE RELACIONES CICLO-CUATRIMESTRE\n");

        System.out.println("+----+----------+-----------+----------+------------------+");
        System.out.printf("| %-2s | %-8s | %-9s | %-8s | %-16s |\n",
                "ID", "IDCiclo", "Ciclo", "IDCuatri", "Cuatrimestre");
        System.out.println("+----+----------+-----------+----------+------------------+");
        for (Ciclocuatri temp : carteracc) {
            System.out.printf("| %-2d | %-8d | %-9s | %-8d | %-16s |\n",
                    temp.getId(), temp.getIdciclo(), temp.getNombreciclo(), temp.getIdcuatri(), temp.getNombrecuatri());
        }
        System.out.println("+----+----------+-----------+----------+------------------+");
    }

    public void actualizar() throws InterruptedException {
        carteracc.clear();
        this.leer();

        System.out.println("\nIngresa el ID de la relacion que deseas actualizar: ");
        int ciclocuatri = teclado.nextInt();

        gciclos.leer();
        System.out.println("\nIngresa el ID del ciclo que deseas relacionar: ");
        int ciclo = teclado.nextInt();

        gcuatri.leer();
        System.out.println("\nIngresa el ID del cuatrimestre que deseas relacionar: ");
        int cuatri = teclado.nextInt();

        cc = update(ciclo, cuatri, ciclocuatri);

    }

    public void eliminar() {
        carteracc.clear();
        System.out.println("\nGESTOR PARA ELIMINAR RELACIONES CICLO-CUATRI\n");
        read();
        int id = teclado.nextInt();
        System.out.println("Ingresa el ID de la relacion que deseas eliminar");
        cc= delete(id);
        
    }
}
