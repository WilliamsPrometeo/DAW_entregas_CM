package daw.entregas;

public class CalculadoraHoras {
    // Instacia estática del MyScanner para su uso en el proyecto
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) throws RangoException {
        MyScanner sc = new MyScanner();
        //Dando variable necesario
        int intentos=1;
        boolean salida;
        int hora;
        double tarifa=7.5;
        double salario;
        String nombre;

        System.out.println("=== CALCULADORA DE HORAS LABORALES ===");
        // Utilizando Scanner para pedir nombre
        nombre=sc.pideTexto("Introduce el nombre del empleado:");
        //Utilizando Doble do-while para limitar los intento y repeticion

        do {
            //Ejercutar la programa si pasa excepcion se salta a catch
            try{
                hora=sc.pedirNumero("Introduce las horas trabajadas esta semana:");
                //Utilizando la if y else para distinto situacion
                if (hora<0 || hora >70) {
                    //En caso de if se lanza exception
                    throw new RangoException("Error: hora no válida. Intento " + intentos + " de 3.");
                    //sino realiza programacion que esta dentro de else
                }else {
                    System.out.println("===== RESUMEN SEMANAL =====");
                    System.out.println("Empleado: "+nombre);
                    System.out.println("Horas trabajadas: "+hora);
                    System.out.println("Tarifa por hora: "+tarifa+" €");
                    //
                    salario= hora*tarifa;
                    System.out.println("Salario total: "+salario+" €");
                }
                salida = true;
                //catch para solucionar si pasa exception
            } catch (RangoException e) {
                //Imprimir exception
                System.out.println(e.getMessage());
                //suma 1 vez a intentos
                intentos++;
                salida = false;
            }
        //Se detene hasta salida es true y intento = 3
        } while (!salida && intentos<=3);
        //Cerra Scanner
        sc.cerrar();
    }
}
