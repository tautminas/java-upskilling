import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

    /*
     1. E-mail address validator
     Write a program that validates email addresses, based on a set of predefined rules. An email
     address should be formatted as username@domain.
     The username part of the email address can contain alphanumeric characters, so lowercase a to
     z, upper case A to Z, digits 0 to 9, dots or periods, underscores, and hyphens or dashes (-).
     The domain part of the email address can contain alphanumeric characters and digits, as well as
     periods or dashes, such as xyz.com, or abc-xyz.org, but could also be xyz.edu.ee for example.
     Your program should:
     • Use regular expressions and the Pattern class to compile the pattern.
     • Use the Matcher class to match the entered email address against the compiled pattern.
     • For valid email addresses, display the username and the domain name, using one of the
     group methods.
     Use examples of your own invention to test your code.
    */


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^([A-Za-z0-9._-]+)@([A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)+)$");

        while(true) {
            System.out.print("Enter an email (or 'quit'): ");
            String email = sc.nextLine();

            if(email.equalsIgnoreCase("quit")) break;

            Matcher matcher = pattern.matcher(email);

            if(matcher.matches()) {
                String username = matcher.group(1);
                String domain   = matcher.group(2);

                System.out.println("VALID email");
                System.out.println("Username = " + username);
                System.out.println("Domain   = " + domain);

            } else {
                System.out.println("INVALID email");
            }

            System.out.println();
        }

        sc.close();
    }
}
