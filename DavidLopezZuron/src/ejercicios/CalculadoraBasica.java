package ejercicios;/*# 📘 Proyecto 02 – Calculadora de Estadísticas Numéricas - CM

## 📝 Descripción general
En este proyecto deberás crear un programa en Java que lea **dos números introducidos por el usuario** y calcule
diferentes operaciones básicas. Este proyecto permite practicar:

- Métodos estáticos
- Estructuras de control
- Validación de datos
- Entrada por teclado usando MyScanner
- Uso de bucles
- Manejo de excepciones personalizadas

---

## 🎯 Requisitos funcionales

El programa debe:

1. Contener una **clase principal** llamada `CalculadoraBasica` con un **método `main`**.
2. Usar la clase **MyScanner** para recoger los datos introducidos por el usuario.
3. Pedir al usuario **dos números**, uno a uno.
4. Validar que cada número esté dentro del rango permitido:
    - **Solo valores entre 0 y 100 (inclusive)**
    - Si el valor no es válido, volver a pedirlo.
5. Implementar **al menos estos métodos estáticos**:
    - `pedirNumero(String mensaje)`
    - `sumar(double a, double b)`
    - `restar(double a, double b)`
    - `multiplicar(double a, double b)`
    - `dividir(double a, double b)`
6. Implementar una **excepción personalizada** (que herede de `Exception`) para controlar errores:
    - Si se intenta dividir entre 0, el método `dividir` debe **lanzar la excepción**.
    - El `main` debe capturarla y mostrar el mensaje:
      `"No se puede dividir entre 0."`
7. Al finalizar, el programa debe mostrar un **resumen** con:
    - Los valores introducidos
    - El resultado de las operaciones
    - El aviso adecuado en caso de división inválida

---

## ⚙️ Requisitos técnicos

- Todo debe implementarse mediante **métodos estáticos**.
- El programa debe estar correctamente indentado y comentado.
- Se debe validar toda entrada del usuario.
- No se pueden usar arrays.
- No se pueden usar métodos de String.
- El programa debe manejar correctamente la excepción personalizada.

---

## 🧮 Ejemplo de ejecución esperada

```
=== CALCULADORA BÁSICA ===
Introduce el número 1: 10
Introduce el número 2: 4

===== RESUMEN =====
Número 1: 10
Número 2: 4
Suma: 14
Resta: 6
Multiplicación: 40
División: 2.5
```

---
## 🧮 Ejemplo de ejecución con errores

```
=== CALCULADORA BÁSICA ===
Introduce el número 1: 5
Introduce el número 2: -2
Error: Valor introducido erroneo. Rango del 0 al 100 válidos.
Introduce el número 2: 0

===== RESUMEN =====
Número 1: 5
Número 2: 0
Suma: 5
Resta: 5
Multiplicación: 0
División: No se puede dividir entre 0.
```

---

## 🧾 Rúbrica de evaluación (10 puntos)

| Criterio                                               | Puntos    |
|--------------------------------------------------------|-----------|
| Estructuras de control (bucles y condicionales)        | **3 pts** |
| Métodos estáticos bien organizados                     | **3 pts** |
| Validación y tratamiento de errores mediante excepción | **2 pts** |
| Claridad, comentarios e indentación                    | **1 pt**  |
| Funcionamiento sin errores                             | **1 pt**  |

---

## 💡 Recomendaciones

- Evita repetir código: crea métodos reutilizables.
- Comprueba siempre los límites antes de aceptar un número.
- Mantén el código ordenado para facilitar su lectura.
- Usa la excepción personalizada para gestionar situaciones no válidas.

---

🕒 **Duración estimada:** 1 hora
🎯 **Objetivo pedagógico:** practicar modularidad, control de flujo, validación y manejo básico de excepciones sin necesidad de POO avanzada.
*/

import recursos.MyScanner;
import exceptions.DivisionPorCeroException;



public class CalculadoraBasica {

    //Declaramos el metodo MyScanner
    private static final MyScanner input = new MyScanner();

    //Método main
    public static void main(String[] args){
        System.out.println("=== CALCULADORA DE HORAS LABORALES ===");

        //Declaramos las variables
        double num1, num2;
        String mensaje1, mensaje2;
        mensaje1 = "Ingrese el número 1: ";
        mensaje2 = "Ingrese el número 2: ";

        //Solicitamos los numeros
        //Hacemos un bucle para asegurarnos de que los numeros están en el rango comprendido
        //Utilizamos un do-while para entrar al menos una vez en el bucle, asi no hay que declarar a num1 ni a num2
        do { //Bucle num1
            num1 = pedirNumero(mensaje1);
            if (num1 < 0 || num1 > 100) {
                System.out.println("Valor introducido erroneo. Rango del 0 al 100 válidos.");
            }
        } while (num1 < 0 || num1 > 100);
        do { //Bucle num2
            num2 = pedirNumero(mensaje2);
            if (num2 < 0 || num2 > 100) {
                System.out.println("Valor introducido erroneo. Rango del 0 al 100 válidos.");
            }
        } while (num2 < 0 || num2 > 100);

        //Salida de datos con llamada a las funciones correspondientes
        System.out.println("===== RESUMEN =====");

        System.out.println("Número 1: " + num1);
        System.out.println("Numero 2: " + num2);
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Mutiplicación: " + multiplicar(num1, num2));
        System.out.print("División: ");
        try { //Hacemos un try-catch para tener en cuenta la excepción
            System.out.print(dividir(num1, num2));
        } catch (DivisionPorCeroException e) {
            System.out.print(e.getMessage());
        }
    }


    //Funciones estáticas
    public static double pedirNumero(String mensaje) {
        return input.pedirDecimal(mensaje);
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double restar(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) throws DivisionPorCeroException {
        //Si el dividendo es 0 lanza la excepción
        if (b == 0) {
            throw new DivisionPorCeroException("No se puede dividir por 0");
        } else {
            return a / b;
        }
    }
}