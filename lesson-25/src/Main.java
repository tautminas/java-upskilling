import java.util.*;

    /*
     1. Tasks
     You’ll need to create a class that represents a Task. It should have
     • an assignee.
     • a project name.
     • a task description.
     • a status (assigned, in progress, or not yet assigned).
     • a priority, High, Low, or Medium.
     Each of these attributes should be editable. A task is uniquely identified by
     its project name and description. The task should implement Comparable,
     so that tasks are sorted by project name and description.

     The TaskData class will be used to set up and return some test data.
     The data can be found in a CSV file and consists of the following:
     • All tasks identified by the manager.
     • Tasks identified by Ann, that she’s working on or plans to work on.
     • Tasks which Bob says have been assigned to him.
     • Tasks Carol is doing, as reported by herself.
     This class should have a getTasks method, that returns a Set of Task. This
     method should take a String, either the name of one of the employees to
     get a specific Set, or “all” to get the full task Set.

     This class diagram shows you the two classes.
     Task has five fields, two with enum types as shown.
     Task is unique by the project and description fields combined.
     Task implements comparable and is sorted by project then description.
     Some test data was set up on the TaskData class, and you can get this data
     by calling TaskData.getTasks, passing it the names, Ann, Bob, or Carol, or
     any other string, like “all”, to get all tasks.

     Let’s say that you’re a new manager of a team that consists of three team
     members working under you, Ann, Bob, and Carol.
     Each of these developers is working on a set of tasks.
     You’ve asked your developers to submit what they’re working on to you.
     You also have a master set of tasks, which your boss sent to you.

     You’ll be using that data to answer the following questions.
     • What is the full task list? This is the list of all tasks described by your
     manager, and any additional tasks the employees have, that may not be
     on that list.
     • Which tasks are assigned to at least one of your 3 team members?
     • Which tasks still need to be assigned?
     • Which tasks are assigned to multiple employees?
     To do some of this work, create three methods on your Main class.

     Be sure the Sets you pass to these methods don’t mutate in these
     methods. In other words, return a new Set.
     Create a getUnion method, that takes a List of Sets and will return the
     union of all the Sets.
     Create a getIntersect method, that takes two Sets and returns the
     intersection of the Sets.
     Create a getDifference method, that takes two Sets and removes the
     second argument’s Set from the first.
    */

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
