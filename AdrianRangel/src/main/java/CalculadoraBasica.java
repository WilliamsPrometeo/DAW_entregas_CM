import Excepciones.DividirCero;
import Excepciones.RangoNumeros;

public class CalculadoraBasica {
    public static final MyScanner sc = new MyScanner();

    //declaramos metodo para pedir los numeros por consola y su excepcion de rango entre 0 y 100.
    public static double pedirNumero(int orden) throws RangoNumeros {
        double num1 = sc.pedirNumero("Ingresa el numero: ");
        if (num1 < 0 || num1 > 100) {
            throw new RangoNumeros("El numero no esta en el rango!");//Mensaje de la excepcion
        } return num1;
    }

    public static void main(String[] args) {
        double num1 = 0;
        double num2 = 0;
        while (true) {
            try {
                System.out.println("=== CALCULADORA BASICA ===");
                num1 = pedirNumero(1);
                num2 = pedirNumero(2);
            } catch (RangoNumeros e) {
                System.out.println(e.getMessage());
                continue; //continue; permite volver a introducir el numero otra vez.
            }
            try {
                System.out.print("==== RESUMEN =====" + "\n");
                System.out.print("Numero 1: " + num1 + "\n");
                System.out.print("Numero 2: " + num2 + "\n");
                System.out.print("Suma: " + suma(num1, num2) + "\n");
                System.out.print("Resta: " + resta(num1, num2) + "\n");
                System.out.print("Multiplicacion: " + multiplicacion(num1, num2) + "\n");
                System.out.print("Division: " + division(num1, num2));
                break;
            } catch (DividirCero e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    //declaramos metodo para sumar
    public static double suma(double num1, double num2) {
        return num1 + num2;
    }

    //declaramos metodo para restar.
    public static double resta(double num1, double num2) {
        return num1 - num2;
    }

    //declaramos metodo para muiltiplicar.
    public static double multiplicacion(double num1, double num2) {
        return num1 * num2;
    }

    //declaramos metodo para dividir y su excepcion para evitar divisiones entre 0.
    public static double division(double num1, double num2) throws DividirCero {
        if (num1 == 0 || num2 == 0) {
            throw new DividirCero("No se puede dividir por cero");
        }
        return num1 / num2;
    }
}
