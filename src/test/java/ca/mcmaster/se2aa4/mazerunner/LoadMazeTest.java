package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoadMazeTest {

    @Test
    void testLoadMaze_basicStructure() throws Exception {
        char[][] maze = MazeLoader.loadMaze("examples/tiny.maz.txt");
        assertNotNull(maze);
        assertTrue(maze.length > 0 && maze[0].length > 0);
    }
}
