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

    public void randomLifecycle(Object[][] pond) {
        if (Math.random() < 0.9) {
            growToAdjacent(pond);
        } else {
            pond[y][x] = null;
        }
    }

    private void growToAdjacent(Object[][] pond) {
        int width = pond[0].length;
        int height = pond.length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Random rand = new Random();
        int dir = rand.nextInt(4);

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && nx < width && ny >= 0 && ny < height && pond[ny][nx] == null) {
            pond[ny][nx] = new Weed(nx, ny);
        }
    }
}
