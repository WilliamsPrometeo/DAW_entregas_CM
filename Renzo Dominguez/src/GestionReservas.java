import clases.Reserva;
import enums.TipoReserva;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionReservas
{
    private static final MyScanner sc = new MyScanner();
    private static Reserva[] reservas = new Reserva[30]; // array de constructores
    private static int contador = 0; // para recorrer un array manualmente

    public static void main(String[] args)
    {
        boolean exit;
        int opcion;
        do
        {
            opcion = menu();
            exit = seleccionarFuncion(opcion);

        } while (!exit);
    }

    public static int menu()
    {
        int opcion;

        opcion = sc.pedirNumero("-----Registros------" +
                "\n1. Añadir Reserva" +
                "\n2. Mostrar Reservas" +
                "\n3. Filtrar por año" +
                "\n4. Filtrar por mes" +
                "\n5. Filtrar por rango" +
                "\n6. Salir" +
                "\nIngrese la opcion: ");
        return opcion;
    }

    public static boolean seleccionarFuncion(int opcion)
    {
        boolean exit = false;

        switch (opcion)
        {
            case 1:
                addReserva();
                break;
            case 2:
                mostrarReservas();
                break;
            case 3:
                filtroYear();
                break;
            case 4:
                filtroMonth();
                break;
            case 5:
                filtroRango();
                break;
            case 6:
                System.out.println("Saliendo ....");
                exit = true;
                break;
            default:
                System.out.println("Opcion no valida!");
                break;
        }
        return exit;
    }

    public static void addReserva()
    {
        String fecha;
        LocalDate fechaReserva = null;
        boolean correcto;
        TipoReserva tipoReserva;
        String reservaID;
        String nombreCliente;

        // Ingresando la fecha de reserva por consola y guardandola en la variable fecha_reserva
        do
        {
            correcto = true;
            try
            {
                fecha = sc.pideTexto("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
                fechaReserva = LocalDate.parse(fecha);
            } catch(DateTimeParseException e){
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        // Obteniendo, de las opciones mostradas, el tipo de reserva y guardandolo en la variable tipoReserva
        tipoReserva = Utilidades.pedirEnum(TipoReserva.class, "Selecciona el tipo de registro: ");

        // Guardando el identificador de la reserva en la variable reservaID
        reservaID = sc.pideTexto("Ingrese el ID de la Reserva: ");

        // Guardando el nombre del cliente de la reserva en la variable nombreCliente
        nombreCliente = sc.pideTexto("Ingrese el nombre del cliente: ");

        // Creando los objetos(uno por uno) de cada elemento del array con:
        // fechaReserva , tipoReserva, reservaID y nombreCliente
        if (contador < reservas.length)
        {
            reservas[contador] = new Reserva(reservaID, nombreCliente , fechaReserva, tipoReserva);
            contador++;
        }
        else
        {
            System.out.println("La lista de reservas ya esta llena");
        }
    }

    public static void mostrarReservas()
    {
        if (contador == 0)
        {
            System.out.println("No hay registros para mostrar.");
            return;
        }

        for (int i = 0; i < contador; i++)
        {
            System.out.println(reservas[i]);
        }
    }

    public static void filtroYear()
    {
        int year;

        year = sc.pedirNumero("Ingrese el año para filtrar: ");
        obtenerRegistroPorAnio(year);
    }

    public static void filtroMonth()
    {
        int month;

        month = sc.pedirNumero("Ingrese el mes para filtrar");
        obtenerRegistroPorMes(month);
    }

    public static void filtroRango()
    {
        int min_year;
        int max_year;

        min_year = sc.pedirNumero("Ingrese el año minimo");
        max_year = sc.pedirNumero("Ingrese el año maximo");
        obtenerRegistroEnRango(min_year,max_year);
    }

    public static void  obtenerRegistroPorAnio(int year)
    {
        boolean encontrado = false;

        for (int i = 0; i < contador; i++)
        {
            if (reservas[i].getFechaReserva().getYear() == year)
            {
                System.out.println(reservas[i]);
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("No se encontraron registros para ese año.");
    }

    public static void obtenerRegistroPorMes(int month)
    {
        boolean encontrado = false;

        for (int i = 0; i < contador; i++)
        {
            if (reservas[i].getFechaReserva().getMonthValue() == month)
            {
                System.out.println(reservas[i]);
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("No se encontraron registros para ese mes.");

    }

    public static void obtenerRegistroEnRango(int min_year, int max_year)
    {
        int year;
        boolean encontrado = false;

        for (int i = 0; i < contador; i++)
        {
            year = reservas[i].getFechaReserva().getYear();

            if (year >= min_year && year <= max_year)
            {
                System.out.println(reservas[i]);
                encontrado = true;
            }
        }

        if (!encontrado)
            System.out.println("No se encontraron registros en ese rango.");
    }
}
