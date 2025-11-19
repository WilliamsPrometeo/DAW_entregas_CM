public class CalculadoraBasica {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        double numero1;
        double numero2;

        System.out.println("=== CALCULADORA BÁSICA ===");
        numero1 = sc.pedirNumero("Introduce el numero1: ");
        numero2 = sc.pedirNumero("Introduce el numero2: ");

        System.out.println("===== RESUMEN =====");
        System.out.println("Numero1: " + numero1);
        System.out.println("Numero2: " + numero2);
        System.out.println("Suma: " + sumar(numero1, numero2));
        System.out.println("Resta: " + restar(numero1, numero2));
        System.out.println("Multiplicación: " + multiplicar(numero1, numero2));
        System.out.println("División: " + dividir(numero1, numero2));
    }

    public static double pedirNumero(String mesagge) {
        double numero1, numero2;
        numero1 = sc.pedirNumero(mesagge);

        while (numero1 < 0 || numero1 > 100) {
            System.out.println("Error: Error: Valor introducido erroneo. Rango del 0 al 100 válidos.");
        }
        return numero1;
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        boolean correcto;

        try {
            if (a == 0 || b == 0) {
                throw new Nodividir("No se puede dividir por cero");
            }
            correcto = true;
        } catch (Nodividir e) {
            System.out.println(e.getMessage());
            correcto = false;
        }
        return a / b;
    }
}