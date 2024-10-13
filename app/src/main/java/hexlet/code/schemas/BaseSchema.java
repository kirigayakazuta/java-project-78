package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    protected Map<String, Predicate<T>> conditions;

    public boolean isValid(T input) {
        boolean valid = true;
        for (Predicate<T> condition : conditions.values()) {
            if (!condition.test(input)) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
