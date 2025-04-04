package ca.mcmaster.se2aa4.mazerunner;

public class CommandFactory {
    private final char[][] maze;

    public CommandFactory(char[][] maze) {
        this.maze = maze;
    }

    public Command create(char type) {
        return switch (type) {
            case 'F' -> new MoveForwardCommand(maze);
            case 'L' -> new TurnLeftCommand();
            case 'R' -> new TurnRightCommand();
            default -> throw new IllegalArgumentException("Unknown command type: " + type);
        };
    }
}
