package src;

import java.util.Scanner;

public class CalculadorHoras {
    public static void main(String[] args) throws MyException {
        String nombre;
        Double total;
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE HORAS LABORALES ===");
        System.out.println("Ingresa nombre de trabajador: ");
        nombre = sc.nextLine();
        sc.nextLine();
        int horas = CalculadorHoras.pedirHora("Horas realizadas: ");
        total = CalculadorHoras.CalcularSalario(horas);
        System.out.println("===== RESUMEN SEMANAL =====");
        System.out.println("Empleado: " + nombre);
        System.out.println("Tarifa por hora 7,5€");
        System.out.println("Salario total: " + total + "€");

    }
    public static int pedirHora(String texto) throws MyException {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        int i = 1;
        boolean flag = true;
        do {
            try {
                System.out.println(texto);
                n = sc.nextInt();
                sc.nextLine();
                if (n > 0 && n < 70) {
                    flag = true;
                } else
                    throw new MyException("Error: Horas no válidas. Intento " + i + " de 3.");
            } catch(MyException e){
            System.out.println(e.getMessage());
            i++;
            flag = false;
            }
            }while(!flag && i <= 3);
            return n;
        }

    public static double CalcularSalario(int horas){
       double Salario = 0;
       final double EurosHora = 7.5;
       Salario = (double) horas * EurosHora;
       return Salario;
    }
    public static String mostarResumen(String nombre, double numero){
        String resumen = "";


        return resumen;
    }
    }