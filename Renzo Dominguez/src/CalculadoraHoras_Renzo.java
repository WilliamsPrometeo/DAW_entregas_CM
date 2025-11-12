import recursos.MyScanner;

import java.util.InputMismatchException;

public class CalculadoraHoras_Renzo
{
    public static int pedirHoras(sc)
    {
        int     horas = 0;
        horas = sc.pedirNumero("Horas trabajadas durante la semana (de **0 a 70**)");
        return horas;
    }

    public static float calcularSalario(int horas)
    {
        float  tarifa = 7,5;
        float salario;

        salario = horas * tarifa;
        return salario;
    }

    public static void mostrarResumen()
    {
        System.out.println("===== RESUMEN SEMANAL =====");
        System.out.println("Empleado: " + );
        System.out.println("Horas trabajadas:");
        System.out.println("Tarifa por hora:");
        System.out.println("Salario:");


    }

    private static final MyScanner sc = new MyScanner();
    public static void main(String[] args) throws Excepcion;
    {
        String nombre;
        int intentos = 1;
        int horas;

        nombre = sc.pedirSoloTexto("Nombre del empleado: ");

        do
        {
            try
            {
                horas = pedirHoras(sc);
                if (horas < 0 || horas > 70)
                    throw new Excepcion("Error:");
                break;
            } catch (Excepcion e){
                intentos++;
                horas = 0;
            }

        }while (intentos <= 3);

        calcularSalario(horas);
        mostrarResumen();

    }
}
