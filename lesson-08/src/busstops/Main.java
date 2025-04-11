package busstops;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    /*
     3. Bus stops
     Write a record BusStop, which would have instance fields id, name, latitude, longitude
     and area, and have two static methods: double getDistance, which would return a
     distance between two bus stops, and boolean isSameArea, which would check if two
     bus stations are in the same area.
     Use Haversine formula to calculate the distance between two bus stops:
     https://en.wikipedia.org/wiki/Haversine_formula
     In the Main class create a method, which would read data from a CSV file stops.txt
     available from the address peatus.ee/gtfs/ (need to download and unzip the gtfs.zip file)
     and return an instance of a record BusStop with a data of a random bus stop. May use
     Scanner class to read individual values from the CSV text line.
     In the main method of the Main class create a loop which would create several pairs of
     instances of record BusStop, calculate distances between them and check if they belong
     to the same area.
    */

    public static void main(String[] args) {
        String filePath = "./src/busstops/stops.txt";
        int pairCount = 3;

        for (int i = 0; i < pairCount; i++) {
            String randomLine1 = getRandomLine(filePath);
            String randomLine2 = getRandomLine(filePath);

            if (randomLine1 != null && randomLine2 != null) {
                BusStop stop1 = createBusStopFromLine(randomLine1);
                BusStop stop2 = createBusStopFromLine(randomLine2);

                if (stop1 != null && stop2 != null) {
                    double distance = BusStop.getDistance(stop1, stop2);
                    boolean sameArea = BusStop.isSameArea(stop1, stop2);

                    System.out.println("----------------------");
                    System.out.println("Pair " + (i + 1) + ":");
                    System.out.println("----------------------");
                    System.out.println("Stop 1: " + stop1.name() + " (" + stop1.area() + ")");
                    System.out.println("Stop 2: " + stop2.name() + " (" + stop2.area() + ")");
                    System.out.printf("Distance: %.2f km%n", distance);
                    System.out.println("Same area: " + sameArea);
                    System.out.println("----------------------\n");
                } else {
                    System.out.println("Error creating BusStop objects.");
                }
            } else {
                System.out.println("Could not get two random lines.");
            }
        }
    }

    public static String getRandomLine(String filePath) {
        int lineCount = 0;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return null;
        }

        if (lineCount < 1) {
            return null;
        }

        Random random = new Random();
        int index = random.nextInt(lineCount);

        String selectedLine = null;
        int currentIndex = 0;

        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (currentIndex == index) {
                    selectedLine = line;
                    break;
                }
                currentIndex++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return null;
        }

        return selectedLine;
    }

    public static BusStop createBusStopFromLine(String line) {
        String[] parts = line.split(",", -1);

        if (parts.length >= 8) {
            String id = parts[0];
            String name = parts[2];
            double lat = Double.parseDouble(parts[3]);
            double lon = Double.parseDouble(parts[4]);
            String area = parts[7];

            return new BusStop(id, name, lat, lon, area);
        }
        return null;
    }

}
