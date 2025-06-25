public class Building implements Mappable {
    private final String name;
    private final BuildingType type;

    public Building(String name, BuildingType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return type.getMarker();
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        String props = "\"type\": \"" + getShape() + "\", " +
                "\"label\": \"" + getLabel() + "\", " +
                "\"marker\": \"" + getMarker() + "\", " +
                "\"name\": \"" + name + "\", " +
                "\"type\": \"" + type + "\"";
        return JSON_PROPERTY.formatted(props);
    }
}
