public class Employee {
    int id;
    double salary;
    String firstName;
    String lastName;

    public Employee(int id, double salary, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Salary: " + salary +
                ", Name: " + firstName + " " + lastName;
    }
}
