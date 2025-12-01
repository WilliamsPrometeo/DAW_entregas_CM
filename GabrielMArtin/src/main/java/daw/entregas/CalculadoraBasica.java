package daw.entregas;

import src.Recursos.MyScanner;
import src.Recursos.OperacionException;

public class CalculadoraBasica {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        System.out.println("===== CALCULADORA BÁSICA =====");

        //pedir el primer número
        double num1 = pedirNumero("Introduce el número 1: ");
        //pedir segundo número
        double num2 = pedirNumero("Introduce el número 2: ");

        //calcular las operaciones básicas (suma, resta y multiplicacionn)
        double suma = sumar(num1, num2);
        double resta = restar(num1, num2);
        double multiplicacion = multiplicar(num1, num2);

        //división con control de la excepción, no se puede dividir entre 0
        String divisionResultado;

        try {
            double division = dividir(num1, num2);
            divisionResultado = String.valueOf(division);
        } catch (OperacionException e) {
            divisionResultado = "No se puede dividir entre 0.";//si se divide entre 0 va a mostrar este mensaje
        }

        //mostrar el resumen final
        mostrarResumen(num1, num2, suma, resta, multiplicacion, divisionResultado);

        sc.cerrar();
    }

    //metodos estáticos
    public static double pedirNumero(String mensaje) {
        double numero;
        boolean correcto;
        do {
            numero = sc.pedirDecimal(mensaje);
            try {
                if (numero < 0 || numero > 100) {
                    throw new OperacionException("Error: Valor introducido erróneo. Rango del 0 al 100 válidos.");
                }
                correcto = true;
            } catch (OperacionException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);
        return numero;
    }
    //suma
    public static double sumar(double a, double b) {
        return a + b;
    }
    //resta
    public static double restar(double a, double b) {
        return a - b;
    }
    //multiplicacion
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    //division
    public static double dividir(double a, double b) throws OperacionException {
        if (b == 0) {
            throw new OperacionException("No se puede dividir entre 0.");
        }
        return a / b;
    }
    //mostrar el resumen
    public static void mostrarResumen(double n1, double n2, double suma, double resta, double multiplicacion, String divisionResultado) {

        System.out.println("===== RESUMEN =====");
        System.out.println("Número 1: " + n1);
        System.out.println("Número 2: " + n2);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + divisionResultado);
    }
}






