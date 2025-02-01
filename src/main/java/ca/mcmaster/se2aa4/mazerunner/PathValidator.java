package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {

    public static boolean isPathValid(char[][] maze, int startX, int startY, int endX, int endY, String path) {
        int x = startX;
        int y = startY;
        int direction = 0; // 0 = rifht, 1 = down, 2 = left, 3 = up

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F':
                    if (direction == 0) y++;
                    else if (direction == 1) x++;
                    else if (direction == 2) y--;
                    else if (direction == 3) x--;
                    break;
                case 'B':
                    if (direction == 0) y--;
                    else if (direction == 1) x--;
                    else if (direction == 2) y++;
                    else if (direction == 3) x++;
                    break;
                case 'R':
                    direction = (direction + 1) % 4; // Turn right
                    break;
                case 'L':
                    direction = (direction + 3) % 4; // Turn left 
                    break;
                default:
                    return false; // Invalid move
            }

            // Check boundaries and wall collisions
            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '#') {
                return false;
            }
        }

        // Check if the final position is the exit point
        return x == endX && y == endY;
    }
}