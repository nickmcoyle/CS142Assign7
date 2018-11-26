
/**
 * A class to model a teacher
 *
 * @author Nick Coyle
 * @version 11/27/2018
 */
public class Teacher extends Person
{
    //I think the number of courses to store should be a constant so it is easily changed from one place
    private static final int courseMax = 50;
    
    private String[] coursesTaught; //50
    private int nextCourseIndex;

    public Teacher(String id, String name, String email) {
        super(id, name, email);
        
        coursesTaught = new String[courseMax];
        nextCourseIndex = 0; //we don't really have to do this since fields are default initialized to 0, but it's good practice anyway
    }

    /**
     * A method to check if the id is valid. For a teacher, it should be 6 alphanumeric characters.
     * 
     * @params id: String the id to check for validity
     * 
     * @return boolean if the id is valid
     */
    @Override
    public boolean isValidId(String id) {
        return id.matches("[a-zA-Z0-9]{6}");
    }

    /** 
     * A method to add a course to the courses taught array field
     * 
     * @params courseName: String the name of the course that was taught
     */
    public void addCourseTaught (String courseName) {
        if(courseName.isEmpty()) {
            throw new IllegalArgumentException("Error: invalid course name passed to addCourseTaught() method in Teacher class. Cannot be empty");
        }
        
        coursesTaught[nextCourseIndex] = courseName;
        ++nextCourseIndex;
    }

    /** 
     * A method to print the teacher fields and data
     */
    @Override
    public String toString() {
        String teacherString = "";
        
        teacherString += "Id \t= " + super.getId() + "\n";
        teacherString += "Name\t= " + super.getName() + "\n";
        teacherString += "Email\t= " + super.getEmail() + "\n";
        teacherString += "Has taught " + nextCourseIndex + " course(s):" + "\n";
        
        for(int i = 0; i < nextCourseIndex; ++i) {
            teacherString += "\t- " + coursesTaught[i] + "\n";
        }
        
        teacherString += "\n";
        
        return teacherString;
    }

    /**
     * A static test method
     */
    public static void test() {        
        String id = "ABC34a";
        String name = "D. Pepper";
        String email = "dr.pepper@gmail.com";
        Teacher t = new Teacher(id, name, email);
    }

}
