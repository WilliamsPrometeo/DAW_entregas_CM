public class CalculadoraHoras {

    /*
    Declaramos las constatntes.
    */
    private static final double TARIFAMIN = 7.5;
    private static final int MAXINTENTOS = 3;
    private static final int MINHORAS = 0;
    private static final int MAXHORAS = 70;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        /*
        Pedimos los datos para empezar el programa.
        */
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();


        int horasTrabajadas = pedirHoras(scanner);

        if (horasTrabajadas == -1) {
            System.out.println("Error: Número de intentos excedido. Programa finalizado.");
            return;
        }


        double tarifa = TARIFAMIN;

        // 4. Calcular salario
        double salario = calcularSalario(horasTrabajadas, tarifa);


        mostrarResumen(nombre, horasTrabajadas, tarifa, salario);
    }

    /*
    Validamos el numero de intentos y el numero de horas.
    */
    public static int pedirHoras(MyScanner scanner) {
        int intentos = 0;
        while (intentos < MAXINTENTOS) {
            System.out.println("Ingrese las horas trabajadas esta semana: ");
            try {
                int horas = Integer.parseInt(scanner.nextLine());
                if (horas >= MINHORAS && horas <= MAXHORAS) {
                    return horas;
                } else {
                    System.out.println("Error: Las horas deben estar entre 0 y 70.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
            intentos++;
        }
        return -1;
    }

    /*
    Calcula el total del salario
    */
    public static double calcularSalario(int horas, double tarifa) {
        return horas * tarifa;
    }


    public static void mostrarResumen(String nombre, int horas, double tarifa, double salario) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Tarifa por hora: " + tarifa);
        System.out.println("Salario total: " + salario);
    }
}

