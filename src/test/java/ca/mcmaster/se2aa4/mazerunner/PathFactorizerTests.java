package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorizePathNoRepeatTest {

    @Test
    void testFactorizePath_noRepetition() {
        String result = PathFactorizer.factorizePath("FRL");
        assertEquals("F R L", result.trim());
    }
}

class FactorizePathSimpleTest {

    @Test
    void testFactorizePath_basic() {
        String result = PathFactorizer.factorizePath("FFFRFF");
        assertEquals("3F R 2F", result.trim());
    }
}
