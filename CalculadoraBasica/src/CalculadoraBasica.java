import java.util.Scanner;

public class CalculadoraBasica
{
    private static final MyScanner sc = new MyScanner();
    private static double pedirNumero(String mensaje)
    {
        double num;
        boolean correcto; // Declaracion de la variable bandera para permancer o salir del bucle do-while
        // Validacion del numero se desarrolla dentro de la estructura do-while
        do
        {
            num =  sc.pedirDecimal(mensaje); // Se considera que el numero puede ser decimal
            try // Aqui se desarrolla la validacion verificada
            {
                if(num < 0 || num > 100)
                    throw new NumeroException("Error: Valor introducido erroneo. Rango del 0 al 100 válidos.");
                correcto = true;

            } catch (NumeroException e){
                    System.out.println(e.getMessage()); //Capturo el mensaje de la excepcion
                    correcto = false;
                    num = -1;
            }
        }while(!correcto);

        return num;
    }
    private static double sumar(double a, double b)
    {
        return (a + b);
    }

    private static double restar(double a, double b)
    {
        return (a - b);
    }
    private static double multiplicar(double a, double b)
    {
        return (a * b);
    }
    private static double dividir(double a, double b)
    {
        double division = 0;

        try
        {
            if (b == 0)
                throw new DivisionException("No se puede dividir entre 0.");

        } catch (DivisionException e){
            System.out.println(e.getMessage());
            return (-1); // Si b es igual a cero el error se representa con un return de -1
        }
        division = a / b;
        return division;

    }

    public static  void main(String[] args)
    {
        double num1;
        double num2;

        System.out.println("=== CALCULADORA BÁSICA ===");
        num1 = pedirNumero("Introduce el número 1: ");
        num2 = pedirNumero("Introduce el numero 2: ");

        System.out.println("===== RESUMEN =====");
        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicacion: " + multiplicar(num1, num2));
        if (dividir(num1, num2) != -1) // si se recibe el valor de -1 es porque es un error
            System.out.println("Division: " + dividir(num1, num2));
        sc.cerrar();
    }
}
