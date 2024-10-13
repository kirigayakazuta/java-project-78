package hexlet.code.schemas;

import java.util.LinkedHashMap;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        conditions = new LinkedHashMap<>();
    }

    public NumberSchema required() {
        conditions.put("required", (num) -> num != null);
        return this;
    }

    public NumberSchema positive() {
        conditions.put("positive", (num) -> num == null || num > 0);
        return this;
    }

    public NumberSchema range(int minRange, int maxRange) {
        conditions.put("positive", (num) -> minRange <= num && num <= maxRange);
        return this;
    }
}
