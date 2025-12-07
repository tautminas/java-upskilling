import java.time.*;

public class CourseEngagement {
    private final Course course;
    private final LocalDate enrollmentDate;

    private int lastLecture;
    private LocalDate lastActivity;

    public CourseEngagement(Course course, LocalDate enrollmentDate) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.lastLecture = 0;
        this.lastActivity = enrollmentDate;
    }

    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public int getLastLecture() { return lastLecture; }
    public LocalDate getLastActivity() { return lastActivity; }

    public long getMonthsSinceActive() {
        return Period.between(lastActivity, LocalDate.now()).toTotalMonths();
    }

    public double getPercentComplete() {
        return (100.0 * lastLecture) / course.getLectureCount();
    }

    public void watchLecture(int lectureNumber, LocalDate activityDate) {
        this.lastLecture = Math.max(this.lastLecture, lectureNumber);
        this.lastActivity = activityDate;
    }

    @Override
    public String toString() {
        return "%s: %d/%d lectures, last active %s".formatted(
                course.getCode(), lastLecture, course.getLectureCount(), lastActivity);
    }
}