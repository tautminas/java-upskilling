public class Park extends Point {
    private String name;

    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.printf("Render %s National Park as POINT (%s)%n", name, location());
    }
}
