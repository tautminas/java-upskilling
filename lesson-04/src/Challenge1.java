public class Challenge1 {

    /*
     1. Phonetic alphabet
     In this challenge, we'll be using the NATO phonetic alphabet to replace a character or letter
     with NATO's standardized word for that letter. In radio transmissions, the word "car" (C, A, R)
     would be read as "Charlie Alfa Romeo" for clarity. We'll take a single character and return
     the matching word from the NATO phonetic alphabet, as shown at the link below:
     https://en.wikipedia.org/wiki/NATO_phonetic_alphabet
    */

    public static void run(char letter) {
        letter = Character.toUpperCase(letter);

        String phoneticWord = switch (letter) {
            case 'A' -> "Alfa";
            case 'B' -> "Bravo";
            case 'C' -> "Charlie";
            case 'D' -> "Delta";
            case 'E' -> "Echo";
            case 'F' -> "Foxtrot";
            case 'G' -> "Golf";
            case 'H' -> "Hotel";
            case 'I' -> "India";
            case 'J' -> "Juliett";
            case 'K' -> "Kilo";
            case 'L' -> "Lima";
            case 'M' -> "Mike";
            case 'N' -> "November";
            case 'O' -> "Oscar";
            case 'P' -> "Papa";
            case 'Q' -> "Quebec";
            case 'R' -> "Romeo";
            case 'S' -> "Sierra";
            case 'T' -> "Tango";
            case 'U' -> "Uniform";
            case 'V' -> "Victor";
            case 'W' -> "Whiskey";
            case 'X' -> "X-ray";
            case 'Y' -> "Yankee";
            case 'Z' -> "Zulu";
            default -> "Invalid character";
        };

        System.out.println(phoneticWord);
    }
}