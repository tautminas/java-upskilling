import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private static final Set<Task> managerTasks = Set.of(
            new Task("ProjectA", "Design DB schema", "", Priority.HIGH, Status.IN_QUEUE),
            new Task("ProjectB", "Implement login", "", Priority.HIGH, Status.IN_QUEUE),
            new Task("ProjectC", "Write unit tests", "", Priority.MED, Status.IN_QUEUE)
    );

    private static final Set<Task> annsTasks = Set.of(
            new Task("ProjectA", "Design DB schema", "Ann", Priority.HIGH, Status.IN_PROGRESS),
            new Task("ProjectD", "Refactor UI", "Ann", Priority.LOW, Status.ASSIGNED)
    );

    private static final Set<Task> bobsTasks = Set.of(
            new Task("ProjectB", "Implement login", "Bob", Priority.HIGH, Status.ASSIGNED),
            new Task("ProjectE", "Fix API bug", "Bob", Priority.MED, Status.IN_PROGRESS)
    );

    private static final Set<Task> carolsTasks = Set.of(
            new Task("ProjectC", "Write unit tests", "Carol", Priority.MED, Status.IN_PROGRESS),
            new Task("ProjectF", "Update docs", "Carol", Priority.LOW, Status.ASSIGNED)
    );

    public static Set<Task> getTasks(String name) {
        return switch (name.toLowerCase()) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> {
                Set<Task> all = new HashSet<>();
                all.addAll(managerTasks);
                all.addAll(annsTasks);
                all.addAll(bobsTasks);
                all.addAll(carolsTasks);
                yield all;
            }
            default -> managerTasks;
        };
    }
}
