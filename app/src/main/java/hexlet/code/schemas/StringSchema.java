package hexlet.code.schemas;

public class StringSchema {
    private boolean useRequired;
    private boolean useMinLength;
    private boolean useContains;
    private int minLen;
    private String substring;

    public StringSchema() {
        useRequired = false;
        useMinLength = false;
        useContains = false;
    }

    public StringSchema required() {
        useRequired = true;
        return this;
    }

    public StringSchema minLength(int minLen) {
        useMinLength = true;
        this.minLen = minLen;
        return this;
    }

    public StringSchema contains(String substring) {
        useContains = true;
        this.substring = substring;
        return this;
    }

    public boolean isValid(String input) {
        boolean valid = true;
        if (useRequired && (input == null || input.isEmpty())) {
            valid = false;
        } else if (useMinLength && (input == null || input.length() < minLen)) {
            valid = false;
        } else if (useContains && (input == null || !input.contains(substring))) {
            valid = false;
        }
        return valid;
    }
}
