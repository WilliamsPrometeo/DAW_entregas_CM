import java.util.Scanner;

/*
Clase de Scanner para leer los datos
*/
class MyScanner {
    private Scanner scanner;

    public MyScanner() {
        scanner = new Scanner(System.in);
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
