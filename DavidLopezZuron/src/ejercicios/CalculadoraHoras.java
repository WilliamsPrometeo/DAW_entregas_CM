package ejercicios;

import exceptions.CalculadoraDeHorasException;
import recursos.MyScanner;

public class CalculadoraHoras {

    //Declaramos el metodo MyScanner
    private static final MyScanner input = new MyScanner();

    //Creamos una función llamada pedirHoras
    public static double pedirHoras() {
        //Declaramos las variables
        double horasTrabajadas = 0;
        int intentos = 1;
        boolean flag;

        //Creamos un bucle do-while para que entre al menos una vez
        do {
            //Usamos un try-catch para determinar si los valores intrducidos están en rango, sino lanzamos la excepcion
            //Además, si se pasa del número de intentos se cierra el programa
            try {
                horasTrabajadas = input.pedirDecimal("Ingrese el número de horas trabajadas: ");
                if(horasTrabajadas < 0 || horasTrabajadas > 70) {
                    throw new CalculadoraDeHorasException("Debe introducir un número de horas válido (entre 0 y 70). Vuelva a intentarlo, va por el intento "+ intentos + " de 3");
                }
                flag = true; // si todo está bien, salimos del bucle
            } catch(CalculadoraDeHorasException e) {
                System.out.println(e.getMessage());
                flag = false;
                intentos++;
            }
        } while(!flag && intentos <= 3);

        if(!flag) { // si se superan los intentos, terminamos el programa
            System.out.println("Número máximo de intentos superado. El programa se cerrará.");
            System.exit(0);
        }

        return horasTrabajadas;
    }

    //Creamos una función llamada calcularSalario
    public static double calcularSalario(double horasTrabajadas) {
        //Operamos salario
        double salario = horasTrabajadas * 7.5;
        return salario;
    }

    //Creamos la función mostrarResumen
    public static void mostrarResumen(String nombreDelEmpleado, double horasTrabajadas, double salarioCalculado){
        //Imprimimos los datos
        System.out.println("===== RESUMEN SEMANAL =====");
        System.out.println("Empleado: " + nombreDelEmpleado);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tarifa por hora: 7,5 €");
        System.out.println("Salario total: " + salarioCalculado + " €\n");
    }

    //Enviamos los datos llamando a los datos enviados por las dos funciones
    public static void main(String[] args) throws CalculadoraDeHorasException {
        System.out.println("=== CALCULADORA DE HORAS LABORALES ===");

        //Solicitamos el nombre del empleado
        String nombreDelEmpleado = input.pedirSoloTexto("Ingrese el nombre del empleado: ");

        //Solicitamos las horas trabajadas
        double horasTrabajadas = pedirHoras();

        //Calculamos el salario
        double salarioCalculado = calcularSalario(horasTrabajadas);

        //Mostramos el resumen
        mostrarResumen(nombreDelEmpleado, horasTrabajadas, salarioCalculado);
    }
}
