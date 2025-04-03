package ca.mcmaster.se2aa4.mazerunner;

public class TurnRightCommand implements Command {
    public void execute(StringBuilder path, Position position) {
        position.direction = (position.direction + 1) % 4;
        path.append('R');
    }
}

