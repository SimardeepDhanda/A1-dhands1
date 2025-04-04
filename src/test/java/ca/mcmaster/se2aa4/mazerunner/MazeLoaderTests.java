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

class LoadMazeTest {

    @Test
    void testLoadMaze_basicStructure() throws Exception {
        char[][] maze = MazeLoader.loadMaze("examples/tiny.maz.txt");
        assertNotNull(maze);
        assertTrue(maze.length > 0 && maze[0].length > 0);
    }
}
