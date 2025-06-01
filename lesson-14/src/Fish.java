package pondmodel;

import java.util.Random;

public class Fish extends Weed {

    public Fish(int x, int y) {
        super(x, y);
    }

    @Override
    public void randomLifecycle(Object[][] pond) {}

    public void move(Object[][] pond) {
        int width = pond[0].length;
        int height = pond.length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Random rand = new Random();
        int dir = rand.nextInt(4);

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && nx < width && ny >= 0 && ny < height && pond[ny][nx] == null) {
            pond[ny][nx] = this;
            pond[y][x] = null;
            x = nx;
            y = ny;
        }
    }
}
