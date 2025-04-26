public class Main {

    /*
     1. A space investigator
     Write a method spaceInvestigator, which would take a String as an argument, and which would
     check and fix the usage of spaces in a text, returning a fixed text as a String.
     The rules for using spaces can be found here:
     https://www.noslangues-ourlanguages.gc.ca/en/writing-tips-plus/punctuation-spacing
     Check and fix as many rules, as you can, but it must be at least 6 different rules.
     You may want to create a separate method for each step, which will be called from the method
     spaceInvestigator. Print a report on each step.
     Create an example String, which would contain all the errors you will be checking against.

     Here are some of the rules, which you may want to check for:
     • There should be no spaces before and after the text.
     • There should never be no two spaces standing together, one after another.
     • There must be a space after a punctuation mark (with some exceptions).
     • There should not be no space before a punctuation mark (with some exceptions).
     • There should be no space before or after a decimal period between numerals.
     • There should be no space before or after a question or exclamation mark that is followed by a
     closing quotation mark, parenthesis or bracket.
     • There should be no space before or after a comma that is followed by a closing quotation
     mark.
     • There should be no space before or after dashes and hyphens when they are inserted between
     words, a word and a numeral, or two numerals.
    */

    public static void main(String[] args) {
        String textWithErrors = "  Hello  ,world!  How  are  you ?I am fine...  Really  ! ( Amazing  , isn't it ? )  3 . 14 -  5-6 ";
        System.out.println("Original text:\n" + textWithErrors + "\n");

        String fixedText = spaceInvestigator(textWithErrors);

        System.out.println("\nFinal fixed text:\n" + fixedText);
    }

    public static String spaceInvestigator(String text) {
        text = removeLeadingAndTrailingSpaces(text);              // Point 1
        text = removeDoubleSpaces(text);                          // Point 2
        text = addSpaceAfterPunctuation(text);                    // Point 3
        text = removeSpaceBeforePunctuation(text);                // Point 4
        text = fixDecimalPoints(text);                            // Point 5
        text = fixSpaceAroundQuestionExclamation(text);           // Point 6
        text = fixSpaceAroundCommaBeforeQuote(text);              // Point 7
        text = fixSpaceAroundDashesAndHyphens(text);              // Point 8
        return text;
    }

    private static String removeLeadingAndTrailingSpaces(String text) {
        String result = text.trim();
        System.out.println("Step 1: Removed leading and trailing spaces.");
        return result;
    }

    private static String removeDoubleSpaces(String text) {
        String result = text.replaceAll("\\s{2,}", " ");
        System.out.println("Step 2: Removed multiple spaces between words.");
        return result;
    }

    private static String addSpaceAfterPunctuation(String text) {
        String result = text.replaceAll("([.,!?:;])(?![\\s\"')\\]])", "$1 ");
        System.out.println("Step 3: Added space after punctuation if missing.");
        return result;
    }

    private static String removeSpaceBeforePunctuation(String text) {
        String result = text.replaceAll("\\s+([.,!?:;])", "$1");
        System.out.println("Step 4: Removed space before punctuation.");
        return result;
    }

    private static String fixDecimalPoints(String text) {
        String result = text.replaceAll("(\\d)\\s*\\.\\s*(\\d)", "$1.$2");
        System.out.println("Step 5: Fixed spaces around decimal points.");
        return result;
    }

    private static String fixSpaceAroundQuestionExclamation(String text) {
        String result = text.replaceAll("([?!])\\s+(?=[\"')\\]])", "$1");
        System.out.println("Step 6: Fixed spaces around question/exclamation marks before closing quotes/brackets.");
        return result;
    }

    private static String fixSpaceAroundCommaBeforeQuote(String text) {
        String result = text.replaceAll("\\s+,\\s+(?=\")", ",");
        System.out.println("Step 7: Fixed spaces around commas before closing quotation marks.");
        return result;
    }

    private static String fixSpaceAroundDashesAndHyphens(String text) {
        String result = text.replaceAll("\\s*-\\s*", "-");
        System.out.println("Step 8: Fixed spaces around dashes and hyphens.");
        return result;
    }
}