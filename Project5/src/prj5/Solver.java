package prj5;

import java.util.HashMap;
import java.util.Iterator;

/**
 * This class generates all the likes and heards for each of a specific
 * attribute of a student for a specific song
 * 
 * @author cynthz5
 * @version 2017.04.15
 *
 */
public class Solver {
    // ~ Methods------------------
    /**
     * takes in a song and a student attribute (hobby, major, or region) and
     * returns a map containing the number of likes and heards for each
     * type of the specified attribute for a specified song
     * 
     * @param song
     *            the song to be searched for likes and heards
     * @param attribute
     *            the student attribute associated with the likes and heards
     * 
     * @return a map with each type of the specified attribute as the key, and
     *         an array with the first element as the number of heards, and the
     *         second element as the number of likes as the value
     */
    public static HashMap<String, int[]> solve(Song song, String attribute) {
        StudentList heards = song.getHeards();
        StudentList likes = song.getLikes();
        HashMap<String, int[]> result = new HashMap<>();

        Iterator<Student> it = heards.iterator();
        int[] heardsAndLikes = new int[2];

        // iterates through heards and updates accordingly
        while (it.hasNext()) {
            Student nextStudent = it.next();

            String specificAttr = findSpecificAttribute(nextStudent, attribute);

            if (!result.containsKey(specificAttr)) {
                heardsAndLikes = new int[2];
                heardsAndLikes[0] = 1; // updates number of heards
            }
            else {
                heardsAndLikes = result.get(specificAttr);
                heardsAndLikes[0] += 1; // updates number of heards
            }
            result.put(specificAttr, heardsAndLikes);
        }

        Iterator<Student> it2 = likes.iterator();

        // iterates through likes and updates accordingly
        while (it2.hasNext()) {
            Student nextStudent = it2.next();

            String specificAttr = findSpecificAttribute(nextStudent, attribute);

            if (!result.containsKey(specificAttr)) {
                heardsAndLikes = new int[2];
                heardsAndLikes[1] = 1; // updates number of likes
            }
            else {
                heardsAndLikes = result.get(specificAttr);
                heardsAndLikes[1] += 1; // updates number of likes
            }
            result.put(specificAttr, heardsAndLikes);
        }

        return result;
    }


    /**
     * Given a Student and an attribute type, this method returns the specific
     * attribute of specified type for that particular Student
     * 
     * @param attr
     *            the attribute type (major, region, hobby) of the Student
     * @param student
     *            the student the attribute is being retrieved from
     * 
     * @return the specific attribute (for hobby: swimming, music, etc.) of the
     *         Student
     */
    private static String findSpecificAttribute(Student student, String attr) {
        if (attr.equals("major")) {
            return student.getMajor();
        }
        else if (attr.equals("region")) {
            return student.getRegion();
        }
        else {
            return student.getHobby();
        }
    }
}
