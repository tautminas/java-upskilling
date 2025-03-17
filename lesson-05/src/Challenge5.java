public class Challenge5 {

    /*
     5. Generate a password
     Write a method, which would generate a password of a given length, which would
     include numbers, small and capital letters, and special characters.
     A method should take in one int argument of minimum size 8 and return a String
     with a password.
     All positions and numbers of symbols in the password must be random, but there
     must be always at least one number, one small and one capital letter, and one
     special character.
     Use Math.random() to generate random numbers.
    */

    public static void run(int length) {
        if (length < 8) {
            System.out.println("Password length must be at least 8 characters.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Generated password: " + password);
    }

    private static String generatePassword(int length) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String password = "";
        password += getRandomCharacter(lowercase);
        password += getRandomCharacter(uppercase);
        password += getRandomCharacter(digits);
        password += getRandomCharacter(specialChars);

        String allChars = lowercase + uppercase + digits + specialChars;
        for (int i = password.length(); i < length; i++) {
            password += getRandomCharacter(allChars);
        }

        return shuffleString(password);
    }

    private static char getRandomCharacter(String chars) {
        int randomIndex = (int) (Math.random() * chars.length());
        return chars.charAt(randomIndex);
    }

    private static String shuffleString(String str) {
        char[] array = str.toCharArray();
        // Fisher-Yates shuffle algorithm
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndex = (int) (Math.random() * (i + 1));
            char temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return new String(array);
    }
}