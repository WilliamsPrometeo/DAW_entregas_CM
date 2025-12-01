package Ejercicios;

import Exceptions.DividirException;
import Recursos.MyScanner;

public class CalculadoraBasica {

    //Creamos el scanner
    private static final MyScanner sc = new MyScanner();

    //Creamos el main donde se ejecutara el programa principal
    public static void main(String[] args) {

        //Declaramos variables que vamos a usar
        double num1;
        double num2;
        String mensaje1 = "Introduce el número 1: ";
        String mensaje2 = "Introduce el número 2: ";

        System.out.println("=== CALCULADORA BÁSICA ===");

        //Pedimos los numeros y creamos un bucle para que vuelva a pedir los numeros si están fuera de rango
        num1 = pedirNumero(mensaje1);
        while (num1 < 0 || num1 > 100){
            System.out.println("Error: Valor introducido erroneo. Rango del 0 al 100 válidos");
            num1 = pedirNumero(mensaje1);
        }
        num2 = pedirNumero(mensaje2);
        while (num2 < 0 || num2 > 100){
            System.out.println("Error: Valor introducido erroneo. Rango del 0 al 100 válidos");
            num2 = pedirNumero(mensaje1);
        }

        //Mostramos el resultado
        System.out.print("\n==== RESUMEN ====\n"
                + "Número 1: " + num1 + "\n"
                + "Número 2: " + num2 + "\n"
                + "Suma: " + sumar(num1,num2) + "\n"
                + "Resta: " + restar(num1,num2) + "\n"
                + "Multiplicación: " + multiplicar(num1,num2) + "\n"
                + "Division: ");

        //Creamos un try and catch para capturar la excepcion lanzada por el metodo dividir
        try {
            System.out.print(dividir(num1, num2));
        } catch (DividirException e1) {
            System.out.print(e1.getMessage());
        };

        //Cerramos el scanner
        sc.cerrar();
    }

    //Creamos un metodo que pide numeros
    public static double pedirNumero(String mensaje){
        return sc.pedirDecimal(mensaje);
    }

    //Creamos un metodo que suma
    public static double sumar(double a, double b){
        return a + b;
    }

    //Creamos un metodo que resta
    public static double restar(double a, double b){
        return a - b;
    }

    //Creamos un metodo que multiplica
    public static double multiplicar(double a, double b){
        return a * b;
    }

    //Creamos un metodo que divide y nos puede devolver un numero o lanzar una excepcion si divide por cero
    public static double dividir(double a, double b) throws DividirException {

        //Creamos el condicional para lanzar excepcion o devolver numero
        if (b == 0){
            throw new DividirException("No se puede dividir entre 0");
        } else {
            return a / b;
        }
    }
}
