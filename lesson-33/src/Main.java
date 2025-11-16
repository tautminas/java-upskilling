import java.util.stream.*;
import java.util.Arrays;

    /*
     1. The BINGO game

     In the BINGO game each ball is identified with either a letter “B”, “I”, “N”,
     “G” or “O”, followed by a number.
     A “B” ball will have a number from 1 to 15, an “I” ball will get a number
     between16 thru 30, and so on.
     Someone will draw a ball out of the container and announce it.
     Every player will have a five-by-five card, with some randomly generated
     set of these numbers on it.
     The first column has the “B” numbers, the second column has the “I”
     numbers, and so on.
     You win by being the first person to match five called numbers in a row,
     either horizontally, vertically, or diagonally.

     Generate the bingo ball labels as 5 different streams, using different Stream creation methods
     for each from the ones we mentioned in the class.
     Assign each pipeline to a stream variable. Concatenate the five streams together.
     Apply the terminal operation, forEach, to the final concatenated stream, to print each label.
     These should be printed in order as follows.
     B1-B15
     I16-I30
     N31-N45
     G45-G60
     O61-O75

     Remember that the map intermediate operation takes a Function, so you can return a different
     type, than the input stream element.
     To do this, you'd use map to return a String, by executing a method or expression that takes an
     integer and returns a String.
     The generate method may be difficult to use without creating side effects, or using other
     intermediate operations we haven't yet mentioned, but if you want a good challenge, you can
     play around with this one.
    */

public class Main {
    public static void main(String[] args) {

        Stream<String> bStream = IntStream.rangeClosed(1, 15)
                .mapToObj(n -> "B" + n);

        Stream<String> iStream = Stream.iterate(16, n -> n + 1)
                .limit(15)
                .map(n -> "I" + n);

        Integer[] nNums = IntStream.rangeClosed(31, 45).boxed().toArray(Integer[]::new);
        Stream<String> nStream = Stream.of(nNums)
                .map(n -> "N" + n);

        int[] gNums = IntStream.rangeClosed(46, 60).toArray();
        Stream<String> gStream = Arrays.stream(gNums)
                .mapToObj(n -> "G" + n);

        final int[] current = {61};
        Stream<String> oStream = Stream.generate(() -> current[0]++)
                .limit(15)
                .map(n -> "O" + n);

        Stream<String> allLabels = Stream.of(bStream, iStream, nStream, gStream, oStream)
                .flatMap(s -> s);

        allLabels.forEach(System.out::println);
    }
}
