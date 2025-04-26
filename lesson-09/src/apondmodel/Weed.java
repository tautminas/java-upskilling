package pondmodel;

import java.util.List;
import java.util.Random;

public class Weed extends Stone {
    private boolean alive;

    public Weed(int x, int y) {
        super(x, y);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void grow() {
        alive = true;
    }

    public void die() {
        alive = false;
    }

    public void randomLifecycle(List<Stone> stones, int width, int height) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            if (alive) {
                growToAdjacent(stones, width, height);
            }
        } else {
            die();
        }
    }

    private void growToAdjacent(List<Stone> stones, int width, int height) {
        Random rand = new Random();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int dir = rand.nextInt(4);
            int tx = x + dx[dir];
            int ty = y + dy[dir];

            if (tx >= 0 && tx < width && ty >= 0 && ty < height && !isOccupied(tx, ty, stones)) {
                stones.add(new Weed(tx, ty));
                break;
            }
        }
    }

    private boolean isOccupied(int x, int y, List<Stone> stones) {
        for (Stone stone : stones) {
            if (stone.getX() == x && stone.getY() == y) {
                return true;
            }
        }
        return false;
    }
}
