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

    public static boolean hasNextLine() {
        return KEYBOARD.hasNextLine();
    }
}
