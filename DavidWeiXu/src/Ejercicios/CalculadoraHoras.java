package Ejercicios;

import Exceptions.HorasException;
import Recursos.MyScanner;

public class CalculadoraHoras {

    //Creamos un scanner
    private static final MyScanner sc = new MyScanner();


    //Metodo main para ejecutar el programa
    public static void main(String[] args) throws HorasException {

        //Creamos la tarifa
        double tarifa = 7.5;

        System.out.println("--- CALCULADORA DE HORAS LABORALES ---");

        //Pedimos nombre
        String nombre = sc.pedirSoloTexto("Indroduce el nombre del empleado: ");

        //Pedimos horas
        double horas = sc.pedirDecimal("Introduces las horas trabajadas esta semana: ");
        pedirHoras(horas);

        //Calculamos salario
        double salario = calcularSalario(horas, tarifa);

        //Mostrar resumen
        mostrarResumen(salario, nombre, tarifa, horas );

        //Cerrar scanner
        sc.cerrar();

    }

    //Creamos metodo estatico para pedir horas con sus limites
    public static double pedirHoras(double horas) throws HorasException {

        //Creamos variables para el bucle
        int intentos = 1;
        boolean salida;

        //Creamos constantes para los limitese
        final double HORAS_MIN = 0, HORAS_MAX = 75;

        //Creamos bucles para que se intente 3 veces
        do{
            try {

                //Condicional para el limite
                if (horas < HORAS_MIN || horas > HORAS_MAX){
                    throw new HorasException("Las horas deben estar entre 0 y 75 horas. Intento " + intentos + " de 3.");
                }
                else {
                    salida = true;
                }

            }catch(HorasException e1){
                System.out.println(e1.getMessage());
                intentos++;
                salida = false;
            }
        }while(!salida && intentos <= 3);

        return horas;
    }


    //Creamos metodo estatico para calcular salario
    public static double calcularSalario(double horas, double tarifa){

        //Creamos condicional para cambiar la tarifa
        if(horas >= 41 && horas <= 50){
            tarifa = tarifa * 1.5;
        }
        if(horas >50){
            tarifa = tarifa * 2;
        }

        return horas * tarifa;
    }


    //Creamos metodo estatico para mostrar el resumen
    public static String mostrarResumen(double salario, String nombre, double tarifa, double horas){

        //Creamos el mensage final
        System.out.println();
        System.out.println("--- RESUMEN SEMANAL ---");
        System.out.println("Empleado: " + nombre);
        System.out.println("Horas trabajadas: " + horas + " horas");
        System.out.println("Tarifa por hora: " + tarifa + "€");
        System.out.println("Salario total: " + salario + "€");
        return "---------------------";

    }



}
