public class Main {
    public static void main(String[] args) {

        // for (;;) {
        // }
        // It is an infinite loop because the omitted condition is always treated as true

        // ===================================================

        // Enhanced for loop
        int[] numbers = {1, 2, 3};
        for (int num : numbers) {
            System.out.println(num);
        }

        // ===================================================

        System.out.println();
        System.out.println("Challenge 1:");
        Challenge1.run(10, 50);
        System.out.println("Challenge 2:");
        Challenge2.run(5);
        System.out.println("Challenge 3:");
        Challenge3.run(123);
        System.out.println("Challenge 4:");
        Challenge4.run(12321);
        System.out.println("Challenge 5:");
        Challenge5.run(10);

    }
}