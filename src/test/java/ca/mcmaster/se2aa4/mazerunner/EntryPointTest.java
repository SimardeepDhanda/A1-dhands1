package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntryPointTest {

    @Test
    void testFindEntryPoint_detectsEntry() {
        char[][] maze = {
            {' ', '#'},
            {'#', '#'}
        };
        int[] entry = MazeLoader.findEntryPoint(maze);
        assertNotNull(entry, "Entry point should not be null");
        assertArrayEquals(new int[]{0, 0}, entry, "Should detect entry on left edge at (0,0)");
    }
}
