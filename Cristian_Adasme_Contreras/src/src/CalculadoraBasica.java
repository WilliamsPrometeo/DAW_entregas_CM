package src;

import java.util.InputMismatchException;

public class CalculadoraBasica {
    private static final MyScanner sc = new MyScanner();
    public static void main(String[] args) {
        int numero1;
        int numero2;
        System.out.println("=== CALCULADORA BÁSICA ===");
        do {                                                            //Este do es para repetir el proceso de pedir número si el usuario no ha puesto un número correcto
            numero1 = sc.pedirNumero("Introduce el número1: ");     //usamos el pedirNúmero del MyScanner
            try {                                                         //Este try catch se activa con nuestro NúmeroException en cuanto haya un fallo con el "if"
                if (numero1 < 0 || numero1 > 100) {
                    throw new NumeroException("Numero no valido, debe estar entre 0 y 100.");
                }                                                           //Con el throw new y el nombre de nuestra excepcion pondremos el texto que aparecera al activarse
            }catch (NumeroException i) {                                //dentro del catch identificaremos el NumeroException dentro de un valor. (i)
            System.out.println(i.getMessage());                          //Para hacer que aparezca el texto en pantalla pondremos entre parentesis el valor que le dimos ()
                }                                                         // y el getMessage().
        } while (numero1 < 0 || numero1 > 100);                            // El while decidira hasta cuando se producira este "do"".
        do {                                                                //Se repite lo mismo con el valor 2.
            numero2 = sc.pedirNumero("Introduce el numero2: ");
            try {
                if (numero2 < 0 || numero2 > 100) {
                    throw new NumeroException("Numero no valido, debe estar entre 0 y 100.");
                }
            }catch (NumeroException i) {
                System.out.println(i.getMessage());
            }
        } while (numero2 < 0 || numero2 > 100);
        System.out.println("===== RESUMEN =====");
        mostrarResultados(numero1, numero2, sumar(numero1, numero2), restar(numero1, numero2), multiplicar(numero1, numero2), dividir(numero1, numero2));
    }
    public static int sumar(int num1, int num2) { //Para el metodo suma, pillamos los dos valores en dos int y hacemos que devuelva con un return el numero 1 + numero 2.
        return num1 + num2;
    }
    public static int restar(int num1, int num2) { //Para el metodo resta, pillamos los dos valores en dos int y hacemos que devuelva con un return el numero 1 - numero 2.
        return num1 - num2;
    }
    public static int multiplicar(int num1, int num2) { //Para el metodo multiplicar, pillamos los dos valores en dos int y hacemos que devuelva con un return el numero 1 * numero 2.
        return num1 * num2;
    }
    public static String dividir(int num1, int num2) { //Para el metodo suma, pillamos los dos valores en dos int y hacemos que devuelva un String.
        int division;
        String divitext;                            //Al estar en String, creamos un String que devuelve el valor que nos de.
        try{
        if (num2 == 0){                              //Aqui probamos un try catch para ver si el segundo numero es 0.
            throw new NumeroException("No se puede dividir entre 0.");
        }else
            {
            division = num1 / num2;
            divitext = "" + division;               //Si no es 0 pasamos la division a String
            }
    }catch(NumeroException e){                      //Si es 0 pasamos el texto del getMessage a String.
            divitext = e.getMessage();
    }   return divitext;                            //Lo que nos haya salido se devolvera a String en el mostrarResultados.
    }
    public static void mostrarResultados(int num1, int num2, int suma, int resta, int multiplicacion, String division) {
        System.out.println("Número1: " + num1);
        System.out.println("Número2: " + num2);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);
        System.out.println("Division: " + division);
    } //Para poder hacer el mostrar resultados lo pasamos a void, que devuelve todo lo que hayamos hecho en este. y pedimos todos los datos necesarios para mostrar los resultados.
}
