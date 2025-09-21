import java.util.Objects;

public class Task implements Comparable<Task> {
    private String project;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;

    public Task(String project, String description, String assignee,
                Priority priority, Status status) {
        this.project = project;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public String getProject() { return project; }
    public String getDescription() { return description; }
    public String getAssignee() { return assignee; }
    public Priority getPriority() { return priority; }
    public Status getStatus() { return status; }

    public void setAssignee(String assignee) { this.assignee = assignee; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return project.equals(task.project) &&
                description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, description);
    }

    @Override
    public int compareTo(Task other) {
        int cmp = this.project.compareTo(other.project);
        if (cmp == 0) {
            return this.description.compareTo(other.description);
        }
        return cmp;
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | %s | %s | %s]",
                project, description, assignee, priority, status);
    }
}
