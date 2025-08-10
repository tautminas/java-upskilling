import java.util.Arrays;

public abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... points) {
        locations = new double[points.length][];
        for (int i = 0; i < points.length; i++) {
            locations[i] = Mappable.stringToLatLon(points[i]);
        }
    }

    protected String locations() {
        return Arrays.deepToString(locations);
    }
}
