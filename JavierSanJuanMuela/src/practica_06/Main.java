import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static void mostrarMenu() {
        System.out.print("1. Registrar videojuego\n" +
                "2. Mostrar inventario\n" +
                "3. Mostrar datos del videojuego por id\n" +
                "4. Guardar inventario en archivo\n" +
                "5. Cargar inventario desde archivo\n" +
                "6. Salir\n" +
                "Opción: ");
    }

    static void main(String[] args) {
        Inventario inventario = new Inventario();

        boolean bucle = true;

        while (bucle) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    String regex = "^[A-Z]{2}[0-9]{2}$";
                    if (id.matches(regex)) {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Plataforma (1 - PS4 | 2 - PC | 3 - XBOX | 4 - ANDROID): ");
                        Plataforma plataforma = null;
                        int opcionPlataforma = sc.nextInt();
                        sc.nextLine();
                        switch (opcionPlataforma) {
                            case 1:
                                plataforma = Plataforma.PS4;
                                break;
                            case 2:
                                plataforma = Plataforma.PC;
                                break;
                            case 3:
                                plataforma = Plataforma.XBOX;
                                break;
                            case 4:
                                plataforma = Plataforma.ANDROID;
                                break;
                            default:
                                System.out.print("Elije una plataforma válida!");
                                sc.nextLine();
                                break;
                        }
                        System.out.print("Precio: ");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        inventario.addVideogame(new Videojuego(id, titulo, plataforma, precio));
                    } else {
                        System.out.print("Pon un formato de ID correcto.");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    inventario.lookupInventory();
                    break;
                case 3:
                    System.out.print("ID?:");
                    String idSearch = sc.nextLine();
                    inventario.lookupInventoryId(idSearch);
                    break;
                case 4:
                    inventario.saveInventory();
                    break;
                case 5:
                    inventario.loadInventory();
                    break;
                case 6:
                    bucle = false;
                    break;
            }
        }
    }
}
