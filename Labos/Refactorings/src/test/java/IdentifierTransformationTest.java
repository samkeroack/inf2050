import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTransformationTest {

    @Test
    public void snakeCaseIdentifierToCamelCase() {
        assertEquals("Abc", IdentifierTransformation.snakeCaseIdentifierToCamelCase("a_b_c"));
    }

}