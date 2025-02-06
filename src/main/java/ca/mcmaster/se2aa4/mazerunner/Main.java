package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.info("** Starting Maze Runner");

        // Set up CLI options
        Options options = new Options();
        options.addOption(Option.builder("i")
                .longOpt("input")
                .desc("Path to the input maze file")
                .hasArg()
                .argName("FILE")
                .required()
                .build());
        options.addOption(Option.builder("p")
                .longOpt("path")
                .desc("Path to navigate through the maze")
                .hasArg()
                .argName("PATH")
                .build());

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Failed to parse command-line arguments: " + e.getMessage());
            formatter.printHelp("MazeRunner", options);
            return;
        }

        //get input file path
        String inputFilePath = cmd.getOptionValue("i");

        try {
            logger.info("**** Reading the maze from file " + inputFilePath);
            char[][] maze = MazeLoader.loadMaze(inputFilePath);

            //print the maze
            MazeLoader.printMaze(maze);

            // Find entry and exit points
            int[] entryPoint = MazeLoader.findEntryPoint(maze);
            int[] exitPoint = MazeLoader.findExitPoint(maze);

            //handle case where no entry or exit is found
            if (entryPoint == null || exitPoint == null) {
                logger.error("**** Error: Could not determine valid entry or exit points.");
                return;
            }

            if (cmd.hasOption("p")) {
                String path = cmd.getOptionValue("p");
                System.out.println("**** Validating path: " + path);
                boolean isValid = PathValidator.isPathValid(maze, entryPoint[0], entryPoint[1], exitPoint[0], exitPoint[1], path);
                if (isValid) {
                    System.out.println("**** Path is valid!");
                } else {
                    System.out.println("**** Path is invalid!");
                }
            } else {
                //compute path using the RIght-Hand Rule
                System.out.println("**** Computing path using Right-Hand Rule");
                String path = RightHandExplorer.computePath(maze, entryPoint[0], entryPoint[1], exitPoint[0], exitPoint[1]);
                System.out.println("**** Canonical Form:: " + path);
            }
        } catch (Exception e) {
            logger.error("/!\\\\ An error has occurred while processing the maze /!\\\\", e);
        }

        logger.info("** End of MazeRunner");
    }
}
