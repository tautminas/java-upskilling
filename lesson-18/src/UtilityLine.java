public class UtilityLine implements Mappable {
    private final String name;
    private final UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type.name().replace("_", " ") + ")";
    }

    @Override
    public String getMarker() {
        return type.getMarker();
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
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
