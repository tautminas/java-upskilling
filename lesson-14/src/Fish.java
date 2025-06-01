import java.util.Random;

public class Fish extends Weed {
    private int starvationCounter = 0;
    private final int starvationLimit = 3;

    public Fish(int x, int y) {
        super(x, y);
    }

    @Override
    public void randomLifecycle(Object[][] pond) {}

    public void liveCycle(Object[][] pond) {
        if (!tryEatWeed(pond)) {
            moveRandomly(pond);
            starvationCounter++;
            if (starvationCounter >= starvationLimit) {
                pond[y][x] = null;
            }
        } else {
            starvationCounter = 0;
        }
    }

    private boolean tryEatWeed(Object[][] pond) {
        int width = pond[0].length;
        int height = pond.length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                if (pond[ny][nx] instanceof Weed && !(pond[ny][nx] instanceof Fish)) {
                    pond[ny][nx] = this;
                    pond[y][x] = null;
                    x = nx;
                    y = ny;
                    return true;
                }
            }
        }
        return false;
    }

    private void moveRandomly(Object[][] pond) {
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
