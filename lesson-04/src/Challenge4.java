public class Challenge4 {

    /*
     4. Zodiac signs
     Write a method that takes in a date and returns a zodiac sign as a String.
     Use the enhanced switch statement as an expression.
     Write 3 different versions of the method using method overloading for different ways to pass in a date.
    */

    public static void run(int month, int day) {
        System.out.println(getZodiacSign(month, day));
    }

    public static void run(int year, int month, int day) {
        System.out.println(getZodiacSign(year, month, day));
    }

    public static void run(String date) {
        System.out.println(getZodiacSign(date));
    }

    private static String getZodiacSign(int month, int day) {
        return switch (month) {
            case 1 -> (day <= 19) ? "Capricorn" : "Aquarius";
            case 2 -> (day <= 18) ? "Aquarius" : "Pisces";
            case 3 -> (day <= 20) ? "Pisces" : "Aries";
            case 4 -> (day <= 19) ? "Aries" : "Taurus";
            case 5 -> (day <= 20) ? "Taurus" : "Gemini";
            case 6 -> (day <= 20) ? "Gemini" : "Cancer";
            case 7 -> (day <= 22) ? "Cancer" : "Leo";
            case 8 -> (day <= 22) ? "Leo" : "Virgo";
            case 9 -> (day <= 22) ? "Virgo" : "Libra";
            case 10 -> (day <= 22) ? "Libra" : "Scorpio";
            case 11 -> (day <= 21) ? "Scorpio" : "Sagittarius";
            case 12 -> (day <= 21) ? "Sagittarius" : "Capricorn";
            default -> "Invalid month";
        };
    }

    private static String getZodiacSign(String date) {
        String[] parts = date.split("-");
        if (parts.length != 3) {
            return "Invalid date format";
        }
        try {
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            return getZodiacSign(month, day);
        } catch (Exception e) {
            return "An unexpected error occurred";
        }
    }

    private static String getZodiacSign(int year, int month, int day) {
        return getZodiacSign(month, day);
    }
}