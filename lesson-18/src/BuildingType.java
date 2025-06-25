public enum BuildingType {
    BUSINESS(Color.BLACK, PointMarker.CIRCLE),
    ENTERTAINMENT(Color.GREEN, PointMarker.DIAMOND),
    GOVERNMENT(Color.RED, PointMarker.STAR),
    SPORTS(Color.ORANGE, PointMarker.PUSH_PIN);

    private final Color color;
    private final PointMarker marker;

    BuildingType(Color color, PointMarker marker) {
        this.color = color;
        this.marker = marker;
    }

    public String getMarker() {
        return color + " " + marker;
    }
}