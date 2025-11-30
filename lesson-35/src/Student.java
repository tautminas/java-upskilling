import java.time.*;
import java.util.*;

public class Student {
    private final int id;
    private final String countryCode;
    private final int yearEnrolled;
    private final int ageAtEnroll;
    private final String gender;
    private final boolean hadExperience;

    private final Map<String, CourseEngagement> engagements = new HashMap<>();

    public Student(int id, String countryCode, int yearEnrolled,
                   int ageAtEnroll, String gender, boolean hadExperience,
                   Course... courses)
    {
        this.id = id;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.ageAtEnroll = ageAtEnroll;
        this.gender = gender;
        this.hadExperience = hadExperience;

        LocalDate enrollDate = LocalDate.of(yearEnrolled, 1, 1);

        for (Course c : courses) {
            engagements.put(c.getCode(), new CourseEngagement(c, enrollDate));
        }
    }

    public int getId() { return id; }
    public String getCountryCode() { return countryCode; }
    public int getYearEnrolled() { return yearEnrolled; }
    public int getAgeAtEnroll() { return ageAtEnroll; }
    public String getGender() { return gender; }
    public boolean hadExperience() { return hadExperience; }

    public int getYearsSinceEnrolled() {
        return Year.now().getValue() - yearEnrolled;
    }

    public int getAge() {
        return ageAtEnroll + getYearsSinceEnrolled();
    }

    public long getMonthsSinceActive(String courseCode) {
        return engagements.get(courseCode).getMonthsSinceActive();
    }

    public long getMonthsSinceActive() {
        return engagements.values().stream()
                .mapToLong(CourseEngagement::getMonthsSinceActive)
                .min().orElse(0);
    }

    public double getPercentComplete(String courseCode) {
        CourseEngagement ce = engagements.get(courseCode);
        return ce == null ? 0 : ce.getPercentComplete();
    }

    public void addCourse(Course c, LocalDate date) {
        engagements.put(c.getCode(), new CourseEngagement(c, date));
    }

    public void addCourse(Course c) {
        addCourse(c, LocalDate.now());
    }

    public void watchLecture(String courseCode, int lecture, int year, int month) {
        LocalDate d = LocalDate.of(year, month, 1);
        engagements.get(courseCode).watchLecture(lecture, d);
    }

    public static Student getRandomStudent(Course... courses) {
        Random r = new Random();

        int id = r.nextInt(10000, 99999);
        String[] countries = {"US", "UK", "DE", "IN", "PL", "CA", "FR"};
        String country = countries[r.nextInt(countries.length)];
        int yearEnr = r.nextInt(2005, 2022);
        int age = r.nextInt(18, 65);
        String gender = r.nextBoolean() ? "M" : "F";
        boolean exp = r.nextBoolean();

        Student s = new Student(id, country, yearEnr, age, gender, exp, courses);

        for (Course c : courses) {
            int lecture = 30 + r.nextInt(Math.max(1, c.getLectureCount() - 29));
            int year = r.nextInt(yearEnr, 2024);
            int month = r.nextInt(1, 12);
            s.watchLecture(c.getCode(), lecture, year, month);
        }
        return s;
    }

    @Override
    public String toString() {
        return """
		Student %d (%s), Age %d, Enrolled %d, Gender %s, Exp: %s
		Engagements: %s
		""".formatted(id, countryCode, getAge(), yearEnrolled, gender, hadExperience,
                engagements.values());
    }
}