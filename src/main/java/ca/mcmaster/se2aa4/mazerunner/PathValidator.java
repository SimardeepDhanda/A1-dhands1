package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {

    public static boolean isPathValid(char[][] maze, int startX, int startY, String path) {
        int x = startX;
        int y = startY;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F': y++; break; //move up
                case 'L': x--; break; //move left
                case 'R': x++; break; //move right
                case 'B': y--; break; //Move down
                default: return false; // Invalid move
            }

            //chec boundaries and wall collisions
            if (x < 0 || y < 0 || y >= maze.length || x >= maze[0].length || maze[y][x] == '#') {
                return false;
            }
        }
        return true; //A valid path if no collisions into the wall
    }
}