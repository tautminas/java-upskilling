public class Main {
    public static void main(String[] args) {

        // The most widely acknowledged Java coding standard is the Google Java Style Guide.

        // ===================================================

        // The return statement may be used to terminate execution of the void method at some earlier point than the end of the method block
        printWhenReady(false);

        // ===================================================

        // A method signature in Java consists of the method's name and the parameter list (which includes the number, type, and order of parameters), but does not include the return type or method modifiers (like public, private, etc.).
        // Method overloading occurs when two or more methods have the same name but differ in their method signatures.
        System.out.println("Overloading examples:");
        display();
        display(10);
        display("Hello");
        display(25, "Java");

        // ===================================================

        // Java does not support default values for method parameters, unlike many other languages (e.g., Python or C++)

        // ===================================================

        System.out.println();
        System.out.println("Challenge 1:");
        Challenge1.run(85);
        System.out.println("Challenge 2:");
        Challenge2.run(4100);
        System.out.println("Challenge 3:");
        Challenge3.run(true, 6);
        System.out.println("Challenge 4:");
        Challenge4.run(9);
        Challenge4.run(5, 8);
        System.out.println("Challenge 5:");
        Challenge5.run(3665);
        System.out.println("Challenge 6:");
        Challenge6.run("Hello World", 1);
    }

    static void printWhenReady(boolean isReady) {
        if (!isReady) {
            return;
        }
        System.out.println("Ready!");
    }

    static void display() {
        System.out.println("No parameters");
    }

    static void display(int number) {
        System.out.println("Integer parameter: " + number);
    }

    static void display(String text) {
        System.out.println("String parameter: " + text);
    }

    static void display(int number, String text) {
        System.out.println("Integer and String parameters: " + number + ", " + text);
    }
}
