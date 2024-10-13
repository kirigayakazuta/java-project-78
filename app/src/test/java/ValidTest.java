import org.junit.jupiter.api.Test;
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidTest {
    @Test
    public void stringTest() {
        var v = new Validator();
        var schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();

        assertThat(schema.isValid("what does the fox say")).isFalse();

        var schema1 = v.string();

        assertThat(schema1.minLength(10).minLength(4).isValid("Hexlet")).isTrue();
        assertThat(schema1.isValid("abc")).isFalse();
    }
}
