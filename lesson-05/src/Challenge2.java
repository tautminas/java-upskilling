public class Challenge2 {

    /*
     2. Fibonacci numbers
     Write a boolean method which takes in an integer number and checks if it is a
     Fibonacci number.
     You can read what a Fibonacci number is here:
     https://en.wikipedia.org/wiki/Fibonacci_sequence
    */

    public static void run(int num) {
        boolean isFibonacci = isFibonacciNumber(num);
        System.out.println("Is " + num + " a Fibonacci number? " + isFibonacci);
    }

    private static boolean isFibonacciNumber(int num) {
        int a = 0;
        int b = 1;

        while (b < num) {
            int nextFib = a + b;
            a = b;
            b = nextFib;
        }

        return num == b;
    }
}
