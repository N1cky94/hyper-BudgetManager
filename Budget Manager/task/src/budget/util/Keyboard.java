package budget.util;

import java.util.Scanner;

public class Keyboard {
    private static final Scanner KEYBOARD = new Scanner(System.in);

    private Keyboard() {

    }

    public static String requestNextProvidedLine() {
        return KEYBOARD.nextLine();
    }

    public static String requestInput(String message) {
        System.out.println(message);
        return requestNextProvidedLine();
    }

    public static int requestNextInt() {
        return Integer.parseInt(KEYBOARD.nextLine());
    }

    public static int requestNextInt(String message) {
        System.out.println(message);
        return requestNextInt();
    }

    public static double requestNextDouble() {
        return Double.parseDouble(KEYBOARD.nextLine());
    }

    public static double requestNextDouble(String message) {
        System.out.println(message);
        return requestNextDouble();
    }

    public static boolean hasNextLine() {
        return KEYBOARD.hasNextLine();
    }
}
