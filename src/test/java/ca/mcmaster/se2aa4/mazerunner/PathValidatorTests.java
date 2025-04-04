package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PathHitsWallTest {

    @Test
    void testIsPathValid_hitsWall() {
        char[][] maze = {
            {' ', '#', ' ', ' '},
            {'#', '#', '#', '#'}
        };
        boolean isValid = PathValidator.isPathValid(maze, 0, 0, 0, 3, "FFF");
        assertFalse(isValid);
    }
}

class PathOutOfBoundsTest {

    @Test
    void testIsPathValid_outOfBounds() {
        char[][] maze = {
            {' ', ' ', ' '}
        };
        boolean isValid = PathValidator.isPathValid(maze, 0, 0, 0, 2, "FFFF");
        assertFalse(isValid);
    }
}

class PathValidStraightLineTest {

    @Test
    void testIsPathValid_validPath() {
        char[][] maze = {
            {' ', ' ', ' ', ' '},
            {'#', '#', '#', '#'}
        };
        boolean isValid = PathValidator.isPathValid(maze, 0, 0, 0, 3, "FFF");
        assertTrue(isValid);
    }
}
