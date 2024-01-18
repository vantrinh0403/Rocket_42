package util;

import java.util.Scanner;

public class ScannerUtil {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static String inputString() {

        return SCANNER.nextLine()
                .trim()
                .replaceAll("\\s+", " ");
    }

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage() + ". Enter input INT");
            }
        }
    }


    public static String inputFullName() {
        return inputString();
    }

    public static String inputEmail() {
        return inputString();
    }
}
