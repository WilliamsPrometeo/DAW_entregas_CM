package Entrega2.src;

public class CalculadoraBasica {

    public static void main(String[] args) {

        double num1 = pedirNumero("Introduzca un numero de 0 a 100: ");
        double num2 = pedirNumero("Introduzca otro numero de 0 a 100: ");

        double suma = sumar(num1, num2);
        double resta = restar(num1, num2);
        double multi = multiplicar(num1, num2);

        double division = 0;
        boolean divisionValida = true;

        try {
            division = dividir(num1, num2);
        } catch (DivisionEntreCeroException e) {
            System.out.println("ERROR: No puedes dividir entre 0.");
            divisionValida = false;
        }

        // Definimos como va a salir por pantalla
        System.out.println("=== Calculadora Basica ===");
        System.out.println("Introduce el primer numero: " + num1);
        System.out.println("Introduce el primer numero: " + num2);


        System.out.println("=== RESUMEN ===");
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multi);
        if (divisionValida) {
            System.out.println("División: " + division);
        } else {
            System.out.println("División: operación inválida (división entre 0)");
        }
    }

    // Creamos metodo para introducir los numeros y validar
    public static double pedirNumero(String mensaje) {
        double numero;
        boolean valido;

        do {
            System.out.print(mensaje);
            numero = MyScanner.nextDouble();
            valido = (numero >= 0 && numero <= 100);
            if (!valido) {
                System.out.println("Error: Debe estar entre 0 y 100.");
            }
        } while (!valido);

        return numero;
    }
    // Implementamos el resto de metodos
    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) throws DivisionEntreCeroException {
        if (b == 0) {
            throw new DivisionEntreCeroException("Error: división entre cero");
        }
        return a / b;
    }
}

