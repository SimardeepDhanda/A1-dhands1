package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RightHandExplorer {
    
    private static final Logger logger = LogManager.getLogger();


    public static String computePath(char[][] maze, int startRow, int startCol, int endRow, int endCol) {
        StringBuilder path = new StringBuilder();
        int row = startRow, col = startCol, direction = 0;

        while (row != endRow || col != endCol) {
            int rightDir = (direction + 1) % 4;
            if (canMove(maze, row, col, rightDir)) {
                direction = rightDir;
                path.append('R');
            }

            if (canMove(maze, row, col, direction)) {
                int[] newPos = moveForward(row, col, direction);
                row = newPos[0];
                col = newPos[1];
                path.append('F');
            } else {
                direction = (direction + 3) % 4;
                path.append('L');
            }
        }

        //compute factorized path
        String factorizedPath = factorizePath(path.toString());

        //print both paths
        logger.info("Canonical Form: " + path);
        logger.info("Factorized Form: " + factorizedPath);

        return path.toString();
    }

    private static boolean canMove(char[][] maze, int row, int col, int direction) {
        int[] newPos = moveForward(row, col, direction);
        int newRow = newPos[0], newCol = newPos[1];

        return newRow >= 0 && newCol >= 0 && newRow < maze.length 
               && newCol < maze[0].length && maze[newRow][newCol] == ' ';
    }

    private static int[] moveForward(int row, int col, int direction) {
        if (direction == 0) return new int[]{row, col + 1}; // right (→)
        if (direction == 1) return new int[]{row + 1, col}; // down (↓)
        if (direction == 2) return new int[]{row, col - 1}; // left (←)
        return new int[]{row - 1, col}; // up (↑)
    }

    //factorized path
    private static String factorizePath(String path) {
        if (path.isEmpty()) return "";

        StringBuilder factorized = new StringBuilder();
        char prevChar = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == prevChar) {
                count++;
            } else {
                if (count > 1) {
                    factorized.append(count).append(prevChar).append(" ");
                } else {
                    factorized.append(prevChar).append(" ");
                }
                prevChar = path.charAt(i);
                count = 1;
            }
        }

        // adds the last counted sequence
        if (count > 1) {
            factorized.append(count).append(prevChar);
        } else {
            factorized.append(prevChar);
        }

        return factorized.toString();
    }
}
