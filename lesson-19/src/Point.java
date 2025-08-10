import java.util.Arrays;

public abstract class Point implements Mappable {
    private double[] location;

    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    protected String location() {
        return Arrays.toString(location);
    }
}
