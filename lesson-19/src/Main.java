    /*
     1. The generics class challenge
     In the Interface Challenge, we created a Mappable Interface and
     introduced you to different Map geometry types, POINT, LINE, and
     POLYGON.
     The challenge then created a map marker or icon, and a map label, but
     didn't do anything with locations.
     In this challenge, you'll use another Mapping example but use location data
     in the output.
     You can use Google Maps to determine the location of any point on a map.

     You'll start with a Mappable Interface, that has one abstract method,
     render. You'll create two classes Point and Line, that implement this
     interface.
     You'll create two specific classes that extend each of these, for a mappable
     item of interest. Use Google Maps to find coordinates of some national
     parks and rivers in your country, so the parks will be points, and the rivers
     will be lines. Create a Park class that extends Point, and a River class that
     extends Line, to support this data.

     You should have constructors or methods, to support adding a couple of
     attributes, and some location data, to your two specific classes. You can
     pass the location data of a point type, as a String, or a set of double values,
     representing latitude and longitude. You can pass the multiple locations of
     a line, as a set of strings, or a two-dimensional array of doubles, that
     represents the multiple points on your line.

     In addition to these classes, you'll create a generic class called Layer. Your
     Layer class should have one type parameter and should only allow
     Mappable elements as that type. This generic class should have a single
     private field, a list of elements to be mapped. This class should have a
     method or constructor, or both, to add elements. You should create a
     method, called renderLayer, that loops through all elements, and executes
     the method render, on each element.
     Your main method should create some instances of your specific classes,
     which include some location data. These should get added to a typed Layer,
     and the render Layer method called on that.

     You can see the Mappable interface has the method render on it, and by
     default that's both public and abstract. There is also a static method, that
     will take a String, and split it into a double array, which will have the
     latitude and longitude values in them. Make two classes, Point and Line,
     abstract, because we don't really want anyone to instantiate these classes.
     Point has a location field, which is a double array, and will just have two
     doubles, the latitude and longitude.

     Add a method that will print that array to a string, called location, then the
     render method is implemented. And the same with abstract Line, except a
     line will have multiple latitude, longitude pairs, and these will be
     represented as a two-dimensional array. Park class should extend Point,
     with just a name field, River should extend Line, and that has just a name as
     well, for simplicity. Lastly, there's the Layer class, this is the generic class,
     and it has a list of layerElements, and methods to add one or more of these.
     It also has the method, renderLayer.
    */

public class Main {
    public static void main(String[] args) {
        Park[] nationalParks = new Park[]{
                new Park("Pirita joeoru MKA", "59.47054, 24.865137"),
                new Park("Maealuse MKA", "59.519737, 24.872467"),
                new Park("Krillimae MKA", "59.538170, 24.820246"),
                new Park("Leidissoo LKA", "59.129381, 23.713533")
        };

        Layer<Park> parkLayer = new Layer<>(nationalParks);
        parkLayer.renderLayer();

        System.out.println();

        River[] rivers = new River[]{
                new River("Pirita jogi", "59.465427, 24.832956", "29.466783, 24.873256", "59.458080, 24.899915"),
                new River("Keila jogi", "59.403227, 24.280680", "59.384197, 24.314466", "59.367600, 24.350924")
        };

        Layer<River> riverLayer = new Layer<>(rivers);
        riverLayer.addElements(
                new River("Parnu jogi", "58.387391, 24.484892", "58.499331, 24.866929", "58.581174, 25.007622"),
                new River("Narva jogi", "59.462094, 28.056027", "59.382011, 28.209953", "59.354455, 28.192309")
        );
        riverLayer.renderLayer();
    }
}
