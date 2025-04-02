package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExitPointTest {

    @Test
    void testFindExitPoint_detectsExit() {
        char[][] maze = {
            {'#', ' '},
            {'#', '#'}
        };
        int[] exit = MazeLoader.findExitPoint(maze);
        assertNotNull(exit, "Exit point should not be null");
        assertArrayEquals(new int[]{0, 1}, exit, "Should detect exit on right edge at (0,1)");
    }
}
