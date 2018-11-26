
/**
 * Main just tests output
 *
 * @author Nick Coyle
 * @version 11/27/2018
 */
public class Main
{
    public static void main(String[] args) {
        Student.test();
        Teacher.test();        
        
        try 
        {
            String id = "123456789";
            String name = "Bobby Brown";
            String email = "bobb@comcast.net";
            Student s1 = new Student(id, name, email);
            s1.courseCompletion("History of Western Civilizations", 1.7);
            s1.courseCompletion("Algebra II", 3.9);
            s1.courseCompletion("Geometry I", 3.7);
            s1.courseCompletion("History of Western Civilizations", 3.0);
            System.out.print(s1);
            
            String teacherId = "SS9482";
            String teacherName = "Samantha Smith";
            String teacherEmail = "sammys@microsoft.com";
            Teacher t1 = new Teacher(teacherId, teacherName, teacherEmail);
            t1.addCourseTaught("Algebra II");
            t1.addCourseTaught("Intro to Programming");            
            System.out.print(t1);
            
            String id2 = "987654321";
            String name2 = "Chrissy Caldwell";
            String email2 = "cccald@gmail.com";
            Student s2 = new Student(id2, name2, email2);
            s2.courseCompletion("Sociology I", 4.0);       
            System.out.print(s2);
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
