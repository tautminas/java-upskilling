public class Challenge3 {

    /*
     3. Phone numbers
     Write a method, which takes in a phone number in a full format with a country code
     and returns a corresponding country name as a String. Add up to 10 countries which
     are relevant for our region. Use the enhanced switch statement as an expression.
     Write two versions of the method using method overloading for phone numbers in
     a String and a Long formats.
    */

    public static void run(Long phoneNumber) {
        System.out.println(getCountryByPhoneNumber(phoneNumber));
    }

    public static void run(String phoneNumber) {
        System.out.println(getCountryByPhoneNumber(phoneNumber));
    }

    private static String getCountryByPhoneNumber(Long phoneNumber) {
        String countryCode = phoneNumber.toString().substring(0, 3);

        return switch (countryCode) {
            case "370" -> "Lithuania";
            case "371" -> "Latvia";
            case "372" -> "Estonia";
            case "46"  -> "Sweden";
            case "47"  -> "Norway";
            case "45"  -> "Denmark";
            case "358" -> "Finland";
            case "48"  -> "Poland";
            case "49"  -> "Germany";
            case "420" -> "Czech Republic";
            default -> "Unknown country";
        };
    }

    private static String getCountryByPhoneNumber(String phoneNumber) {
        if (phoneNumber.startsWith("+")) {
            phoneNumber = phoneNumber.substring(1);
        }
        return getCountryByPhoneNumber(Long.parseLong(phoneNumber));
    }
}