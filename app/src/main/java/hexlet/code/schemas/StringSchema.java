package hexlet.code.schemas;

import java.util.LinkedHashMap;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        conditions = new LinkedHashMap<>();
    }

    public StringSchema required() {
        conditions.put("required", (str) -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLen) {
        conditions.put("minLength", (str) -> str != null && str.length() >= minLen);
        return this;
    }

    public StringSchema contains(String substring) {
        conditions.put("contains", (str) -> str != null && str.contains(substring));
        return this;
    }
}
