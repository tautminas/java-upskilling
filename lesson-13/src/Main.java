import arraymethods.ArrayMethods;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {5, -3, 1, 2, -3, 5, 3};
        int[] array2 = {3, 4, 5, 6, -3, 5, 4};

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));
        System.out.println();
        System.out.println("Sorted Descending (array1): " + Arrays.toString(ArrayMethods.sortDescending(array1)));
        System.out.println("Removed Duplicates (array1): " + Arrays.toString(ArrayMethods.removeDuplicates(array1)));
        System.out.println("Common Elements (array1 & array2): " + Arrays.toString(ArrayMethods.findCommonElements(array1, array2)));
        System.out.println("Closest to Zero (array1): " + Arrays.toString(ArrayMethods.closestToZero(array1)));
        System.out.println("Longest Consecutive Sequence (array2): " + Arrays.toString(ArrayMethods.longestConsecutiveSequence(array2)));
    }
}
