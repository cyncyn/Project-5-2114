package prj5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import student.testingsupport.annotations.Hint;

/** Test text output for Music Visualization Project
 * @author margaretellis
 * @version 11-12-2015
 */
public class InputReferenceTest3 extends student.TestCase {
    private String fileName;
    private Scanner fileData;

    /**
     * sets up any needed variables for test methods
     */
    public void setUp() {

        fileData = null;
    }

    
    /**
     * Test the program with the class survey data from 6 students about only
     * 1 song.
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in Output2TitleGenreHobby.txt
     * 
     */
    @Hint("main working properly with MusicSurveyDataTest2, SongListTest2")
    public void testMain2() {
        
        Input.main(new String[] { "MusicSurveyDataTest2.csv",
            "SongListTest2.csv" });

        fileName = "Output2TitleGenreHobby.txt";

        String output2TitleGenreHobby = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());

        }

        while (fileData.hasNextLine()) {
            output2TitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
                + "MusicSurveyDataTest2.csv and SongListTest2.csv",
                output2TitleGenreHobby, systemOut().getHistory());

    }

    
    
    /**
     * Test the program with the class survey data from 6 students about only
     * 5 songs.
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in Output1TitleGenreHobby.txt
     * 
     */
    @Hint("The main method is not working properly with input files " +
          "MusicSurveyDataTest1.csv and SongListTest1.csv")
    public void testMain1() {

        // Notice need to pass in an array of the parameters
        Input.main(new String[] { "MusicSurveyDataTest1.csv",
            "SongListTest1.csv" });

        fileName = "Output1TitleGenreHobby.txt";
        String output1TitleGenreHobby = "";

        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());

        }

        while (fileData.hasNextLine()) {
            output1TitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
                + "MusicSurveyDataTest1.csv and SongListTest1.csv",
                output1TitleGenreHobby, systemOut().getHistory());
    }

   
    /**
     * Test the program with the actual class survey data
     * Gathers the output from StdOut and compares it to
     * the expect output as stored in OutputTitleGenreHobby.txt
     * 
     */
    @Hint("The main method is not working properly with input files " +
            "MusicSurveyDataNoGenreRepeats.csv and SongLisNoGenreRepeats.csv")
    public void testMain3() {

        Input.main(new String[] { "MusicSurveyDataNoGenreRepeats.csv", 
                "SongListNoGenreRepeats.csv" });

        fileName = "Output3TitleGenreHobby.txt";

        String outputTitleGenreHobby = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            outputTitleGenreHobby += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input files "
                + "MusicSurveyDataNoGenreRepeats.csv and "
                + "SongListNoGenreRepeats.csv",
                outputTitleGenreHobby, systemOut().getHistory());

    }

}
