package daw.entregas;

import daw.entregas.recursos.DivisionPorCeroException;
import daw.entregas.recursos.MyScanner;

public class calculadora {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        System.out.println("=== CALCULADORA BÁSICA ===");

        double num1 = pedirNumeros("Introduce el primer numero: ");
        double num2 = pedirNumeros("Introduce el segundo numero: ");

        System.out.println("===== RESUMEN =====");
        System.out.println("El primer numero es: " + num1);
        System.out.println("El segundo numero es: " + num2);
        System.out.println("La suma de los numeros da: " + sumarNum(num1, num2));
        System.out.println("La resta de los numeros da: " + restarNum(num1, num2));
        System.out.println("La multiplicacion de los numero da: " + multiplicarNum(num1, num2));

        try {
            System.out.println("La division de los numeros da: " + dividirNum(num1, num2));
        } catch (DivisionPorCeroException e) {
            System.out.println("No se puede dividir entre 0.");
        }sc.cerrar();
    }

    public static double pedirNumeros(String mensaje) {
        double num;
        while (true) {
            num = sc.pedirDecimal(mensaje);
            if (num >= 0 && num <= 100) {
                return num;
            } else {
                System.out.println("Error: Valor introducido erroneo. Rango del 0 al 100 válidos.");
            }
        }
    }
    public static double sumarNum(double num1, double num2) {
        return num1+num2;
    }

    public static double restarNum(double num1, double num2) {
        return num1-num2;
    }

    public static double multiplicarNum(double num1, double num2) {
        return num1*num2;
    }

    public static double dividirNum(double num1, double num2) throws DivisionPorCeroException {
        if (num2 == 0) {throw new DivisionPorCeroException("No se puede dividir entre 0.");
        }return num1/num2;

    }
}