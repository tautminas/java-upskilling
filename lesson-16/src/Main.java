import java.util.*;

    /*
     1. Places to visit
     Using LinkedList functionality create a list of places, ordered by distance from the starting point.
     Use a ListIterator to move, both backwards and forwards, through this ordered itinerary of
     places. First, create a type that has a town name and a field for storing the distance from the
     start. Next, create an itinerary of towns to visit. Create a LinkedList, ordered by the distance from
     Tallinn. Tallinn should be the first element in your list. You don't want to allow duplicate places to
     be in your list for this data set.

     An example list of towns. You may use any other list of your choice.
     Town      Distance
     ------------------
     Parnu     127
     Tartu     179
     Viljandi  147
     Voru      246
     Polva     224

     Create an interactive program with the following menu item options:
     Available actions (select word or letter):
     (F)orward
     (B)ackword
     (L)ist Places
     (M)enu
     (Q)uit

     Use a Scanner and the nextLine method to get input from the console. Use a ListIterator to move
     forwards and backwards through the list of places on your itinerary.
     When we change directions, we must compensate for the cursor being ahead of where we want it to
     be. So, we must make the call, either next or previous, twice. The first time to adjust the cursor, and
     the second time to get the element.
    */

class Place {
    private String town;
    private int distance;

    public Place(String town, int distance) {
        this.town = town;
        this.distance = distance;
    }

    public String getTown() {
        return town;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return this.town + " (" + this.distance + " km)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Place)) return false;
        Place other = (Place) obj;
        return this.town.equalsIgnoreCase(other.town);
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Place> places = new LinkedList<>();
        addPlace(places, new Place("Tallinn", 0));
        addPlace(places, new Place("Parnu", 127));
        addPlace(places, new Place("Tartu", 179));
        addPlace(places, new Place("Viljandi", 147));
        addPlace(places, new Place("Voru", 246));
        addPlace(places, new Place("Polva", 224));

        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = places.listIterator();
        boolean goingForward = true;

        printMenu();

        boolean quit = false;
        while (!quit) {
            System.out.print("Enter action: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "F":
                case "FORWARD":
                    if (!goingForward) {
                        if (iterator.hasNext()) iterator.next();
                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("Reached the end of the list.");
                    }
                    break;

                case "B":
                case "BACKWARD":
                    if (goingForward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                    }
                    break;

                case "L":
                case "LIST":
                    printPlaces(places);
                    break;

                case "M":
                case "MENU":
                    printMenu();
                    break;

                case "Q":
                case "QUIT":
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid option. Type 'M' to see the menu.");
            }
        }

        System.out.println("Program ended.");
    }

    public static void printMenu() {
        System.out.println("\nAvailable actions (select word or letter):");
        System.out.println("(F)orward");
        System.out.println("(B)ackward");
        System.out.println("(L)ist Places");
        System.out.println("(M)enu");
        System.out.println("(Q)uit\n");
    }

    public static void printPlaces(LinkedList<Place> places) {
        System.out.println("Itinerary:");
        for (Place place : places) {
            System.out.println(" - " + place);
        }
    }

    public static void addPlace(LinkedList<Place> list, Place newPlace) {
        for (Place place : list) {
            if (place.equals(newPlace)) {
                System.out.println("Duplicate found: " + newPlace.getTown() + " not added.");
                return;
            }
        }

        int index = 0;
        for (Place place : list) {
            if (newPlace.getDistance() < place.getDistance()) {
                list.add(index, newPlace);
                return;
            }
            index++;
        }
        list.add(newPlace);
    }
}
