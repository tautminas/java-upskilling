public class Challenge1 {

    /*
     1. Prime numbers
     Write a method which takes in two integer numbers and returns how many prime
     numbers are in a range between those two numbers.
    */

    public static void run(int start, int end) {
        int primeCount = countPrimesInRange(start, end);
        System.out.println("Number of prime numbers between " + start + " and " + end + ": " + primeCount);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countPrimesInRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
}
