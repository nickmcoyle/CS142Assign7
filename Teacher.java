
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
    
    private String[] addCourseTaught; //50
    private int nextCourseIndex;

    public Teacher(String id, String name, String email) {
        super(id, name, email);
        
        addCourseTaught = new String[courseMax];
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
    public void addCourseTaught (String courseName) throws ArrayIndexOutOfBoundsException {
        if(courseName.isEmpty()) {
            throw new IllegalArgumentException("Error: invalid course name passed to addCourseTaught() method in Teacher class. Cannot be empty");
        }
        
        addCourseTaught[nextCourseIndex] = courseName;
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
            teacherString += "\t- " + addCourseTaught[i] + "\n";
        }
        
        teacherString += "\n";
        
        return teacherString;
    }

    /**
     * A static test method
     */
    public static void test() {        
        String id = "1B345a";
        String name = "D. Pepper";
        String email = "dr.pepper@gmail.com";
        Teacher t = new Teacher(id, name, email);
        
        if(!t.getName().equals("D. Pepper")) System.out.println("Error: teacher getName() should be D. Pepper but is " + t.getName());
        if(!t.getId().equals("1B345a")) System.out.println("Error: teacher getId() should be 123456789 but is " + t.getId());
        if(!t.getEmail().equals("dr.pepper@gmail.com")) System.out.println("Error: teacher email should be dr.pepper@gmail.com but is " + t.getEmail());
        if(t.nextCourseIndex != 0) System.out.println("Error: courses taught should still be 0 but is " + t.nextCourseIndex);
        t.addCourseTaught("Fake I");
        t.addCourseTaught("Fake II");
        t.addCourseTaught("Fake III");
        t.addCourseTaught("Fake IV");
        if(t.nextCourseIndex != 4) System.out.println("Error: courses taken should be 4 but is " + t.nextCourseIndex);
        t.addCourseTaught("Fake Programming I");
        t.addCourseTaught("Fake Programming II");
        if(t.nextCourseIndex != 6) System.out.println("Error: courses taught should be 6 but is " + t.nextCourseIndex);
        
        for(int i = 0; i < 44; ++i) {
            t.addCourseTaught("Fake Stuff " + i);
        }
        
        if(t.nextCourseIndex != 50) System.out.println("Error: courses taught should be 50 but is " + t.nextCourseIndex);
        //t.addCourseTaught("Fake Stuff 51"); //throws index out of bounds exception
    }

}
