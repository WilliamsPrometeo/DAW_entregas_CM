

import daw.entregas.CalculadoraException;
import daw.entregas.MyScanner;

import java.util.Scanner;

public class CalculadoraBasica {
    private static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        System.out.println("===== CALCULADORA BÁSICA =====");

        //declaramos variables e inicializamos
        double num1 = sc.pedirNumero("Introduzca el primer numero: ");
        double num2 = sc.pedirNumero("Introduzca el segundo numero: ");

        //imprimimos dentro del main
        System.out.println("\n===== RESUMEN =====");
        System.out.println("Numero 1: " + num1);
        System.out.println("Numero 2: " + num2 );
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicacion: " + multiplicar(num1, num2));
        System.out.println("Division: " + dividir(num1, num2));
    }

    //colocamos los metodos
    public static int pedirNumero(String texto) {
        boolean correcto;
        int num1 = 0;
        int num2 = 100;
        do {
            pedirNumero("introduzca los numeros a sumar: ");
            try {
                if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
                    throw new CalculadoraException("Esta fuera del rango, intentar de nuevo");
                }

                correcto = true;
            } catch (CalculadoraException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);
        return num1 + num2;
    }
    public static double sumar(double a, double b) {
       return a + b;
       //retornamos los doubles para evitar hacer la operacion de nuevo y hacemos el calculo de la suma
    }

    public static double restar(double a, double b) {
        return a - b;
        //hacemos el calculo de la resta
    }

    public static double multiplicar(double a, double b) {
       return a * b;
       //hacemos el calculo de la multiplicacion
    }

}
    public static double dividir(double a, double b) {
    return a / b;
        //hacemos el calculo de la division
}

