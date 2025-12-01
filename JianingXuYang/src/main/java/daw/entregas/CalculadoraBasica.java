package daw.entregas;

public class CalculadoraBasica {
    // Instacia estática del MyScanner para su uso en el proyecto
    private static final MyScanner sc = new MyScanner();
    //Utilizamos metodo main para crea un punto de inicio de programa
    public static void main(String[] args) {
        // Creamos do variable
        double num1;
        double num2;
        //Imprimir el enuciado
        System.out.println("=== CALCULADORA BÁSICA ===");
        // lanza el funcion pedirNumero
        num1 = pedirNumero("Introduce un numero 1: ");
        num2 = pedirNumero("Introduce un numero 2: ");

        //Imprimir resultado
        System.out.println("===== RESUMEN =====");
        System.out.println("Numero 1: "+num1);
        System.out.println("Numero 2: "+num2);
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicacion: " + multiplicar(num1, num2));
        System.out.println("Division: " + dividir(num1, num2));

    }
    //funcion pedirNumero
    public static double pedirNumero(String mensaje) {
        double num1, num2;
        num1 = sc.pedirNumero(mensaje);
        // Utiliza buble while para controlar la condicion cuando fuera de rango
        while (num1 < 0 || num1 > 100) {
            System.out.println("Error: Valor introducido erroneo. Rango del 0 al 100 válidos.");
            num1 = sc.pedirNumero(mensaje);
        }
        //revuelve el numero
        return  num1;
    }

    // funcion de sumar
    public static double sumar(double a, double b) {
        //revuelve resultado
        return a + b;
    }
    // funcion de restar
    public static double restar(double a, double b) {
        //revuelve resultado
        return a - b;
    }

    // funcion de multiplicar
    public static double multiplicar(double a, double b) {
        //revuelve resultado
        return a * b;
    }

    // funcion de dividir
    public static double dividir(double a, double b) {
        //Ejercutar el programa si b es <= 0 se pasa a catch y lanza ERROR
        try {
            if (b <= 0) {
                throw new DividirException("No se puede dividir entre 0.");
            }
        } catch (DividirException e) {
            System.out.println(e.getMessage());
        }
        return a / b;
    }
}
