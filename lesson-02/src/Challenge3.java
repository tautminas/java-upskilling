public class Challenge3 {

    /*
     3. Estonian ID code
     Write a program, which takes in a String variable with an Estonian ID code and tells
     a user if this ID code is correct or not. Can make it a method, if you feel comfortable
     doing so.
     See the instructions for calculating the check number in the chapter
     “Kontrollnumber” on this Wikipedia page (may need to translate it into your
     preferred language):
     https://et.wikipedia.org/wiki/Isikukood
    */

    public static void run(String idCode) {
        if (isValidIdCode(idCode)) {
            System.out.println(idCode + " is a valid Estonian ID code.");
        } else {
            System.out.println(idCode + " is not a valid Estonian ID code.");
        }
    }

    private static boolean isValidIdCode(String idCode) {
        return hasElevenDigits(idCode) &&
                isValidGender(idCode) &&
                isValidBirthMonth(idCode) &&
                isValidDayOfBirth(idCode) &&
                isValidControlNumber(idCode);
    }

    private static boolean hasElevenDigits(String idCode) {
        return idCode.matches("\\d{11}");
    }

    private static boolean isValidGender(String idCode) {
        int genderDigit = Integer.parseInt(idCode.substring(0, 1));
        return (genderDigit >= 1 && genderDigit <= 6);
    }

    private static boolean isValidBirthMonth(String idCode) {
        int monthOfBirth = Integer.parseInt(idCode.substring(3, 5));
        return (monthOfBirth >= 1 && monthOfBirth <= 12);
    }

    private static boolean isValidDayOfBirth(String idCode) {
        int dayOfBirth = Integer.parseInt(idCode.substring(5, 7));
        return (dayOfBirth >= 1 && dayOfBirth <= 31);
    }

    private static boolean isValidControlNumber(String idCode) {
        int controlNumber = Integer.parseInt(idCode.substring(10, 11));

        int[] level1Weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int controlSum = 0;
        for (int i = 0; i < 10; i++) {
            controlSum += Integer.parseInt(idCode.substring(i, i + 1)) * level1Weights[i];
        }
        int remainder = controlSum % 11;
        if (remainder < 10) {
            return remainder == controlNumber;
        }

        int[] level2Weights = {3, 4, 5, 6, 7, 8, 9, 1, 2, 3};
        controlSum = 0;
        for (int i = 0; i < 10; i++) {
            controlSum += Integer.parseInt(idCode.substring(i, i + 1)) * level2Weights[i];
        }
        remainder = controlSum % 11;
        return (remainder == controlNumber) || (remainder == 10 && controlNumber == 0);
    }
}
