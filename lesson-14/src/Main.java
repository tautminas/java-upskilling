package pondmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;
        Object[][] pond = new Object[height][width];

        for (int y = 0; y < height; y++) {
            pond[y][0] = new Stone(y, 0);
            pond[y][width - 1] = new Stone(y, width - 1);
        }
        for (int x = 0; x < width; x++) {
            pond[0][x] = new Stone(0, x);
            pond[height - 1][x] = new Stone(height - 1, x);
        }

        placeRandomFish(pond, 5);
        placeRandomWeeds(pond, 10);

        System.out.println("Day 0");
        printPond(pond);
        System.out.println();

        for (int day = 1; day <= 10; day++) {
            List<Weed> weeds = new ArrayList<>();
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    if (pond[y][x] instanceof Weed weed) {
                        weeds.add(weed);
                    }
                }
            }
            for (Weed weed : weeds) {
                weed.randomLifecycle(pond);
            }

            List<Fish> fishes = new ArrayList<>();
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    if (pond[y][x] instanceof Fish fish) {
                        fishes.add(fish);
                    }
                }
            }
            for (Fish fish : fishes) {
                fish.liveCycle(pond);
            }

            System.out.println("Day " + day);
            printPond(pond);
            System.out.println();
        }
    }

    private static void placeRandomFish(Object[][] pond, int count) {
        Random rand = new Random();
        int width = pond[0].length;
        int height = pond.length;
        int placed = 0;

        while (placed < count) {
            int x = rand.nextInt(width - 2) + 1;
            int y = rand.nextInt(height - 2) + 1;
            if (pond[y][x] == null) {
                pond[y][x] = new Fish(x, y);
                placed++;
            }
        }
    }

    private static void placeRandomWeeds(Object[][] pond, int count) {
        Random rand = new Random();
        int width = pond[0].length;
        int height = pond.length;
        int placed = 0;

        while (placed < count) {
            int x = rand.nextInt(width - 2) + 1;
            int y = rand.nextInt(height - 2) + 1;
            if (pond[y][x] == null) {
                pond[y][x] = new Weed(x, y);
                placed++;
            }
        }
    }

    private static void printPond(Object[][] pond) {
        for (Object[] row : pond) {
            for (Object obj : row) {
                if (obj instanceof Fish) {
                    System.out.print("F ");
                } else if (obj instanceof Weed) {
                    System.out.print("W ");
                } else if (obj instanceof Stone) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
