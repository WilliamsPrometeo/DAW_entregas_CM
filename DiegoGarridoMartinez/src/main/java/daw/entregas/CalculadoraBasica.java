package daw.entregas;

import daw.entregas.exceptions.NumericaException;
import daw.entregas.recursos.MyScanner;

public class CalculadoraBasica {

    // Iniciamos el scanner
    private static final MyScanner scanner = new MyScanner();

    public static void main(String[] args) {
        //Introducimos el programa
        System.out.println(" ===CALCULADORA BÁSICA=== ");

        // Pedir números
        double num1 = pedirNumero("Introduce el primer número: ");
        double num2 = pedirNumero("Introduce el segundo número: ");

        // Guardar resultados
        double suma = sumar(num1, num2);
        double resta = restar(num1, num2);
        double multiplicacion = multiplicar(num1, num2);

        String divisionResultado;

        try {
            double division = dividir(num1, num2);
            divisionResultado = String.valueOf(division);
        } catch (NumericaException e) {
            divisionResultado = "No se puede dividir entre 0.";
        }

        // Mostrar resumen
        System.out.println(" ===RESUMEN=== ");
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + divisionResultado);

        scanner.cerrar();// cerramos el scanner
    }

    //pedir numero entre 0 y 100//
    public static double pedirNumero(String mensaje) {
        double numero = -1;
        boolean correcto;

        do {
            numero = scanner.pedirDecimal(mensaje);
            //comprobamos si el numero esta entre 0 Y 100
            if (numero >= 0 && numero <= 100) {
                correcto = true;
            } else {
                System.out.println("Error: Valor introducido erróneo. Rango del 0 al 100 válidos.");
                correcto = false;
            }
        }while (!correcto);

        return numero;
    }

    //operaciones
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // División con excepción
    public static double dividir(double a, double b) throws NumericaException {
        if (b == 0) {
            throw new NumericaException("No se puede dividir entre 0.");
        }
        return a / b;
    }
}

