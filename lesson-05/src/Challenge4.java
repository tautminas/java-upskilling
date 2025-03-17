public class Challenge4 {

    /*
     4. Palindromic Numbers
     Write a method called isPalindrome with one int parameter called number. The
     method needs to return a boolean. It should return true if the number is a
     palindrome number otherwise it should return false. A palindrome number is a
     number which, when reversed, is equal to the original number. For example: 121,
     12321, 1001 etc.
    */

    public static void run(int number) {
        boolean isPalindrome = isPalindrome(number);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome);
    }

    private static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            reversedNumber = reversedNumber * 10 + lastDigit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }
}
