package pondmodel;

import java.util.List;
import java.util.Random;

public class Fish extends Weed {

    public Fish(int x, int y) {
        super(x, y);
    }

    public void move(List<Stone> stones, int pondWidth, int pondHeight) {
        Random rand = new Random();
        int newX = x;
        int newY = y;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int dir = rand.nextInt(4);
            int tx = x + dx[dir];
            int ty = y + dy[dir];

            if (tx >= 0 && tx < pondWidth && ty >= 0 && ty < pondHeight && !isOccupied(tx, ty, stones)) {
                newX = tx;
                newY = ty;
                break;
            }
        }

        this.x = newX;
        this.y = newY;
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
