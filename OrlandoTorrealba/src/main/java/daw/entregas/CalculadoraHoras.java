package daw.entregas;

public class CalculadoraHoras {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) throws CalculadoraException {

        double horas = 0;
        String nombre;
        int intentos = 1;
        boolean salida;
        double resultado = 0;
        double tarifa = 7.5;


        nombre = sc.pideTexto("Ingrese el nombre del trabajador");

        do {
            try {
                horas = sc.pedirNumero("Ingrese las horas del trabajador");
                if (horas <= 0 || horas > 70) {
                    throw new CalculadoraException("Las horas no son validas " + intentos + "de 3.");
                }
                salida = true;
                resultado = tarifa * horas;
            } catch (CalculadoraException e) {
                System.out.println(e.getMessage());
                intentos++;
                salida = false;
            }
        } while (!salida && intentos <= 3);

        System.out.println("==== RESUMEN SEMANAL ====");
        System.out.println("Empleado: " + nombre);
        System.out.println("Las horas trabajadas: " + horas);
        System.out.println("La tarifa por hora es: " + tarifa );
        System.out.println("El salario total es: " + resultado);

        sc.cerrar();
        }
    }

