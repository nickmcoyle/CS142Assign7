
/**
 * A class to model a student
 *
 * @author Nick Coyle
 * @version 11/27/2018
 */
public class Student extends Person
{
    //I think the number of courses should be a constant in case we need to change it later, it's only defined in one place
    private final int courseMax = 30;
    private String[] coursesTaken; 
    private Double[] courseGrades; 
    private int nextCourseIndex;

    public Student(String id, String name, String email) {
        super(id, name, email);
        
        coursesTaken = new String[courseMax];
        courseGrades = new Double[courseMax];
        nextCourseIndex = 0;
    }

    /** 
     * A method to check if the id is valid. For a Student, it should be 9 digits.
     * 
     * @params id: String the id to check
     * 
     * @return boolean if the id is valid
     */
    @Override
    public boolean isValidId(String id) {
        return id.matches("[0-9]{9}");
    }

    /**
     * A method to add a course to the coursesTaken array field. The grade cannot be less than 0 or more than 4.0.
     * 
     * @params courseName: String the name of the course that was completed and courseGrade: double the grade earned for the course
     */
    public void courseCompletion(String courseName, double courseGrade) throws ArrayIndexOutOfBoundsException {
        if(courseGrade < 0.0 || courseGrade > 4.0) {
            throw new IllegalArgumentException("Error: CourseGrade must be between 0.0 and 4.0");            
        }
        
        coursesTaken[nextCourseIndex] = courseName;
        courseGrades[nextCourseIndex] = courseGrade;
        ++nextCourseIndex;
    }

    /**
     * A method to get the average grade for all courses in the coursesTaken array
     * 
     * @return the average grade: double
     */
    public double getAverageGrade() {
        double avgGrade = 0.0;
        
        for(int i = 0; i < nextCourseIndex; ++i) {
            avgGrade += courseGrades[i];
        }
        
        if(nextCourseIndex > 0) avgGrade /= nextCourseIndex;
        
        return avgGrade;
    }

    /**
     * A method to print the student fields
     */
    @Override
    public String toString() {
        String studentString = "";
        studentString += "Id \t= " + super.getId() + "\n";
        studentString += "Name\t= " + super.getName() + "\n";
        studentString += "Email\t= " + super.getEmail() + "\n";
        studentString += "Current grade average is " + String.format("%.1f", getAverageGrade()) + "\n";
        studentString += "Student has completed " + nextCourseIndex + " course(s) so far:" + "\n";
        
        for(int i = 0; i < nextCourseIndex; ++i) {
            studentString += "\t- " + coursesTaken[i] + " (" + courseGrades[i] + ")" + "\n";
        }
        
        studentString += "\n";
        
        return studentString;
    }

    /**
     * A static test method
     */
    public static void test() {
        String id = "123456789";
        String name = "D. Pepper";
        String email = "dr.pepper@gmail.com";
        Student s2 = new Student(id, name, email);
        
        if(!s2.getName().equals("D. Pepper")) System.out.println("Error: student getName() should be D. Pepper but is " + s2.getName());
        if(!s2.getId().equals("123456789")) System.out.println("Error: student getId() should be 123456789 but is " + s2.getId());
        if(!s2.getEmail().equals("dr.pepper@gmail.com")) System.out.println("Error: student email should be dr.pepper@gmail.com but is " + s2.getEmail());
        if(s2.getAverageGrade() != 0.0) System.out.println("Error: student avg grade should be 0.0 but is " + s2.getAverageGrade());
        //s2.courseCompletion("Fake", 5.0); //throws IAE
        //s2.courseCompletion("Fake II", -1.0); //throws IAE
        //s2.courseCompletion("Fake", 4.00000000000001); //thows IAE
        //s2.courseCompletion("Fake II", -0.0); //throws IAE
        if(s2.nextCourseIndex != 0) System.out.println("Error: courses taken should still be 0 but is " + s2.nextCourseIndex);
        s2.courseCompletion("Fake", 4.000000000000);
        s2.courseCompletion("Fake II", 1.00000);
        if(s2.nextCourseIndex != 2) System.out.println("Error: courses taken should be 2 but is " + s2.nextCourseIndex);
        if(s2.getAverageGrade() != 2.5) System.out.println("Error: average grade should be 2.5 but is " + s2.getAverageGrade());
        s2.courseCompletion("Fake", 3.0000000);
        s2.courseCompletion("Fake II", 2.70000);
        if(s2.nextCourseIndex != 4) System.out.println("Error: courses taken should be 4 but is " + s2.nextCourseIndex);
        if(s2.getAverageGrade() != 2.675) System.out.println("Error: average grade should be 2.675 but is " + s2.getAverageGrade());
    }

}
