package pondmodel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int pondWidth = 10;
        int pondHeight = 10;

        List<Stone> stones = new ArrayList<>();
        List<Weed> weeds = new ArrayList<>();
        List<Fish> fishes = new ArrayList<>();

        int stoneCount = 2;
        int weedCount = 5;
        int fishCount = 4;
        for (int i = 0; i < stoneCount; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * pondWidth);
                y = (int) (Math.random() * pondHeight);
            } while (isOccupied(x, y, stones));

            stones.add(new Stone(x, y));
        }
        for (int i = 0; i < weedCount; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * pondWidth);
                y = (int) (Math.random() * pondHeight);
            } while (isOccupied(x, y, stones));

            Weed weed = new Weed(x, y);
            stones.add(weed);
            weeds.add(weed);
        }
        for (int i = 0; i < fishCount; i++) {
            int x, y;
            do {
                x = (int) (Math.random() * pondWidth);
                y = (int) (Math.random() * pondHeight);
            } while (isOccupied(x, y, stones));

            Fish fish = new Fish(x, y);
            stones.add(fish);
            fishes.add(fish);
        }

        System.out.println("Day 0");
        printPond(stones, pondWidth, pondHeight);
        for (int day = 1; day <= 10; day++) {
            System.out.println("Day " + day);

            for (Weed weed : weeds) {
                weed.randomLifecycle(stones, pondWidth, pondHeight);
            }

            for (int i = 0; i < weeds.size(); i++) {
                Weed weed = weeds.get(i);
                if (!weed.isAlive()) {
                    stones.remove(weed);
                    weeds.remove(i);
                    i--;
                }
            }

            for (Fish fish : fishes) {
                fish.move(stones, pondWidth, pondHeight);
            }

            printPond(stones, pondWidth, pondHeight);
        }
    }

    private static boolean isOccupied(int x, int y, List<Stone> stones) {
        for (Stone stone : stones) {
            if (stone.getX() == x && stone.getY() == y) {
                return true;
            }
        }
        return false;
    }

    private static void printPond(List<Stone> stones, int width, int height) {
        char[][] pond = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pond[i][j] = '.';
            }
        }

        for (Stone stone : stones) {
            if (!(stone instanceof Weed) && !(stone instanceof Fish)) {
                pond[stone.getY()][stone.getX()] = 'S';
            }
        }

        for (Stone stone : stones) {
            if (stone instanceof Weed) {
                Weed weed = (Weed) stone;
                if (weed.isAlive()) {
                    pond[stone.getY()][stone.getX()] = 'W';
                }
            }
        }

        for (Stone stone : stones) {
            if (stone instanceof Fish) {
                pond[stone.getY()][stone.getX()] = 'F';
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(pond[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
