import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class DirectorySummary {

    public static Map<Path, Map<String, Long>> summarize(Path root)
            throws IOException {

        Map<Path, Map<String, Long>> result = new HashMap<>();
        result.put(root, createEmptyStats());

        Files.walk(root).forEach(path -> {
            if (path.equals(root)) return;

            try {
                if (Files.isDirectory(path)) {
                    updateParents(result, root, path, "folders", 1);
                    result.putIfAbsent(path, createEmptyStats());
                } else if (Files.isRegularFile(path)) {
                    long size = Files.size(path);
                    updateParents(result, root, path, "files", 1);
                    updateParents(result, root, path, "size", size);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return result;
    }

    private static void updateParents(
            Map<Path, Map<String, Long>> map,
            Path root,
            Path child,
            String key,
            long value) {

        Path parent = child.getParent();
        while (parent != null && parent.startsWith(root)) {
            map.putIfAbsent(parent, createEmptyStats());
            map.get(parent).merge(key, value, Long::sum);
            parent = parent.getParent();
        }
    }

    private static Map<String, Long> createEmptyStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("size", 0L);
        stats.put("files", 0L);
        stats.put("folders", 0L);
        return stats;
    }
}
