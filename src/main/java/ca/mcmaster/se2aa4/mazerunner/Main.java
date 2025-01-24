package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.info("** Starting Maze Runner");

        //sets up the CLI options (recheck)
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

        //get the input file path from the -i flag
        String inputFilePath = cmd.getOptionValue("i");


        logger.info("**** Computing path");
        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
