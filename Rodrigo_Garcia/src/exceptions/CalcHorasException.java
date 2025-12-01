package exceptions;

/* se crea automáticamente el código de la excepción con el nombre 'CalcHorasException' que le hemos dado
nuestro papel será borrar el 'Runtime' para pasar de la excepción verificada a una no verificada */

public class CalcHorasException extends Exception {
    public CalcHorasException(String message) {
        super(message);
    }
}