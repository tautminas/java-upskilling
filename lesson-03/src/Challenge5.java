public class Challenge5 {

    /*
     5. Seconds and minutes
     In this challenge, we're going to create a method, that takes time, represented in
     seconds, as the parameter.
     We'll then want to transform the seconds into hours. Next, you'll display the time in
     hours with the remaining minutes and seconds in a String. We'll do this
     transformation in two steps, which allows us to use overloaded methods.
     We want to create two methods with the same name: getDurationString. The first
     method has one parameter of type int, named seconds. The second method has
     two parameters, named minutes and seconds, both int.
     Both methods return a String in the format shown: ‘XXh YYm ZZs’ where XX
     represents the number of hours, YY the number of minutes, and ZZ the number of
     seconds. The first method should in turn call the second method to return its
     results. Add input validation to the methods as a bonus.
    */

    public static void run(int seconds) {
        String duration1 = getDurationString(seconds); // seconds as input
        System.out.println(duration1);
    }

    private static String getDurationString(int seconds) {
        if (seconds < 0) {
            return "Invalid input";
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }

    private static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || seconds >= 60) {
            return "Invalid input";
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + "h " + remainingMinutes + "m " + seconds + "s";
    }
}
