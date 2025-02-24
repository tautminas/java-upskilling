public class Challenge2 {

    /*
     2. A byte converter
     Write a void method, which takes in a long variable, representing the number of
     bytes in data, which prints this number as a String using kilobytes, megabytes,
     gigabytes and terabytes.
    */

    public static void run(long bytes) {
        printConvertedBytes(bytes);
    }

    private static void printConvertedBytes(long bytes) {
        long KB = 1024;
        long MB = KB * 1024;
        long GB = MB * 1024;
        long TB = GB * 1024;

        long tb = bytes / TB;
        bytes %= TB;
        long gb = bytes / GB;
        bytes %= GB;
        long mb = bytes / MB;
        bytes %= MB;
        long kb = bytes / KB;
        bytes %= KB;

        String result = "";
        if (tb > 0) result += tb + " TB ";
        if (gb > 0) result += gb + " GB ";
        if (mb > 0) result += mb + " MB ";
        if (kb > 0) result += kb + " KB ";
        if (bytes > 0 || result.isEmpty()) result += bytes + " Bytes";
        System.out.println(result);
    }
}