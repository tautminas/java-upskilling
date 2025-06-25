public enum UtilityType {
    ELECTRICAL(Color.BLACK, LineMarker.DASHED),
    FIBER_OPTIC(Color.GREEN, LineMarker.DOTTED),
    WATER(Color.BLUE, LineMarker.SOLID);

    private final Color color;
    private final LineMarker marker;

    UtilityType(Color color, LineMarker marker) {
        this.color = color;
        this.marker = marker;
    }

    public String getMarker() {
        return color + " " + marker;
    }
}
