public class Customer {

    /*
     3. Customer
     Create a new class, called Customer, with three fields:
     • name
     • credit limit
     • email address.
     Create the getter methods only for each field. You don't need to create the setters.

     Create three constructors for this class:
     • First, create a constructor for all three fields which should assign the arguments
     directly to the instance fields.
     • Second, create a no-args constructor that calls another constructor, passing
     some literal values for each argument.
     • And lastly, create a constructor with just the name and email parameters, which
     also calls another constructor.
    */

    private String name;
    private double creditLimit;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Customer(String name, double creditLimit, String emailAddress) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public Customer() {
        this("Default Name", 1000.0, "default@example.com");
    }

    public Customer(String name, String emailAddress) {
        this(name, 500.0, emailAddress);
    }
}
