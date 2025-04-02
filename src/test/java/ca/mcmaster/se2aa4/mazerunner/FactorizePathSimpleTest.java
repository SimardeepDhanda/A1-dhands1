package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorizePathSimpleTest {

    @Test
    void testFactorizePath_basic() {
        String result = PathFactorizer.factorizePath("FFFRFF");
        assertEquals("3F R 2F", result.trim());
    }
}
