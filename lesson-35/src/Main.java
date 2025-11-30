import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Course pbc = new Course("pbc", "Programming Basics", 50);
        Course jac = new Course("jac", "Java Advanced Class", 100);

        Course games = new Course("cgij", "Creating Games in Java", 40);

        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(pbc, jac))
                .limit(5000)
                .toList();

        double total = students.stream()
                .map(s -> s.getPercentComplete(jac.getCode()))
                .reduce(0.0, Double::sum);

        double jacAverage = total / students.size();
        System.out.println("Average % complete in JAC = " + jacAverage);

        double threshold = jacAverage * 1.25 * 0.75;

        List<Student> filtered = students.stream()
                .filter(s -> s.getPercentComplete(jac.getCode()) > threshold)
                .toList();

        List<Student> top10 = filtered.stream()
                .sorted(Comparator.comparing(Student::getMonthsSinceActive))
                .limit(10)
                .toList();

        top10.forEach(s -> s.addCourse(games, LocalDate.now()));

        System.out.println("\nNew course assigned to:");
        top10.forEach(s -> System.out.println("Student " + s.getId()));
    }
}
