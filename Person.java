
/**
 * A class to model a person
 *
 * @author Nick Coyle
 * @version 11/27/2018
 */
public class Person
{
    private String id;
    private String name;
    private String email;

    public Person(String id, String name) {

    }

    public Person(String id, String name, String email) {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        
    }

    public void setName(String name) {

    }

    public void setEmail(String email) {

    }

    public boolean isValidId(String id) {

    }

    @Override
    public String toString() {
        String personString = "";
        return personString;
    }

    public void test() {
        Person p = new Person();
    }

}
