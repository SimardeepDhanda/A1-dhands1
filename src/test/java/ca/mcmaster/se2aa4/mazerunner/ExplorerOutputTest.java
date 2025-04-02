package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExplorerOutputTest {

    @Test
    void testRightHandExplorer_nonNullOutput() {
        char[][] maze = {
            {'#', '#', '#', '#', '#'},
            {' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#'}
        };
        String path = RightHandExplorer.computePath(maze, 1, 0, 3, 4);
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }
}
