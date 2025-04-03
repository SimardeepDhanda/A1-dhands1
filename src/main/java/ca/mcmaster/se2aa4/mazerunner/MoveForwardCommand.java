package ca.mcmaster.se2aa4.mazerunner;


public class MoveForwardCommand implements Command {
    private char[][] maze;

    public MoveForwardCommand(char[][] maze) {
        this.maze = maze;
    }

    public void execute(StringBuilder path, Position position) {
        int[] newPos = RightHandExplorer.moveForward(position.row, position.col, position.direction);
        position.row = newPos[0];
        position.col = newPos[1];
        path.append('F');
    }
}