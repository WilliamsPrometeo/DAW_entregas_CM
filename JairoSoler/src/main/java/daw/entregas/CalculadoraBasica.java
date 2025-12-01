package daw.entregas;

public class CalculadoraBasica {
    public static void main(String[] args) throws calculadoraException {
        //Escáner
        MyScanner sc = new MyScanner();

        //Declaración de variables
        Boolean correcto = false;
        int num1;
        int num2;
        double num3 = 10;
        double num4 = 4;

        //Solicitar el primer número al usuario

        System.out.println("=== CALCULADORA BÁSICA ===");
        do {
            num1 = sc.pedirNumero("Introduce el número 1:");
            if (num1 < 0 || num1 > 100) {
                System.out.println("ERROR, el rango debe estar entre 0 e 100, vuelve a intentarlo");
            } else {
                correcto = true;
            }
        } while (!correcto);

        //Solicitar el segundo número al usuario

        correcto = false;
        do {
            num2 = sc.pedirNumero("Introduce el número 2:");
            if (num2 < 0 || num2 > 100) {
                System.out.println("ERROR, el rango debe estar entre 0 e 100, vuelve a intentarlo");
            } else {
                correcto = true;
            }
        } while (!correcto);
        System.out.println();

        //Mostrar resumen al usuario por pantalla
        System.out.println("===== RESUMEN =====");
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicacion: " + multiplicar(num1, num2));
        System.out.println("Division: " + dividir(num1, num2));
    }

    //MÉTODOS ESTÁTICOS
    //Método que recibe por parámetro 2 números y devuelve la suma de ambos
    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }

    //Método que recibe por parámetro 2 números y devuelve la resta de ambos
    public static int restar(int num1, int num2) {
        return num1 - num2;
    }

    //Método que recibe por parámetro 2 números y devuelve la multiplicación de ambos
    public static int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    //Método que recibe por parámetro 2 números y devuelve la división de ambos en caso de que no se esté diviendo entre 0
    public static String dividir(double num1, double num2) {
        try {
            if (num2 == 0) {
                throw new calculadoraException("No se puede dividir entre 0.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "" + num2 / num1;

    }
}
