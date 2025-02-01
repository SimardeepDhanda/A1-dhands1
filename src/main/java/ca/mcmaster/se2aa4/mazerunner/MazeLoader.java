package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MazeLoader {

    public static char[][] loadMaze(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();
        String line;
        int maxWidth = 0;

        //read each line and determine the maximum width
        while ((line = reader.readLine()) != null) {
            lines.add(line);
            maxWidth = Math.max(maxWidth, line.length());
        }
        reader.close();

        // create the 2D maze array
        char[][] maze = new char[lines.size()][maxWidth];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < maxWidth; j++) {
                maze[i][j] = (j < lines.get(i).length()) ? lines.get(i).charAt(j) : ' ';
            }
        }
        return maze;
    }

    public static int[] findEntryPoint(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == ' ') {
                return new int[]{i, 0};
            }
        }
        return null; //no entry found
    }

    public static int[] findExitPoint(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][maze[0].length - 1] == ' ') {
                return new int[]{i, maze[0].length - 1};
            }
        }
        return null; //no exit found
    }

    public static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
