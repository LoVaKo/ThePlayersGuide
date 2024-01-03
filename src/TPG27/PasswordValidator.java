package TPG27;

import java.util.Scanner;
public class PasswordValidator {
    public static boolean validatePassword(String password) {
        // Password length must be between 6 and 13 characters
        if (password.length() < 6 || password.length() > 13) return false;

        // Password cannot contain T or &.
        for (char ch : password.toCharArray()) {
            if (ch == 'T') return false;
            if (ch == '&') return false;
        }

        // Password must contain certain characters
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUppercase = true;
            if (Character.isLowerCase(ch)) hasLowercase = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUppercase && hasLowercase && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        while (true) {
            System.out.println("""
                    Password rules:
                    - Passwords must be at least 6 letters long and no more than 13 letters long.
                    - Passwords must contain at least one uppercase letter, one lowercase letter, and one number
                    - Passwords cannot contain a capital T or an ampersand (&)
                    
                      Please enter your password.""");
            password = scanner.nextLine();
            if (validatePassword(password)) {
                System.out.println("Password permitted.");
            } else {
                System.out.println("Password not allowed.");
            }
            System.out.println();
        }
    }
}
