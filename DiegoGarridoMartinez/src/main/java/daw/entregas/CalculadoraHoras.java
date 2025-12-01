package daw.entregas;

import recursos.MyScanner;

public class CalculadoraHoras {
    //Declaramos las variables//
    private static final int HORAS_MIN = 0;
    private static final int HORAS_MAX = 70;
    private static final int MAX_INTENTOS = 3;

    private static final MyScanner scanner = new MyScanner();

    //Introducimos el nombre del empleado//
    public static void main(String[] args) {
        System.out.println(" CALCULADORA DE HORAS LABORALES ");

        String nombre = scanner.pedirSoloTexto("Introduce el nombre del empleado: ");

        double tarifa = 7.5;

        double horas = pedirHoras();
        if (horas == -1) {
            System.out.println("Has superado el número máximo de intentos. Programa finalizado.");
            scanner.cerrar();
            return;

        }

        double salario = calcularSalario(horas, tarifa);


        mostrarResumen(nombre, horas, tarifa, salario);

        scanner.cerrar();
    }
    //Introducimos las horas trabajadas//
    public static double pedirHoras() {
        double horas = -1;
        int intentos = 0;

        while (intentos < MAX_INTENTOS) {
            horas = scanner.pedirDecimal("Introduce las horas trabajadas esta semana: ");
            if (horas >= HORAS_MIN && horas <= HORAS_MAX) {
                return horas;
            } else {
                System.out.println(" Valor no válido. Las horas deben estar entre " + HORAS_MIN + " y " + HORAS_MAX + ".");
                intentos++;
            }
        }
        return -1; // si supera los intentos
    }
    //Calculamos el salario
    public static double calcularSalario(double horas, double tarifa) {
        double salario = 0;

        if (horas <= 70) {
            salario = horas * tarifa;

        } else {
            System.out.println("Las horas deben estar entre " + HORAS_MIN + " y " + HORAS_MAX + ".");
        }
        return salario;
    }
    //Mostramos el resumen Semanal//
    public static void mostrarResumen(String nombre, double horas, double tarifa, double salario) {
        System.out.println(" RESUMEN SEMANAL ");
        System.out.println("Empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Tarifa por hora: " + tarifa + " €");
        System.out.printf("Salario total: %.2f €%n", salario);
    }
}
