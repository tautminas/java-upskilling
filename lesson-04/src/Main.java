public class Main {
    public static void main(String[] args) {

        int num = 2;

        // Traditional switch is a statement that doesn't return a value and requires break
        String traditionalSwitchResult;
        switch (num) {
            case 1:
                traditionalSwitchResult = "One";
                break;
            case 2:
                traditionalSwitchResult = "Two";
                break;
            default:
                traditionalSwitchResult = "Other";
        }

        // Enhanced switch is an expression that returns a value and can use yield
        String enhancedSwitchResult = switch (num) {
            case 1 -> "Uno";
            case 2 -> "Dos";
            default -> "Otro";
        };

        System.out.println("Results of switch statements: " + traditionalSwitchResult + ", " + enhancedSwitchResult);

        // ===================================================

        // The yield keyword in Java is used inside enhanced switch expressions when a case block (with {}) is needed to return a value

        int numberForYield = 3;

        String yieldResult = switch (numberForYield) {
            case 1 -> "One";
            case 2 -> "Two";
            default -> {
                System.out.println("Not 1 or 2!");
                yield "Other";
            }
        };
        System.out.println("Yield in a switch: " + yieldResult);

        // ===================================================
        System.out.println();
        System.out.println("Challenge 1:");
        Challenge1.run('t');
        System.out.println("Challenge 2:");
        Challenge2.run();
        System.out.println("Challenge 3:");
        Challenge3.run("+37061234567");
        Challenge3.run(37161234567L);
        System.out.println("Challenge 4:");
        Challenge4.run(1990, 3, 11);
        Challenge4.run("1990-3-11");
        Challenge4.run(3, 11);
        System.out.println("Challenge 5:");
        Challenge5.run(100.0, "GBP");
    }
}