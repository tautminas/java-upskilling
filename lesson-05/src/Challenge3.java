public class Challenge3 {

    /*
     3. Digit sum
     Write a method that sums digits of a number. It should take in type int and should
     return an int. The method should only take a positive number. If a
     negative number is passed, it should return -1, meaning, an invalid value was passed.
     The method should parse out each digit from the number and sum the digits up.
     So, if 125 is the value passed to the method, the code should sum each digit,
     in this case, 1 + 2 + 5, and return 8, as a value. If the number is a single digit
     number, simply return the number itself as the result.
    */

    public static void run(int num) {
        int sum = digitSum(num);
        System.out.println("The sum of digits for " + num + " is: " + sum);
    }

    private static int digitSum(int num) {
        if (num < 0) {
            return -1;
        }

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}