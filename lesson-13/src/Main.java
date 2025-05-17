import arraymethods.ArrayMethods;
import java.util.Arrays;

public class Main {

    /*
     1. Array methods:
     • Write a method that would sort an array in a descending order.
     • Write a method that would remove all duplicates from an array.
     • Write a method that would find common elements between two arrays.
     • Write a method that would find the two elements in an array of positive and negative
     numbers such that their sum is closest to zero.
     • Write a method that would find the longest consecutive elements sequence from an
     unsorted array of integers. For example, if the sample array is [49, 1, 3, 200, 2, 4, 70, 5], then
     the longest consecutive elements sequence is [1, 2, 3, 4, 5].
     All methods should take in an array and return an array.
    */

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
