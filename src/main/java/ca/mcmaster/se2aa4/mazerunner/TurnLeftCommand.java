package ca.mcmaster.se2aa4.mazerunner;


public class TurnLeftCommand implements Command {
    public void execute(StringBuilder path, Position position) {
        position.direction = (position.direction + 3) % 4;
        path.append('L');
    }
}