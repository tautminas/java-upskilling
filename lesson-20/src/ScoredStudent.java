public class ScoredStudent extends Student {
    private double percentComplete;

    public ScoredStudent(String name, String course, int year, int studentId, double percentComplete) {
        super(name, course, year, studentId);
        this.percentComplete = percentComplete;
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String field, Object value) {
        if (field.equalsIgnoreCase("percent")) {
            return this.percentComplete <= (double) value;
        }
        return super.matchFieldValue(field, value);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [%.1f%% done]", percentComplete);
    }
}
