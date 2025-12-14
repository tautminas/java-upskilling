import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Path root = Paths.get("challenge-description");

        try {
            Map<Path, Map<String, Long>> summary =
                    DirectorySummary.summarize(root);

            summary.forEach((path, stats) -> {
                System.out.println(path);
                System.out.println("  Size: " + stats.get("size") + " bytes");
                System.out.println("  Files: " + stats.get("files"));
                System.out.println("  Folders: " + stats.get("folders"));
            });
        } catch (IOException e) {
            System.out.println("Error reading file tree: " + e.getMessage());
        }
    }
}
