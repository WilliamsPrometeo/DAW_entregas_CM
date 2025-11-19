public class CalculadoraHoras {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) throws HorasException {

    //asigno las variables
    int intentos = 1;
    boolean salida;
    double horas = 0;
    String nombre;
    double tarifa =7.5;
    double resultado = 0;

    //imprimimos por pantalla lo que queremos que aparezca solo una vez.
    System.out.println("===CALCULADORA DE HORAS LABORALES===");
    nombre = sc.pideTexto("Ingrese el nombre del usuario: ");

    //usamos el bucle do/while y dentro un try/catch
    do{
        try {
            horas = sc.pedirNumero("Ingrese las horas trabajadas esta semana:");
            if (horas<0 || horas >70) {
                throw new HorasException("Horas trabajadas no valido " + intentos + " de 3.");
            } else {
                resultado = horas * tarifa;
            }
            salida = true;
        } catch (HorasException e) {
            System.out.println(e.getMessage());
            intentos++;
            salida = false;
        }
    } while (!salida && intentos <=3);

    System.out.println("===RESUMEN SEMANAL===");
    System.out.println("Empleado: " + nombre);
    System.out.println("Horas trabajadas: " + horas);
    System.out.println("Tarifa por hora: " + tarifa);
    System.out.println("Salario total: " +resultado);

        sc.cerrar();
    }
}
