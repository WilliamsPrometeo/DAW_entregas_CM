/*# 📘Proyecto 3: Gestión de Acceso a una Plataforma

## 📝 Enunciado

Se desea desarrollar una aplicación en **Java** que permita gestionar y validar los **datos de acceso a una plataforma online**.
La aplicación funcionará a través de un **menú interactivo por consola**, desde el cual el usuario podrá seleccionar distintas opciones relacionadas con la validación de credenciales.

El programa deberá ejecutarse de forma continua hasta que el usuario decida salir explícitamente.

---

## 📋 Funcionalidades del programa

El sistema mostrará un menú con las siguientes opciones:

1. **Validar identificador de acceso**
2. **Validar clave de seguridad**
3. **Salir**

El usuario deberá introducir una opción numérica.
Si se introduce un valor no numérico, el programa deberá capturar la excepción correspondiente y mostrar un mensaje de error adecuado.

---

## 🔐 Validación del identificador de acceso

Al seleccionar esta opción, el programa solicitará al usuario un **identificador de acceso** que deberá cumplir las siguientes condiciones:

- Tener **al menos 3 caracteres**
- Contener únicamente **letras y números**

Si el identificador cumple los requisitos, se mostrará el mensaje:

> *Validación correcta*

En caso contrario, se deberá lanzar una **excepción personalizada**, mostrar el mensaje de error y considerar la validación como incorrecta.

---

## 🔑 Validación de la clave de seguridad

Al seleccionar esta opción, el programa pedirá al usuario una **clave de seguridad** que deberá cumplir los siguientes criterios:

- Tener una longitud mínima de **6 caracteres**
- Contener **al menos un número**
- Contener **al menos una letra mayúscula**

Si la clave es válida, se indicará correctamente por pantalla.
Si no cumple las condiciones, se lanzará una **excepción personalizada** explicando el motivo del error.

---

## ⚙️ Requisitos técnicos

- Uso de **menú interactivo** con estructura repetitiva
- Uso de la clase `Scanner` para la entrada de datos
- Control de errores mediante **excepciones personalizadas**
- Manejo de excepciones estándar como `InputMismatchException`
- Uso de **expresiones regulares** para validar los datos
- Organización correcta del código en métodos

---

## 📊 Rúbrica de evaluación (10 puntos)

| Criterio                                                         | Puntuación    |
|------------------------------------------------------------------|---------------|
| Implementación correcta del menú interactivo                     | 2 puntos      |
| Validación correcta del identificador de acceso                  | 2 puntos      |
| Validación correcta de la clave de seguridad                     | 2 puntos      |
| Uso adecuado de excepciones personalizadas                       | 2 puntos      |
| Manejo correcto de errores de entrada (`InputMismatchException`) | 1 punto       |
| Uso correcto de expresiones regulares                            | 1 punto       |
| **TOTAL**                                                        | **10 puntos** |

---

📌 *Se valorará la claridad del código, el uso adecuado de métodos y la correcta gestión de excepciones.*
*/
package ejercicios;

import exceptions.InvalidAccessException;
import exceptions.InvalidPasswordException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionAccesoPlataforma {
    //Scanner
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Declaracion de variables
        int opcion;
        boolean flag = true;

        //Do while para que, aunque salte la excepcion siga pidiendo el menu (controlado con flag)
        do {
            //Try catch para la InputMissMatch Excepcion durante todo el codigo
            try {
                //Do while para mantenerse en el menu hasta que el usuario decida salir
                do {
                    //Asignamos el valor que retorna menu a una variable
                    opcion = menu();

                    //Switch para hacer una cosa u otra dependiendo de la opcion escogida
                    switch (opcion) {
                        case 1:
                            System.out.printf("%s", validarAcceso() != null ? "Validación correcta\n" : "Validación incorrecta\n");
                            break;
                        case 2:
                            System.out.printf("%s", validarClave() != null ? "Validación correcta\n" : "Validación incorrecta\n");
                            break;
                        default:
                            //El caso tres es el default ya que en menu ya controlamos que esté dentro del rango de 1 y 3
                            System.out.println("Saliendo del programa...");
                            flag = false; //Cambiamos el valor del bucle en el que está todo englobado
                            break;
                    }

                } while (opcion != 3);
            } catch (InputMismatchException e) { //Catcheamos la excepcion
                System.out.println("=============================");
                System.out.println("Debe introducir unicamente numeros");
                //Limpiamos el buffer para no entrar en un bucle infinito
                sc.nextLine();
            }
        } while (flag);
    }

    //Funcion menu que devolvera la opcion escogida
    public static int menu() {
        int op;

        //Do while para que el usuario unicamente pueda escoger opciones del 1 al 3
        do {
            System.out.print("""
                    
                    ===== GESTIÓN ACCESO PLATAFORMA =====
                    1. Validar identificador de acceso
                    2. Validar clave de seguridad
                    3. Salir
                    Seleccione una opción:""");
            op = sc.nextInt(); //Si se introduce una letra salta automaticamente la excepcion, esto ocurrirá durante todos los sc del codigo
            System.out.println("=============================");

            //Condicional para que, en el caso de que introduzca un numero no comprendido en el rango, sacar un texto indicandolo
            if (op > 3 || op < 0){
                System.out.println("Introduzca unicamente números del 1 al 3");
            }

            //Limpiar el salto de linea
            sc.nextLine();
        } while (op > 3 || op < 0);
        return op;
    }

    public static String validarAcceso() {
        //Hacemos un try-catch para controlar la excepcion de identificador de acceso incorrecto
        try {
            //Si todo sale bien retornamos el acceso
            return pideAcceso();
        } catch (InvalidAccessException e) {
            //Si salta la excepcion sacamos el mensaje y devolvemos null pra que en el main, el ternario se vuelva false
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String pideAcceso() throws InvalidAccessException{
        //Solicitamos el
        System.out.println("Introuce el nombre: ");
        String nombre = sc.nextLine();
        if (nombre.length() >= 3 && nombre.matches("[A-Za-z0-9]+")) {
            return nombre;
        }
        throw new InvalidAccessException("Identificador de acceso incorrecto. Debe tener 3 o más caracteres y ser unicamente alfanumerico.\n");
    }

    public static String validarClave() throws InputMismatchException{
        //Hacemos un try-catch para controlar la excepcion de clave de acceso incorrecta
        try {
            //Si todo sale bien retornamos la clave
            return pideClave();
        } catch (InvalidPasswordException e) {
            //Si salta la excepcion sacamos el mensaje y devolvemos null para que en el main, el ternario se vuelva false
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static String pideClave() throws InvalidPasswordException {
        System.out.println("Introuce el nombre: ");
        String password = sc.nextLine();
        if (password.length() >= 6 && password.matches(".*[0-9].*") && password.matches(".*[A-Z].*")){
            return password;
        }
        throw new InvalidPasswordException("Identificador de acceso incorrecto. Debe tener más de 5 caracteres y contener al menos una mayúscula.\n");
    }
}
