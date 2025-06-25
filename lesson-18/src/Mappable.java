public interface Mappable {
    String JSON_PROPERTY = """
		"properties": { %s }
		""";

    String getLabel();
    String getMarker();
    Geometry getShape();

    default String toJSON() {
        return JSON_PROPERTY.formatted(
                "\"type\": \"" + getShape() + "\", " +
                        "\"label\": \"" + getLabel() + "\", " +
                        "\"marker\": \"" + getMarker() + "\""
        );
    }

    static void mapIt(Mappable mappable) {
        System.out.println(mappable.toJSON());
    }
}
