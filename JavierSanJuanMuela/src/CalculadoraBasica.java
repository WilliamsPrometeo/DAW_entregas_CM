import recursos.MyScanner;
import exceptions.NotCeroException;
import exceptions.RangeNumberException;

public class CalculadoraBasica {
    // Declaramos variable para usar el scanner.
    private static final MyScanner input = new MyScanner();

    // Declaramos metodo para pedir el número y, en caso de que no esté dentro del rango, devolver la excepción RangeNumberException.
    public static double pedirNumero(int y) throws RangeNumberException {
        double x = input.pedirNumero("Introduce el número " + y + ": ");
        if (x < 0 || x > 100) {
            throw new RangeNumberException("Introduce un número valido (0-100)");
        }
        return x;
    }

    // Declaramos metodo para sumar
    public static double sumar(double x, double y) {
        return x + y;
    }

    // Declaramos metodo para restar
    public static double restar(double x, double y) {
        return x - y;
    }

    // Declaramos metodo para multiplicar
    public static double multiplicar(double x, double y) {
        return x * y;
    }

    // Declaramos metodo para dividir y, en caso de que alguno de los números entregados en los parámetros (x o y) sean 0, se devuelve la excepción NotCeroException.
    public static double dividir(double x, double y) throws NotCeroException {
        if (x == 0 || y == 0) {
            throw new NotCeroException("No se puede dividir por 0");
        }
        return x / y;
    }

    // Declaramos metodo main, que orquestará toda la ejecución del script.
    public static void main(String[] args) {
        // Primer número
        double x = 0;
        // Segundo número
        double y = 0;
        // Variable para mantener el bucle abierto o cerrado.
        boolean bucle = true;
        System.out.printf("=== CALCULADORA BÁSICA ===%n");

        // Declarasmos bucle
        while (bucle) {
            // Intenta ejecutar la función, pero en caso de que al pedir los números alguno de ellos no esté dentro del rango (es decir, que devuelva la excepción RangeNumberException) devolverá un mensaje personalizado y seguirá con el bucle.
            try {
                // Ejecutamos función que pedirá los 2 números y, con el argumento, declaramos el orden de cada número.
                x += pedirNumero(1);
                y += pedirNumero(2);

                // Intenta devolver la división, y, en caso de que devuelva la excepción NotCeroException, imprime un resultado diferente por consola.
                try {
                    System.out.printf("===== RESUMEN =====%nNúmero 1: %s%nNúmero 2: %s%nSuma: %s%nResta: %s%nMultiplicación: %s%nDivisión: %s%n", x, y, sumar(x, y), restar(x, y), multiplicar(x, y), dividir(x, y));
                    // Rompe el bucle
                    bucle = false;
                } catch (NotCeroException e) {
                    System.out.printf("===== RESUMEN =====%nNúmero 1: %s%nNúmero 2: %s%nSuma: %s%nResta: %s%nMultiplicación: %s%nDivisión: %s%n", x, y, sumar(x, y), restar(x, y), multiplicar(x, y), e.getMessage());
                    // Rompe el bucle
                    bucle = false;
                }
            } catch (RangeNumberException e) {
                // Devuelve mensaje de error personalizado derivado de la excepción.
                System.out.println(e.getMessage());
            }
        }
    }
}
