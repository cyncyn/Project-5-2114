package prj5;

/**
 * The student class stores information for each student:
 * his/her hobby, major, and region
 * @author lchar16
 * @version 2017.04.12
 *
 */
public class Student {
    
    //~ Fields----------------------------
    private String major;
    private String region;
    private String hobby;
    
    //~ Constructor
    /**
     * new Student with specified 
     * @param maj Major: (CS, other engineering, math/CMDA, other)
     * @param reg Region: (NE US, SE US, rest of US, outside US)
     * @param hob Hobby: (read, art, sports, music)
     */
    public Student(String maj, String reg, String hob)
    {
        major = maj;
        region = reg;
        hobby = hob;
    }
    
    //~ Methods------------------------------
    /**
     * 
     * @return the Student's major
     */
    public String getMajor()
    {
        return major;
    }
    
    /**
     * @return the Student's region
     */
    public String getRegion()
    {
        return region;
    }
    
    /**
     * @return the Student's hobby
     */
    public String getHobby()
    {
        return hobby;
    }
    
    // do we need an equals method????
    
    /**
     * @return the student's major, region and hobby
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Major: " + this.getMajor() + ", ");
        builder.append("Region: " + this.getRegion() + ", ");
        builder.append("Hobby: " + this.getHobby() + ".");
        return builder.toString();
    }

}