package employees;

import java.util.Calendar;

public class Worker {
    private String name;
    private String birthDate;
    private String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        String[] birthDateParts = birthDate.split("-");
        int birthYear = Integer.parseInt(birthDateParts[0]);
        int birthMonth = Integer.parseInt(birthDateParts[1]);
        int birthDay = Integer.parseInt(birthDateParts[2]);

        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

        int age = currentYear - birthYear;

        if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }

        return age;
    }

    public double collectPay() {
        return 0.0;
    }

    public void terminate(String endDate) {
        this.endDate = endDate;
        System.out.println(name + " terminated on " + endDate);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Birth Date: " + birthDate;
    }
}
