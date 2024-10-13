package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema() {
        conditions = new LinkedHashMap<>();
    }

    public MapSchema required() {
        conditions.put("required", (map) -> map != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        conditions.put("sizeof", (map) -> map != null && map.size() >= size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> baseSchema) {
        conditions.put("shape", (inputMap) -> {
            for (var key : inputMap.keySet()) {
                if (!baseSchema.get(key).isValid(inputMap.get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
