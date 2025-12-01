package daw.entregas;

public class CalculadoraHoras {
    public static void main(String[] args) throws ExceptionHoras {
        MyScanner sc = new MyScanner();
        //Declaración de variables
        String nombreEmpleado = "";
        int horasTrabajadas = 0;
        double tarifa = 7.5;
        int intentos = 1;

        //Pedimos el nombre de usuario
        System.out.println("=== CALCULADORA DE HORAS LABORALES ===");
        nombreEmpleado = sc.pedirSoloTexto("Introduce el nombre del empleado: ");
        System.out.println();

        horasTrabajadas = pedirHoras();
        calcularSalario(horasTrabajadas, tarifa);
        mostrarResumen(nombreEmpleado, horasTrabajadas, tarifa, intentos);
    }

    //METODOS
    //Metodo que pide el nombre y el número de horas trabajadas al usuario
    public static int pedirHoras() {
        int horas = 0;
        int intentos = 1;
        String nombre = "";
        //Escáner
        final MyScanner sc = new MyScanner();

        //Declaración de variables
        intentos = 1;
        boolean salida;
        do {
            try {

                horas = sc.pedirNumero("Introduce las horas trabajadas esta semana: ");
                System.out.println();
                if (horas < 0 || horas > 70) {
                    throw new Exception("La hora no puede estar fuera del rango (0 - 70). Intento " + intentos + " de 3.");
                } else {
                    salida = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                intentos++;
                salida = false;
            }
        } while (!salida && intentos <= 3);
        return horas;

    }

    //Metodo que calcula el salario
    public static double calcularSalario(int horas, double tarifa) {
        double salarioFinal = horas * tarifa;
        return salarioFinal;
    }

    //Metodo que muestra el resumen
    public static void mostrarResumen(String nombre, int horasTrabajadas, double tarifa, int intentos) {
        if (intentos == 3) {
            System.out.println("FIN DEL PROGRAMA");
        } else {
            System.out.println("===== RESUMEN SEMANAL =====");
            System.out.println("Empleado: " + nombre);
            System.out.println("Horas trabajadas: " + horasTrabajadas);
            System.out.println("Tarifa por hora: " + tarifa + " €");
            System.out.println("Salario total: " + calcularSalario(horasTrabajadas, tarifa) + " €");
        }
    }
}
