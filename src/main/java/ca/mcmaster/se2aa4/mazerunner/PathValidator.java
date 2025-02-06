package ca.mcmaster.se2aa4.mazerunner;

public class PathValidator {

    public static boolean isPathValid(char[][] maze, int startRow, int startCol, int endRow, int endCol, String path) {
        int row = startRow;
        int col = startCol;
        int direction = 0;

        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F':
                    if (direction == 0) col++; 
                    else if (direction == 1) row++; 
                    else if (direction == 2) col--; 
                    else if (direction == 3) row--; 
                    break;
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                case 'L':
                    direction = (direction + 3) % 4;
                    break;
                default:
                    return false; 
            }

            if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == '#') {
                return false;
            }
        }

        return row == endRow && col == endCol;
    }
}
