import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Task> allTasks = TaskData.getTasks("all");
        Set<Task> annTasks = TaskData.getTasks("Ann");
        Set<Task> bobTasks = TaskData.getTasks("Bob");
        Set<Task> carolTasks = TaskData.getTasks("Carol");

        System.out.println("=== Full Task List ===");
        printSortedSet(allTasks);

        Set<Task> assignedTasks = getUnion(Arrays.asList(annTasks, bobTasks, carolTasks));
        System.out.println("\n=== Assigned Tasks ===");
        printSortedSet(assignedTasks);

        Set<Task> unassigned = getDifference(allTasks, assignedTasks);
        System.out.println("\n=== Unassigned Tasks ===");
        printSortedSet(unassigned);

        Set<Task> annBob = getIntersect(annTasks, bobTasks);
        Set<Task> annCarol = getIntersect(annTasks, carolTasks);
        Set<Task> bobCarol = getIntersect(bobTasks, carolTasks);

        Set<Task> multipleAssigned = getUnion(Arrays.asList(annBob, annCarol, bobCarol));
        System.out.println("\n=== Multiple Employees Assigned ===");
        printSortedSet(multipleAssigned);
    }

    private static void printSortedSet(Set<Task> tasks) {
        List<Task> list = new ArrayList<>(tasks);
        Collections.sort(list);
        for (Task t : list) {
            System.out.println(t);
        }
    }

    public static Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> s : sets) {
            union.addAll(s);
        }
        return union;
    }

    public static Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>();
        for (Task t : set1) {
            if (set2.contains(t)) {
                intersect.add(t);
            }
        }
        return intersect;
    }

    public static Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> diff = new HashSet<>();
        for (Task t : set1) {
            if (!set2.contains(t)) {
                diff.add(t);
            }
        }
        return diff;
    }
}
