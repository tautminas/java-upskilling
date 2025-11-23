import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        Course java = new Course("J101", "Java Masterclass", 50);
        Course python = new Course("P202", "Python Fundamentals", 40);
        Course js = new Course("JS301", "Modern JavaScript", 45);

        List<Student> students = Stream.generate(
                        () -> Student.getRandomStudent(java, python, js))
                .limit(200)
                .toList();

        long males = students.stream().filter(s -> s.getGender().equals("M")).count();
        long females = students.stream().filter(s -> s.getGender().equals("F")).count();
        System.out.println("Males: " + males);
        System.out.println("Females: " + females);

        System.out.println("\nAge ranges:");
        System.out.println("Under 30: " +
                students.stream().filter(s -> s.getAge() < 30).count());
        System.out.println("30-60: " +
                students.stream().filter(s -> s.getAge() >= 30 && s.getAge() <= 60).count());
        System.out.println("Over 60: " +
                students.stream().filter(s -> s.getAge() > 60).count());

        IntSummaryStatistics stats =
                students.stream().mapToInt(Student::getAge).summaryStatistics();

        System.out.println("\nAge Summary:");
        System.out.println(stats);

        System.out.println("\nCountries:");
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        boolean exists = students.stream().anyMatch(s ->
                s.getYearsSinceEnrolled() > 7 && s.getMonthsSinceActive() < 12
        );
        System.out.println("\nAny active >7 years? " + exists);

        System.out.println("\nSample (5 students):");
        students.stream()
                .filter(s -> s.getYearsSinceEnrolled() > 7)
                .filter(s -> s.getMonthsSinceActive() < 12)
                .limit(5)
                .forEach(System.out::println);
    }
}
