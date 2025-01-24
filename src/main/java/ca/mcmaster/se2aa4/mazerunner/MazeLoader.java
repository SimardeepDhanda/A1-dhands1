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

        // Read each line and determine the maximum width
        while ((line = reader.readLine()) != null) {
            lines.add(line);
            maxWidth = Math.max(maxWidth, line.length());
        }
        reader.close();

        // Create the 2D maze array
        char[][] maze = new char[lines.size()][maxWidth];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < maxWidth; j++) {
                maze[i][j] = (j < lines.get(i).length()) ? lines.get(i).charAt(j) : ' ';
            }
        }
        return maze;
    }

}
