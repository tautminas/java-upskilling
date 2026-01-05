import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

    /*
     1. Reading text from a file
     In this challenge, pick some text of your choice, from a document you have, or an online article,
     or some wiki page.
     You'll create a program to read the text document, with one of the methods we talked about in
     the last couple of lectures. You can pick any method you want to use, but whichever you use,
     your program should do the following:
     • Tokenize the text into words, remove any punctuation.
     • Ignore words with 5 characters or less (or any other more meaningful filter).
     • Count the occurrences of each word.
     • Display the top 10 most used words.
     After you use one method, try a second method. If you used a method that used a stream, try
     some code without using a streaming method, or vice versa.
    */

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("=== STREAM VERSION ===");
        streamVersion("text.txt");

        System.out.println("\n=== NON-STREAM VERSION ===");
        classicVersion("text.txt");
    }

    private static void streamVersion(String fileName) throws IOException {

        Map<String, Long> wordCount =
                Files.lines(Path.of(fileName))
                        .map(line -> line.toLowerCase()
                                .replaceAll("[^a-z ]", ""))
                        .flatMap(line -> Arrays.stream(line.split("\\s+")))
                        .filter(word -> word.length() > 5)
                        .collect(Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()
                        ));

        wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue()));
    }

    private static void classicVersion(String fileName) throws IOException {

        Map<String, Integer> wordCount = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z ]", "");
            String[] words = line.split("\\s+");

            for (String word : words) {
                if (word.length() > 5) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < Math.min(10, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " -> " + list.get(i).getValue());
        }
    }
}
