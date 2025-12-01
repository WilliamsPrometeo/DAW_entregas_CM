import exceptions.InputNumException;
import recursos.MyScanner;

public class CalculadoraHoras {

    private static void mostrarResumen(double salario, String empleado, int horasTrabajadas, double tarifaHora) {
        System.out.printf("%n===== RESUMEN SEMANAL =====");
        System.out.printf("%nEmpleado: %s", empleado);
        System.out.printf("%nSalario: %.2f€", salario);
        System.out.printf("%nHoras Trabajadas: %sh", horasTrabajadas);
        System.out.printf("%nTarifa por Hora: %s€/h", tarifaHora);
    }

    private static double calcularSalario(double tarifa, int horasTrabajadas) {
        return (double)horasTrabajadas * tarifa;
    }

    private static int pedirHoras() throws InputNumException {
        MyScanner sc = new MyScanner();
        int x = sc.pedirNumero("Horas Trabajadas?");
        if (x > 0) {
            return x;
        } else {
            throw new InputNumException("No puedes poner números negativos!");
        }
    }

    public static void main(String[] args) {
        double tarifa = 7.5;
        int intentos = 3;
        MyScanner sc = new MyScanner();
        System.out.printf("Aula 4 - Javier San Juan Muela.%n");
        while (intentos != 0) {
            try {
                System.out.print("=== CALCULADORA DE HORAS LABORALES ===\n");
                String empleado = sc.pideTexto("Nombre del Empleado?");
                int h = pedirHoras();
                double salario = calcularSalario(tarifa, h);
                mostrarResumen(salario, empleado, h, tarifa);
                break;
            } catch (InputNumException e) {
                System.out.print(e.getMessage());
                intentos--;
                System.out.printf("%nTe quedan %s intentos%n", intentos);
            }
        }
        sc.cerrar();
    }
}
