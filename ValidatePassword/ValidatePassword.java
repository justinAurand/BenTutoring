import java.util.Scanner;

public class ValidatePassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = "";
        boolean valid = false;

        while(!valid) {
            System.out.println("Enter your password:");
            password = scan.nextLine();

            if (!IsLongEnough(password))
                continue;
            if (!HasNoSpaces(password))
                continue;
            // Check contains a letter, number, and symbol

            valid = true;
        }
    }

    private static boolean IsLongEnough(String pw) {
        if (pw.length() < 8) {
            System.out.println("Password must be at least 8 characters in length.");
            return false;
        }
        return true;
    }

    private static boolean HasNoSpaces(String pw) {
        if (pw.contains(" ")) {
            System.out.println("Password cannot contain spaces.");
            return false;
        }
        return true;
    }

    private static boolean HasALetterNumberAndSymbol(String pw) {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] numbers = "0123456789".toCharArray();
        char[] symbols = "~!@#$%^&*()_+{}|<>?".toCharArray();
        return false;
    }
}
