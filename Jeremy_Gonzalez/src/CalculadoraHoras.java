import Recursos.MyScanner;

public class CalculadoraHoras {
    private static final MyScanner sc = new MyScanner();
    public static void main(String[] args) { //
        /*
        Empezamos poniendo una clase main en la que almacenamos el nombre del empleado dentro de un String llamado nombre
        Almacenamos la clase pedirHoras en horas poniendo un if en el caso de que este sea igual a -1 finalice el programa
        Denominamos el valor de tarifa
        Almacenamos la clase calcularSalario en salario introduciendo las horas y la tarifa
        Por ultimo mostramos el resumen con mostrarResumen introduciendo nombre, horas, tarifa y salario
        */
        System.out.println("===CALCULADORA DE HORAS LABORABLES===");

        String nombre = sc.pedirSoloTexto("Introduce el nombre del empleado:");
        double horas = pedirHoras();
        if (horas == -1) {
            System.out.println("Hora no introducida correctamente. Fin del programa");
            System.exit(0);
        }
        double tarifa = 7.5;

        double salario = calcularSalario(horas, tarifa);

        mostrarResumen(nombre, horas, tarifa, salario);
    }
    public static double pedirHoras() {
        /*
        En esta clase solicitamos el numero de horas trabajadas
        Empezamos inicializando los intentos en 0
        Ponemos un while para que mientras que intentos sea menor que 3 se pidan las horas la cual las almacenamos en horas
        Si la hora esta entre 0 y 70 se devuelve la hora
        En otro caso se imprime un mensaje sumandose un intento y dejando volver a introducir una hora hasta los 3 intentos
        En el caso de que se llegue a los 3 intentos las clase devuelve -1
         */

        int intentos = 0;
        while (intentos < 3) {
            double horas = sc.pedirDecimal("Introduce el numero de horas trabajadas esta semana:");
            if (horas >= 0 && horas <= 70) return horas;
            System.out.println("Introduce un numero de horas correctos (0 - 70)");
            intentos++;
        }
        return -1;
    }
    public static double calcularSalario(double horas, double tarifa) {
        /*
        En esta clase se calcula el salario
        Se multiplica la tarifa por las horas y se almacena en salario
        Se devuelve salario
         */
        double salario = tarifa * horas;
        return salario;
    }
    public static void mostrarResumen(String nombre, double horas, double tarifa, double salario) {
        /*
        En esta clase se muestra el resumen semanal
        Primero se imprime el nombre del empleado
        Luego el numero de horas trabajadas
        Luego la tarifa por hora del empleado
        Y por ultimo se muestra el salario total
         */
        System.out.println("===RESUMEN SEMANAL===");

        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Tarifa por hora: " + tarifa + "€");
        System.out.println("Salario total " + salario + "€");
    }
}
