package src;

public class CalculadoraHoras  {

    //private static igual para usarlo durante todo el codigo
    private static final MyScanner sc = new MyScanner();
    //Se pone private static para poder usarlo en todo el codigo
    final private static double salario = 7.5;

    public static void main(String[] args) {
        String nombre = sc.pedirSoloTexto("Introduzca el nombre del empleado:");
        double horas = pedirHoras();

        if (horas == -1) {
            System.out.println("ERROR");
        } else {
            mostrarResumen(nombre, horas, calcularSalario(horas));
        }
    }

    public static double pedirHoras() {
        int intentos = 0;
        boolean correcto;
        double horas;
        do {
            horas = sc.pedirDecimal("Introduzca las horas trabajadas:");
            try {
                if (horas <= 0 || horas >=70) {
                    throw new HorasException("Esta fuera del rango de horas");
                }
                correcto = true;
            } catch (HorasException e) {
                System.out.println(e.getMessage());
                correcto = false;
                intentos++;
                horas = -1;
            }

        } while (!correcto && intentos<3);
        return horas;
    }

    public static double calcularSalario(double horas) {
        return salario * horas;
    }

    public static void mostrarResumen(String nombre, double horas, double salario) {

        System.out.println("==== RESUMEN SEMANAL ====");
        System.out.println("Empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horas);
        System.out.println("Salario: " + calcularSalario(horas));

    }
}