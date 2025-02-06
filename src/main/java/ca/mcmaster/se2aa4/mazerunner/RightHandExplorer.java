package ca.mcmaster.se2aa4.mazerunner;



public class RightHandExplorer {
    


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
        String factorizedPath = PathFactorizer.factorizePath(path.toString());
        
        //print both paths
        System.out.println("Factorized Form: " + factorizedPath);

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
}
