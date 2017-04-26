
package prj5;

/**
 * Runs the project and begins the program
 * 
 * @author lchar16
 * @version 2017.04.16
 *
 */
public class Input {

    /**
     * main method of the project
     * 
     * @param args
     *            file containing students and songs
     */
    public static void main(String[] args) {
        // new Reader(args[0], args[1]);
        new Reader("MusicSurveyData2017S.csv", "SongList2017S.csv");
    }
}
