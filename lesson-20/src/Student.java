public class Student implements Comparable<Student> {
    private String name;
    private String course;
    private int year;
    private int studentId;

    public Student(String name, String course, int year, int studentId) {
        this.name = name;
        this.course = course;
        this.year = year;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.studentId, other.studentId); // natural order = id
    }

    @Override
    public String toString() {
        return "%s (id=%d, course=%s, year=%d)".formatted(name, studentId, course, year);
    }

    public boolean matchFieldValue(String field, Object value) {
        return switch (field.toLowerCase()) {
            case "id" -> this.studentId == (int) value;
            case "course" -> this.course.equalsIgnoreCase((String) value);
            case "year" -> this.year == (int) value;
            default -> false;
        };
    }
}
