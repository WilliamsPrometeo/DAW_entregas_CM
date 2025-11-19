package src;

public class Main  {
    private static final MyScanner sc = new MyScanner();

    final private static double salario = 7.5;

    public static void main(String[] args) {

        double salarioFinal = salario;
        double horas=0.0;
        int intentoNombre=3;


        String empleado = sc.pedirSoloTexto("Introduce tu nombre:");
        boolean salida=false;

        while(salida!=false || intentoNombre>0){

            horas = sc.pedirDecimal("Introduce el numero de horas:");

            if(horas<=0 || horas>70){
                intentoNombre--;
            } else {
                salarioFinal = calcularSalario(horas);
                salida=true;
            }
        }

        salarioFinal = horas*salario;

        System.out.println("----RESUMEN SEMANAL----");
        System.out.println("Nombre: "+empleado);
        System.out.println("Horas trabajadas:"+horas);
        System.out.println("Tarifa por hora: "+salario);
        System.out.println("Salario: "+salarioFinal);

    }

    public static double calcularSalario(double horas_trabajadas) {
        return salario * horas_trabajadas;
    }

}