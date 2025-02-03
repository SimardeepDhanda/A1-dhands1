package ca.mcmaster.se2aa4.mazerunner;

public class PathFactorizer {

    public static String factorizePath(String path) {
        if (path.isEmpty()) return "";

        StringBuilder factorized = new StringBuilder();
        char prevChar = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == prevChar) {
                count++;
            } else {
                appendFactorizedSegment(factorized, prevChar, count);
                prevChar = path.charAt(i);
                count = 1;
            }
        }
        
        //add the last segment
        appendFactorizedSegment(factorized, prevChar, count);
        
        return factorized.toString().trim();
    }

    private static void appendFactorizedSegment(StringBuilder factorized, char move, int count) {
        if (count > 1) {
            factorized.append(count).append(move).append(" ");
        } else {
            factorized.append(move).append(" ");
        }
    }
}
