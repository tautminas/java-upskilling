package busstops;

public record BusStop(String id, String name, double latitude, double longitude, String area) {

    public static double getDistance(BusStop a, BusStop b) {
        final int R = 6371;

        double latDistance = Math.toRadians(b.latitude - a.latitude);
        double lonDistance = Math.toRadians(b.longitude - a.longitude);
        double lat1 = Math.toRadians(a.latitude);
        double lat2 = Math.toRadians(b.latitude);

        double aVal = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(aVal), Math.sqrt(1 - aVal));
        return R * c;
    }

    public static boolean isSameArea(BusStop a, BusStop b) {
        return a.area.equalsIgnoreCase(b.area);
    }
}