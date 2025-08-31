import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

    /*
     1. Lambdas in Arrays
     This challenge is designed to exercise your skills with methods on Arrays
     and ArrayLists, that are targets for lambda expressions.
     First, create an array of String, which is populated with first names, in
     mixed case.
     Include at least one name, which is spelled the same backwards, and
     forwards, like Anna.
     Use Arrays.setAll, or List.replaceAll, to change the values in this array.
     If you use List methods, you'll need a list backed by the array, so that
     changes get made to the initial array.

     Using one of those two methods, perform the following functions on the
     elements in the array, with appropriate lambda expressions.
     • Transform names to all uppercase.
     • Add a randomly generated middle initial and include a period.
     • Add a last name that is the reverse of the first name.
     Print your array or the array elements, after each change, using the forEach
     method, at least once.
     Finally, create a new modifiable ArrayList from your names array, removing
     any names where the last name equals the first name. Use removeIf with a
     lambda expression to perform this last operation.
    */

public class Main {
    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Charlie", "dAvE", "eve"};

        System.out.println("Original array:");
        Arrays.stream(names).forEach(System.out::println);

        List<String> nameList = Arrays.asList(names);

        nameList.replaceAll(name -> name.toUpperCase());
        System.out.println("\nAfter converting to uppercase:");
        nameList.forEach(System.out::println);

        nameList.replaceAll(name -> {
            char middleInitial = (char) ('A' + ThreadLocalRandom.current().nextInt(26));
            return name + " " + middleInitial + ".";
        });
        System.out.println("\nAfter adding random middle initials:");
        nameList.forEach(System.out::println);

        nameList.replaceAll(name -> {
            String[] parts = name.split(" ");
            String firstName = parts[0];
            StringBuilder reversed = new StringBuilder(firstName).reverse();
            return name + " " + reversed.toString();
        });
        System.out.println("\nAfter adding last names:");
        nameList.forEach(System.out::println);

        List<String> modifiableList = new ArrayList<>(Arrays.asList(names));

        modifiableList.removeIf(fullName -> {
            String[] parts = fullName.split(" ");
            if (parts.length >= 3) {
                String first = parts[0];
                String last = parts[2];
                return first.equals(last);
            }
            return false;
        });

        System.out.println("\nAfter removing names where first == last:");
        modifiableList.forEach(System.out::println);
    }
}
