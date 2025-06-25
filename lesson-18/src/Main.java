import java.util.ArrayList;

    /*
     1. The interface challenge
     In this challenge, we'll be working on creating some mappable output.
     Most things, when drawn on a map, fall into three categories, a point, a
     line, or a polygon or geometric shape.
     The result of your code will be text that could be printed out to a file, for
     exchanging data with a mapping application.
     One such file is a specially formatted file, called geojson, which is a JSON
     file extended for geographical elements.
     You don't have to know geojson to be successful at this challenge.

     For this challenge, you'll simply create a String for every feature that will be
     mapped.
     An example of such a String is:
     “properties” : { “name” : “Sakala keskus”, “usage” : ”Entertainment” }

     First, Create a Mappable Interface.
     The interface should force classes to implement three methods.
     • One method should return a label (how the item will be described on the
     map).
     • One should return a geometry type (POINT or LINE) which is what the
     type will look like on the map.
     • The last should return an icon type (sometimes called a map marker).

     In addition to the three methods described, the interface should also include:
     • A constant String value called JSON_PROPERTY, which is equal to:
     „properties“ : { %s }. A hint here, using a text block will help maintain
     quotation marks in your output.
     • Include a default method called toJSON() that prints out the type, label, and
     marker.
     • A static method, that takes a Mappable instance as an argument. This
     method should print out the properties for each mappable type, including
     those mentioned above, but also any other fields on the business classes.

     You'll also have to create at least two classes that implement this interface,
     for example, a Building and a UtilityLine.
     One class, for example, the Building, should have a geometry type of
     POINT, and another class, for example, the UtilityLine, should have a
     geometry type of LINE.
     The first class will be shown as a point on a city map with the icon and label
     specified and the other class will be a line on the map.

     Your final output should look something like shown below.
     You should output the geometry type, the icon information, and the label.
     Here is an example for a building, including type, label, and marker, but also
     the building name and usage, which are fields on building.
     “properties” : { “type” : “POINT”, “label” : “Sakala
     keskus (ENTERTAINMENT)”, “marker” : “ORANGE STAR”,
     “name”: “Sakala keskus”, “usage” : “ENTERTAINMENT” }

     And here is an example for a fiber optic Utility line, so a LINE, a green
     dotted line, would get drawn for a fiber optic cable on Karamelli street.
     “properties” : { “type” : “LINE”, “label” :
     ”Karamelli tänav (FIBER_OPTIC)”, “marker” : “GREEN
     DOTTED”, “name” : “Karamelli tänav”, “utility” :
     “FIBER_OPTIC” }
     You can see that the properties are a comma delimited list, in curly braces,
     with the property or field name in quotes, then a colon, followed by the
     property value or field value, and that's also in double quotes, as JSON
     format requires.

     On the Mappable interface you can have
     one constant, JSON_PROPERTY, and 3
     abstract methods, getLabel, getMarker, and
     getShape.
     You can also include a default method,
     toJSON, which is going to return a String.
     The getShape method returns an enum
     type, Geometry, and the valid types on this
     enum are LINE, POINT, and POLYGON.

     Use enums for Color, and the PointMarker
     and LineMarker types.
     Two business classes to be mapped,
     Building and UtilityLine.
     For building, use an enum to describe the
     building type.
     For the UtilityLine, Use enum to describe
     the type of utility it is.

     The main method:
     ArrayList<Mappable> mappables = new ArrayList<>();

	 mappables.add(new Building("Tallinna Raekoda", UsageType.GOVERNMENT));
	 mappables.add(new Building("Sakala keskus", UsageType.ENTERTAINMENT));
	 mappables.add(new Building("Kalevi Keskstaadion", UsageType.SPORTS));
	 mappables.add(new UtilityLine("Tallinna Teletorn", UtilityType.FIBER_OPTIC));
	 mappables.add(new UtilityLine("Ülemiste järv", UtilityType.WATER));

	 for (Mappable m : mappables) {
 		 Mappable.mapIt(m);
	 }

     A possible output:
     "properties":{"type": "POINT", "label": "Tallinna Raekoda (GOVERNMENT)", "marker": "RED STAR", "name": "Tallinna Raekoda", "usage": "GOVERNMENT"}
     "properties":{"type": "POINT", "label": "Sakala keskus (ENTERTAINMENT)", "marker": "GREEN TRIANGLE", "name": "Sakala keskus", "usage": "ENTERTAINMENT"}
     "properties":{"type": "POINT", "label": "Kalevi Keskstaadion (SPORTS)", "marker": "ORANGE PUSH_PIN", "name": "Kalevi Keskstaadion", "usage": "SPORTS"}
     "properties":{"type": "LINE", "label": "Tallinna Teletorn (FIBER OPTIC)", "marker": "GREEN DOTTED", "name": "Tallinna Teletorn", "utility": "FIBER_OPTIC"}
     "properties":{"type": "LINE", "label": "Ülemiste järv (WATER)", "marker": "BLUE SOLID", "name": "Ülemiste järv", "utility": "WATER"}
    */

public class Main {
    public static void main(String[] args) {
        ArrayList<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Tallinna Raekoda", BuildingType.GOVERNMENT));
        mappables.add(new Building("Sakala keskus", BuildingType.ENTERTAINMENT));
        mappables.add(new Building("Kalevi Keskstaadion", BuildingType.SPORTS));
        mappables.add(new UtilityLine("Tallinna Teletorn", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Ülemiste järv", UtilityType.WATER));

        for (Mappable m : mappables) {
            Mappable.mapIt(m);
        }
    }
}
