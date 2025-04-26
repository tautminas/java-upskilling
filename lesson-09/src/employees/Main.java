package employees;

public class Main {

    /*
     1. Employees
     Create the Worker class, the Employee class, the
     SalariedEmployee and the HourlyEmployee class.
     For each class, create the attributes and methods
     shown on this diagram.
     Create a main method that will create a
     SalariedEmployee and a HourlyEmployee, and call
     the methods getAge, collectPay, and the methods
     shown for the subclasses, retire and
     getDoublePay.

     A salaried employee is paid based on some percentage of his or her annual salary.
     If this person is retired, then the salary may be 100 percent of this amount, but it is generally
     reduced somewhat.
     An hourly employee is paid by the hours worked and the hourly rate they agreed to work for.
     An hourly employee may also get double pay if they work over a certain number of hours.

     Each method call made on these objects points to
     the code that will be executed.
     When Liisi or Priit call getAge(), the method's
     implementation is on Worker and is not overridden
     by any other class, so the getAge method on
     Worker is executed.
     When Liisi or Priit call toString(), this method has
     been overridden twice, first by Worker, and then by
     Employee. But it wasn't overridden by either
     SalariedEmployee or HourlyEmployee, so the
     method from the Employee class is the one that's
     used.

     Looking at the collectPay method, this method was
     overridden by both SalariedEmployee, and
     HourlyEmployee.
     Liisi will execute the method on SalariedEmployee.
     Priit will execute the one on HourlyEmployee.
     SalariedEmployee has a method, retire, that's not
     overridden, meaning it's only in that class; it's a
     method specific to a salaried employee.
     HourlyEmployee has its own method, getDoublePay,
     which wouldn't apply to a salaried employee, so we
     declared it in this class and not in any super class.
    */

    public static void main(String[] args) {
        SalariedEmployee liisi = new SalariedEmployee("Liisi", "1985-01-01", 1001L, "2020-01-01", 60000, false);
        HourlyEmployee priit = new HourlyEmployee("Priit", "1990-02-02", 1002L, "2022-02-02", 25);

        System.out.println("Liisi's age: " + liisi.getAge());
        System.out.println("Liisi's pay: " + liisi.collectPay());
        System.out.println("Liisi's retirement pay: " + liisi.retire());

        System.out.println("Priit's age: " + priit.getAge());
        System.out.println("Priit's pay: " + priit.collectPay());
        System.out.println("Priit's double pay: " + priit.getDoublePay());

        liisi.terminate("2030-01-01");
        priit.terminate("2035-02-02");
    }
}