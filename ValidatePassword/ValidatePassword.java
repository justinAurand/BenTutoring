import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter your password:");
            password = scan.nextLine();

            if (!IsLongEnough(password))
                continue;
            if (HasASpace(password))
                continue;
            if (!HasLetterNumberAndSymbol(password))
                continue;
            if (StartsWithExclamation(password))
                continue;
            if (EndsWithHyphen(password))
                continue;
            if (HasThreeConsecutiveCharacters(password))
                continue;

            valid = true;
        }

        String confirmPassword = "";
        boolean equal = false;

        while (!equal) {
            System.out.println("Confirm password:");
            confirmPassword = scan.nextLine();

            if (!confirmPassword.equals(password)) {
                System.out.println("Passwords do not match.");
                continue;
            }

            equal = true;
        }

        System.out.println("Confirmed.");
    }

    private static boolean IsLongEnough(String pw) {
        if (pw.length() < 8) {
            System.out.println("Password must be at least 8 characters in length.");
            return false;
        }
        return true;
    }

    private static boolean HasASpace(String pw) {
        if (pw.contains(" ")) {
            System.out.println("Password cannot contain spaces.");
            return true;
        }
        return false;
    }

    private static boolean HasLetterNumberAndSymbol(String pw) {
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        char[] symbols = "~!@#$%^&*()_+{}|<>?".toCharArray();

        boolean hasLetter = HasIntersetion(pw, letters);
        boolean hasNumber = HasIntersetion(pw, numbers);
        boolean hasSymbol = HasIntersetion(pw, symbols);

        if (!hasLetter || !hasNumber || !hasSymbol) {
            System.out.println("Password must contain a letter, number, and symbol.");
            return false;
        }
        return true;
    }

    private static boolean HasIntersetion(String pw, char[] values) {
        for (int i = 0; i < values.length; i++) {
            String value = Character.toString(values[i]);
            if (pw.contains(value))
                return true;
        }
        return false;
    }

    private static boolean StartsWithExclamation(String pw) {
        if (pw.startsWith("!")) {
            System.out.println("Password cannot start with an exclamation point.");
            return true;
        }
        return false;
    }

    private static boolean EndsWithHyphen(String pw) {
        if (pw.endsWith("-")) {
            System.out.println("Password cannot end with a hyphen.");
            return true;
        }
        return false;
    }

    private static boolean HasThreeConsecutiveCharacters(String pw) {
        char[] pass = pw.toCharArray();
        for (int i = 0; i < pass.length; i++)
        {
            if (i + 2 >= pass.length)
                break;

            if (pass[i] == pass[i+1] && pass[i+1] == pass[i+2]) {
                System.out.println("Password cannot contain three consecutive characters.");
                return true;
            }
        }
        return false;
    }
}
