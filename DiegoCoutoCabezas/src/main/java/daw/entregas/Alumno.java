package daw.entregas;

import recursos.MyScanner;

import java.util.Scanner;


public class Alumno {
    static final double tarifa = 7.5;
    private static final MyScanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre = MyScanner.leerTexto("Introduce el nombre");
        double horas = pedirhoras();
        double salario = horas;
        resumen(nombre, horas, salario);

    }
    public static double pedirhoras() {
        int intentos = 0;
        double horas = 0;

        while (intentos < 3) {
            String entrada = MyScanner.leerNumero("Introduce las horas trabajadas");
            try {
                horas = Double.parseDouble(entrada);

                if (horas >= 0 && horas <= 70) {

                    return horas;
                } else {
                    System.out.println("Error: las horas deben estar entre 0 y 70.");
                }
            }catch (NumberFormatException e) {
                    System.out.println("Error: debes introducir un número válido.");
                }
                intentos++;
                if (intentos < 3) {
                    System.out.println("Te quedan " +(3 - intentos)+ " intentos.");
                }
            }

        }

    public static double calcularSalario(double horas) {
            return horas * tarifa;
        }
    public static void resumen(String nombre, double horas, double salario){
            System.out.println("\nRESUMEN DE SUELD");
            System.out.println("Empleado: " + nombre);
            System.out.println("Horas trabajadas: " + horas);
            System.out.println("Tarifa por hora: " + tarifa);

    }
}