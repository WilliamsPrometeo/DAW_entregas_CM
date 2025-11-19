/*

# 🧮 Proyecto 01 - CM – Calculadora de Horas Laborales

## 📘 Descripción general
En este proyecto el alumno deberá desarrollar un programa en Java que calcule el **sueldo semanal de un trabajador** según las horas trabajadas y su tarifa por hora, aplicando reglas de validación y condiciones especiales.

El objetivo es reforzar el uso de **condicionales, bucles y validación de datos**, sin emplear clases ni objetos adicionales (solo el `main` y métodos estáticos).

---

## 🧩 Requisitos funcionales

1. El programa debe tener una **clase principal llamada `CalculadoraHoras`** con un **método `main`**.
2. Se debe usar la **clase `MyScanner`** para leer datos del usuario.
3. El programa debe pedir los siguientes datos:
    - Nombre del empleado.
    - Horas trabajadas durante la semana (de **0 a 70**).
    -
4. Establecer la tarifa por hora (de **7.5 euros/hora**).
5. Si los valores introducidos están fuera del rango válido, debe volver a pedirse el dato.
    - Máximo **3 intentos** antes de mostrar un mensaje de error y finalizar el programa.

6. Al final, debe mostrarse un resumen con:
    - Nombre del empleado.
    - Horas trabajadas.
    - Tarifa.
    - Salario total.

---

## ⚙️ Requisitos técnicos

- El código debe estar correctamente **indentado** y **comentado**.
- Se deben usar **métodos estáticos** para dividir la lógica:
    - `pedirHoras()`, `calcularSalario()`, `mostrarResumen()`.
- Se debe validar la entrada numérica y controlar los intentos.
- No se permite el uso de bibliotecas externas.
- El programa debe funcionar correctamente sin errores de ejecución.

---

## 🧮 Ejemplo de salida esperada

```
=== CALCULADORA DE HORAS LABORALES ===
Introduce el nombre del empleado: Marta
Introduce las horas trabajadas esta semana: 46

===== RESUMEN SEMANAL =====
Empleado: Marta
Horas trabajadas: 46
Tarifa por hora: 7.5 €
Salario total: 735.0 €
```

---

## 🧾 Criterios de evaluación (Rúbrica / 10 pts)

| Criterio | Descripción | Puntos |
|-----------|-------------|--------|
| **1️⃣ Estructuras de control** | Uso correcto de condicionales y bucles para validar los datos. | **3 pts** |
| **2️⃣ Métodos y modularidad** | Código dividido en métodos estáticos con responsabilidades claras. | **3 pts** |
| **3️⃣ Validación y manejo de errores** | Control de rangos y de número máximo de intentos. | **2 pts** |
| **4️⃣ Claridad y comentarios** | Código legible, indentado y con comentarios explicativos. | **1 pt** |
| **5️⃣ Ejecución sin errores** | Compila y muestra resultados correctos. | **1 pt** |

---

## 💬 Recomendaciones

- Usa constantes (`HORAS_MAX = 70`, `TARIFA_MIN = 7.5`, etc.).
- Aplica condiciones claras para los tramos de horas.
- Incluye al menos un comentario en cada método explicando su función.
- Termina el programa de forma elegante si se superan los intentos permitidos.

 */

// se importa automático el MyScanner y la excepción que he creado
import exceptions.CalcHorasException;
import recursos.MyScanner;

// creo la clase con el nombre de la práctica y el mío
public class CalculadoraHoras_Rodrigo_Garcia {

    // inicio el escáner propio 'MyScanner'
    private static final MyScanner sc = new MyScanner();

    // inicializo la constante 'cobroPorHora'
    public static final double cobroPorHora = 7.5;


    // creo el método 'pedirHoras' para pedirle al usuario las horas trabajadas
    public static double pedirHoras() {
        double horasTrabajadas = 0;
        boolean salida;
        int intentos = 1;

        // con el bucle depuro errores y lanzo la excepción si se necesita
        do{
            try{
                horasTrabajadas = sc.pedirDecimal("Ingrese las horas trabajadas: ");
                if(horasTrabajadas < 0 || horasTrabajadas > 70) {
                    throw new CalcHorasException("Error: Las horas trabajadas tienen que estar entre 0 y 70. Intento " + intentos + " de 3");
                }
                salida = true;
            } catch(CalcHorasException e) {
                System.out.println(e.getMessage());
                intentos++;
                salida = false;
                horasTrabajadas = 0;
            }
        } while(!salida && intentos <= 3); // el usuario tiene máximo 3 intentos
        if(intentos == 3) {
            System.out.println("Se te han acabado los intentos.");
        }
        return horasTrabajadas; // me devuelve las horas trabajadas
    }

    // método main donde se ejecuta el programa y se llama a otros métodos
    public static void main(String[] args) throws CalcHorasException {

        // pide el nombre al empleado
        String nomEmpleado = sc.pedirSoloTexto("Ingrese su nombre: ");

        // pide las horas que trabaja al empleado y calcula su salario
        double horasTrabajadas = pedirHoras();
        double salarioTotal = horasTrabajadas * cobroPorHora;

        /* se imprime automáticamente el 'Resumen Semanal' donde aparecen datos como
        (nombre, horasTrabajadas, tarifaPorHora y salarioTotal) del empleado */

        System.out.println();
        System.out.println("===== RESUMEN SEMANAL =====");
        System.out.println("Empleado: " + nomEmpleado);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tarifa por hora: " + cobroPorHora + "€");
        System.out.println("Salario total: " + salarioTotal + "€");

        // cierro el escáner 'MyScanner'
        sc.cerrar();
    }
}