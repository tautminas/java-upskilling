public class River extends Line {
    private String name;

    public River(String name, String... points) {
        super(points);
        this.name = name;
    }

    @Override
    public void render() {
        System.out.printf("Render %s River as LINE (%s)%n", name, locations());
    }
}
