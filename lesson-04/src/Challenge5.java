public class Challenge5 {

    /*
     5. Currency rates
     Write two methods which would convert euros to any European currency which is not a euro and vice versa.
     Methods should take in an amount of money as a Double and a currency label as a String.
    */

    public static void run(double amount, String currency) {
        System.out.println("Converting from Euro to " + currency + ": " + String.format("%.2f", convertFromEuro(amount, currency)));
        System.out.println("Converting from " + currency + " to Euro: " + String.format("%.2f", convertToEuro(amount, currency)));
    }

    private static double convertFromEuro(double amount, String currency) {
        return switch (currency) {
            case "GBP" -> amount * 0.85;
            case "SEK" -> amount * 10.5;
            case "NOK" -> amount * 10.3;
            case "DKK" -> amount * 7.45;
            case "PLN" -> amount * 4.7;
            case "HUF" -> amount * 350;
            case "CZK" -> amount * 25.5;
            case "HRK" -> amount * 7.5;
            case "BGN" -> amount * 1.96;
            case "RON" -> amount * 4.9;
            case "ISK" -> amount * 150.0;
            case "CHF" -> amount * 0.96;
            default -> {
                System.out.println("Currency not supported.");
                yield 0.0;
            }
        };
    }

    private static double convertToEuro(double amount, String currency) {
        return switch (currency) {
            case "GBP" -> amount / 0.85;
            case "SEK" -> amount / 10.5;
            case "NOK" -> amount / 10.3;
            case "DKK" -> amount / 7.45;
            case "PLN" -> amount / 4.7;
            case "HUF" -> amount / 350;
            case "CZK" -> amount / 25.5;
            case "HRK" -> amount / 7.5;
            case "BGN" -> amount / 1.96;
            case "RON" -> amount / 4.9;
            case "ISK" -> amount / 150.0;
            case "CHF" -> amount / 0.96;
            default -> {
                System.out.println("Currency not supported.");
                yield 0.0;
            }
        };
    }
}