import Recursos.DivisionException;
import Recursos.MyScanner;

public class calculadoraBasica {
    private static final MyScanner sc = new MyScanner();
    public static void main(String[] args) {
        /*
        En la funcion main empezamos pidiendo los dos numero que utilizaremos y almacenandolos en dos double
        Utilizaremos los resultados y los guardaremos en doubles la suyma, resta y multiplicacion
        Crearemos una string para el resultado de la division y un boolean en caso de que la division sea invalida
        Utilizamos la excepcion en la cual estaras el resultado de la division en un double y el valueOf devolvera la representacion del double y lo almacena en la divisionResultado
        Si la excepcion se ejecuta se imprime un mensaje y la decisionInvalida pasa a ser true
        Por ultimo se imprime el resumen final con todos los resultados y datos
        Y si la divisionInvalida es true se imprime un mensaje de advertencia
         */
        System.out.println("====CALCULADORA BASICA====");
        double num1 = sc.pedirNumero("Introduce el numero 1: ");

        double num2 = sc.pedirNumero("Introduce el numero 2: ");
        double suma = sumar(num1, num2);
        double resta = restar(num1, num2);
        double multiplicacion = multiplicar(num1, num2);

        String divisionResultado;
        boolean divisionInvalida = false;

        try{
            double division = dividir(num1, num2);
            divisionResultado = String.valueOf(division);
        } catch(DivisionException e){
            divisionResultado = "ERROR: No se puede dividir entre 0";
            divisionInvalida = true;
        }

        num1 = pedirDato(num1);
        num2 = pedirDato2(num2);

        System.out.println("====RESUMEN FINAL====");
        System.out.println("Numero 1: " + num1);
        System.out.println("Numero 2: " + num2);
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);
        System.out.println("Division: " + divisionResultado);

        if (divisionInvalida) {
            System.out.println("Aviso: Se intento dividir entre 0");
        }
    }

    public static double pedirDato (double num1){
        /*
        En esta funcion se pedira el numero mientras el numero 1 sea menor que 0 o mayor que 100
        Una vez que introduzcas un numero valido te devolvera el numero
         */

        while(num1 < 0 || num1 > 100) {
            System.err.println("ERROR: Has introducido el primer numero fuera de rango");
            num1 = sc.pedirNumero("Introduce un numero valido (0 - 100):");
        }
        return num1;
    }

    public static double pedirDato2 (double num2){
        /*
        En esta funcion se pedira el numero mientras el numero 2 sea menor que 0 o mayor que 100
        Una vez que introduzcas un numero valido te devolvera el numero
         */

        while(num2 < 0 || num2 > 100) {
            System.err.println("ERROR: Has introducido el segundo numero fuera de rango");
            num2 = sc.pedirNumero("Introduce un numero valido (0 - 100):");
        }
        return num2;
    }

    public static double sumar(double num1, double num2){
        /*
        En este metodo estatico se suman los dos datos y devuelve el resultado
         */
        return num1 + num2;
    }

    public static double restar(double num1, double num2){
        /*
        En este metodo estatico se restan los datos y devuelve la resta
         */
        return num1 - num2;
    }

    public static double multiplicar(double num1, double num2){
        /*
        En este metodo estatico se multiplican los datos y se devuelve la multiplicacion
         */
        return num1 * num2;
    }

    public static double dividir(double num1, double num2) throws DivisionException{
        /*
        En este metodo estatico determinara en que caso la excepcion dara error
        Si el segundo numero introducido es 0 lanzara la excepcion
        Si no devolvera el resultado de la division normal
         */
        if (num2 == 0){
            throw new DivisionException("ERROR: No se puede dividir entre 0");
        }
        return num1 / num2;
    }
}
