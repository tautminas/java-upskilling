package localandanonymousclasses;

    /*
     2. Local and anonymous classes
     First, you need to create a record named Employee, that contains a first
     name, a last name, and a hire date.
     Setup a list of Employees with various names and hire dates in the main
     method.
     Setup a new method that takes this list of Employees as a parameter.
     Create a local class in this method (pass Employee to the constructor and
     include a field for this), and add some calculated fields, such as full name,
     and years worked.

     Create a list of employees using your local class.
     Create an anonymous class to sort your local class employees, by full name,
     or years worked.
     Print the sorted list.
    */

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Hanno", "Kalda", LocalDate.of(2013, 5, 10)),
                new Employee("Jenni", "Jarv", LocalDate.of(2009, 3, 15)),
                new Employee("Kaarel", "Mets", LocalDate.of(2015, 7, 20)),
                new Employee("Lembe", "Laht", LocalDate.of(2009, 3, 15)),
                new Employee("Liisi", "Rand", LocalDate.of(2018, 11, 5)),
                new Employee("Pille", "Jogi", LocalDate.of(1998, 1, 30))
        );

        processEmployees(employees);
    }

    private static void processEmployees(List<Employee> employees) {

        class LocalEmployee {
            private Employee employee;
            private String fullName;
            private int yearsWorked;

            public LocalEmployee(Employee employee) {
                this.employee = employee;
                this.fullName = employee.firstName() + " " + employee.lastName();
                this.yearsWorked = Period.between(employee.hireDate(), LocalDate.now()).getYears();
            }

            public String getFullName() {
                return fullName;
            }

            public int getYearsWorked() {
                return yearsWorked;
            }

            @Override
            public String toString() {
                return fullName + " has been an employee for " + yearsWorked + " years";
            }
        }

        List<LocalEmployee> localEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            localEmployees.add(new LocalEmployee(emp));
        }

        localEmployees.sort(new Comparator<LocalEmployee>() {
            @Override
            public int compare(LocalEmployee e1, LocalEmployee e2) {
                return e1.getFullName().compareTo(e2.getFullName());
            }
        });

        System.out.println("Sorted by name:");
        localEmployees.forEach(System.out::println);

        System.out.println();

        localEmployees.sort(new Comparator<LocalEmployee>() {
            @Override
            public int compare(LocalEmployee e1, LocalEmployee e2) {
                return Integer.compare(e1.getYearsWorked(), e2.getYearsWorked());
            }
        });

        System.out.println("Sorted by years worked:");
        localEmployees.forEach(System.out::println);
    }
}
