import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

    /*
     1. Final stream challenge
     In this challenge, you'll again use Streams with the Student Engagement Code.
     Before you start, first change the getRandomStudent method on Student, to select a random
     number and random selection of courses.
     Every student should be enrolled and have activity in at least one course.
     Set up three or four courses, using the lecture count version of the constructor on several of
     these, to pass lecture counts greater than 40.
     Generate a list of 10,000 students who've enrolled in the past 4 years.
     Pass the Supplier Functional Interface code three or four courses.

     Next, answer the following questions.
     • How many of the students are enrolled in each course?
     • How many students are taking 1, 2, or 3 courses?
     • Determine the average percentage complete, for all courses, for this group of students. Hint,
     try using Collectors.averagingDouble to get this information.
     • For each course, get activity counts by year, using the last activity year field.
     Think about how you'd go about answering these questions, using some of the Stream
     operations you've learned, especially the collect terminal operation in conjunction with the
     Collectors helper class methods.
    */

public class Main {
    public static void main(String[] args) {

        Course pbc = new Course("pbc", "Programming Basics", 50);
        Course jac = new Course("jac", "Java Advanced Class", 80);
        Course games = new Course("cgij", "Creating Games in Java", 60);
        Course web = new Course("web", "Web Dev Essentials", 45);

        Course[] allCourses = { pbc, jac, games, web };

        List<Student> students = Stream.generate(() ->
                        Student.getRandomStudent(allCourses))
                .limit(10000)
                .toList();

        Map<String, Long> enrolledCounts = Arrays.stream(allCourses)
                .collect(Collectors.toMap(
                        Course::getCode,
                        c -> students.stream()
                                .filter(s -> s.getPercentComplete(c.getCode()) > 0)
                                .count()
                ));

        System.out.println("Students enrolled per course:");
        enrolledCounts.forEach((code, count) ->
                System.out.println("  " + code + ": " + count));
        System.out.println();

        Map<Integer, Long> courseCounts = students.stream()
                .collect(Collectors.groupingBy(
                        s -> (int) allCoursesCountFor(s, allCourses),
                        Collectors.counting()
                ));

        System.out.println("How many students take 1, 2, or 3 courses:");
        courseCounts.forEach((num, count) ->
                System.out.println("  " + num + " course(s): " + count));
        System.out.println();

        double avgPercent = students.stream()
                .flatMapToDouble(s ->
                        Arrays.stream(allCourses)
                                .mapToDouble(c -> s.getPercentComplete(c.getCode()))
                )
                .average()
                .orElse(0);

        System.out.println("Average % complete for all courses across all students = "
                + String.format("%.2f", avgPercent));
        System.out.println();

        System.out.println("Activity count per course by last activity year:");

        for (Course c : allCourses) {

            Map<Integer, Long> activityCounts =
                    students.stream()
                            .collect(Collectors.groupingBy(
                                    s -> lastActivityYear(s, c.getCode()),
                                    Collectors.counting()
                            ));

            System.out.println("\nCourse: " + c.getCode());
            activityCounts.forEach((year, count) ->
                    System.out.println("  " + year + ": " + count));
        }

    }

    private static long allCoursesCountFor(Student s, Course[] all) {
        return Arrays.stream(all)
                .filter(c -> s.getPercentComplete(c.getCode()) > 0)
                .count();
    }

    private static int lastActivityYear(Student s, String courseCode) {
        try {
            long months = s.getMonthsSinceActive(courseCode);
            LocalDate d = LocalDate.now().minusMonths(months);
            return d.getYear();
        } catch (Exception e) {
            return -1;
        }
    }
}
