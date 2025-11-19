package entrega_02;

import src.MyScanner;

public class CalculadoraBasica {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) throws dividir0Exception {
        System.out.println("=== CALCULADORA BÁSICA ===");

        //Pedimos el numero con las dos variables que vamos a introducir
        double a = pedirNumero("Introduce el número 1:");
        double b = pedirNumero("Introduce el número 2:");

        //Escribirmnos lo que se va a mostrar por consola como resumen utilizando los metodos
        System.out.println("==== RESUMEN ====");
        System.out.println("Número 1:" +a);
        System.out.println("Número 2:" +b);
        System.out.println("Suma: " +sumar(a, b));
        System.out.println("Resta: " +restar(a, b));
        System.out.println("Multiplicacion: " +multiplicar(a, b));

        //El metodo de division + la excepcion entre 0
        try{
            System.out.println("División: "+dividir(a, b));
        } catch (dividir0Exception e) {
            System.out.println("División: "+e.getMessage());
        }
    }


    //Metodo pedir numero con bucle si los numeros no entrar dentro del rango
    public static double pedirNumero(String mensaje){
        double numero;


        do {
            System.out.print(mensaje);
            numero = sc.pedirNumero("");

            if (numero < 0 || numero > 100) {
                System.out.println("Número fuera de rango. Intenta de nuevo.");
            }
        } while (numero < 0 || numero > 100);
        return numero;
    }
    //Metodo sumar dos variables
    public static double sumar(double a, double b) {
        return a + b;
    }

    //Metodo restar dos variables
    public static double restar(double a, double b) {
        return a - b;
    }

    //Metodo multiplicar dos variables
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    //Metodo dividir dos variables
    public static double dividir(double a, double b) throws dividir0Exception {

        //Si el numero 2 es 0 lanzamos la excepcion
        if (b == 0) {
            throw new dividir0Exception("No se puede dividir por 0");
        }

        return a / b;
    }
}
