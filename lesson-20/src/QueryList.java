import java.util.ArrayList;
import java.util.List;

public class QueryList<T> extends ArrayList<T> {
    public List<T> getMatches(String field, Object value) {
        List<T> matches = new ArrayList<>();
        for (T t : this) {
            if (t instanceof Student s) {
                if (s.matchFieldValue(field, value)) {
                    matches.add(t);
                }
            }
        }
        return matches;
    }
}
