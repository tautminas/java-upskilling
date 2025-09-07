import java.util.*;
import java.util.function.*;

    /*
     1. Method references
     First, create an array of names, in mixed case, as you did in the previous
     challenge. Create a list of Function or UnaryOperator interfaces, which will
     contain all the operations you want executed on each name in your array.
     Do something like what we did in the previous challenge:
     ∙ Make each name upper case,
     ∙ Add a random middle initial,
     ∙ Add a last name, which should be the reverse of the first.

     In addition to this, add some custom transformations of your own. Use a
     mix of lambda expressions, and method references. Create a method that
     takes the name array, and the function list, and applies each function to
     each name, using the transform method on String, to do this. All changes
     should be applied to the original array. Make sure you explore as many
     transformations as you can, trying as many different types of method
     references as you can think of.
    */

public class Main {

    public static void main(String[] args) {
        String[] names = {
                "arVo","lIIsa","jaNis","lIgA","JoNaS","mInDaUgAs","emMa","nILs"
        };

        List<UnaryOperator<String>> transformations = new ArrayList<>();

        transformations.add(String::toUpperCase);

        Random random = new Random();
        transformations.add(Main::addRandomInitial);

        transformations.add(Main::addReversedLastName);

        transformations.add(Main::addGreeting);

        for (UnaryOperator<String> func : transformations) {
            applyTransformation(names, func);
            System.out.println(Arrays.toString(names));
        }
    }

    private static void applyTransformation(String[] arr, UnaryOperator<String> func) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].transform(func);
        }
    }

    private static String addRandomInitial(String name) {
        Random random = new Random();
        char initial = (char) ('A' + random.nextInt(26));
        return name + " " + initial + ".";
    }

    private static String addReversedLastName(String name) {
        String first = name.split(" ")[0];
        String reversed = new StringBuilder(first).reverse().toString();
        return name + " " + reversed;
    }

    private static String addGreeting(String name) {
        return "What's up, " + name;
    }
}
