public class Challenge2 {

    /*
     2. A leap year
     Write a program, which takes in an int variable with a year and tells a user if it’s a
     leap year or not. Can make it a method, if you feel comfortable doing so.
     You may find the full leap year calculation algorithm on this Wikipedia page:
     https://en.wikipedia.org/wiki/Leap_year
    */

    public static void run(int year) {
        boolean leapYear = isLeapYear(year);
        if (leapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }

    private static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
