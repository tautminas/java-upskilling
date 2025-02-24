public class Challenge3 {

    /*
     3. A barking dog
     Write a method shouldWakeUp that has 2 parameters.
     1st parameter should be of type boolean and be named barking it represents if our
     dog is currently barking.
     2nd parameter represents the hour of the day and is of type int with the name
     hourOfDay and has a valid range of 0-23.
     We must wake up if the dog is barking before 8 or after 22 hours so in that case
     return true.
     In all other cases return false.
     If the hourOfDay parameter is less than 0 or greater than 23 return false.
    */

    public static void run(boolean barking, int hourOfDay) {
        boolean wakeUp = shouldWakeUp(barking, hourOfDay);
        System.out.println("Should wake up: " + wakeUp);
    }

    private static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        return barking && (hourOfDay < 8 || hourOfDay > 22);
    }
}
