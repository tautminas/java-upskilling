public class Challenge6 {

    /*
     6. Caesar cipher
     Write a method, which takes in a String with a message and returns a String with
     the message encrypted by the Caesar cipher method. Create two versions of this
     method. In the first version, the Caesar shift is provided as an int as a second
     parameter and in the second version some shift value is used automatically inside
     the method.
     For the algorithm details visit this page:
     https://en.wikipedia.org/wiki/Caesar_cipher
    */

    public static void run(String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("Caesar Cipher with key " + key + ": " + encryptedMessage);
    }

    public static void run(String message) {
        String encryptedMessage = encryptMessage(message);
        System.out.println("Caesar Cipher with default key (5): " + encryptedMessage);
    }

    private static String encryptMessage(String message, int key) {
        String encryptedMessage = "";

        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);

            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encryptedMessage += (char) ((character - base + key) % 26 + base);
            } else {
                encryptedMessage += character;
            }
        }

        return encryptedMessage;
    }

    private static String encryptMessage(String message) {
        return encryptMessage(message, 5);
    }
}
