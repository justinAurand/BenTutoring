import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter your password:");
            password = scan.nextLine();

            if (!isLongEnough(password))
                continue;
            if (hasASpace(password))
                continue;
            if (!hasLetterNumberAndSymbol(password))
                continue;
            if (startsWithExclamation(password))
                continue;
            if (endsWithHyphen(password))
                continue;
            if (hasThreeConsecutiveCharacters(password))
                continue;

            valid = true;
        }

        String confirmPassword = "";
        boolean equal = false;

        while (!equal) {
            System.out.println("Confirm password:");
            confirmPassword = scan.nextLine();

            if (!match(password, confirmPassword))
                continue;

            equal = true;
        }

        System.out.println("Confirmed.");
    }

    private static boolean isLongEnough(String pw) {
        if (pw.length() < 8) {
            System.out.println("Password must be at least 8 characters in length.");
            return false;
        }
        return true;
    }

    private static boolean hasASpace(String pw) {
        if (pw.contains(" ")) {
            System.out.println("Password cannot contain spaces.");
            return true;
        }
        return false;
    }

    private static boolean hasLetterNumberAndSymbol(String pw) {
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        char[] symbols = "~!@#$%^&*()_+{}|<>?".toCharArray();

        boolean hasLetter = hasIntersetion(pw, letters);
        boolean hasNumber = hasIntersetion(pw, numbers);
        boolean hasSymbol = hasIntersetion(pw, symbols);

        if (!hasLetter || !hasNumber || !hasSymbol) {
            System.out.println("Password must contain a letter, number, and symbol.");
            return false;
        }
        return true;
    }

    private static boolean hasIntersetion(String pw, char[] values) {
        for (int i = 0; i < values.length; i++) {
            String value = Character.toString(values[i]);
            if (pw.contains(value))
                return true;
        }
        return false;
    }

    private static boolean startsWithExclamation(String pw) {
        if (pw.startsWith("!")) {
            System.out.println("Password cannot start with an exclamation point.");
            return true;
        }
        return false;
    }

    private static boolean endsWithHyphen(String pw) {
        if (pw.endsWith("-")) {
            System.out.println("Password cannot end with a hyphen.");
            return true;
        }
        return false;
    }

    private static boolean hasThreeConsecutiveCharacters(String pw) {
        char[] pass = pw.toCharArray();
        for (int i = 0; i + 2 < pass.length; i++)
            if (pass[i] == pass[i+1] && pass[i+1] == pass[i+2]) {
                System.out.println("Password cannot contain three consecutive characters.");
                return true;
            }
        return false;
    }

    private static boolean match(String pw, String cpw) {
        if (!cpw.equals(pw)) {
            System.out.println("Passwords do not match.");
            return false;
        }
        return true;
    }
}
