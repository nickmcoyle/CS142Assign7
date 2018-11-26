
/**
 * An abstract class to model a person.
 *
 * @author Nick Coyle
 * @version 11/27/2018
 */
public abstract class Person
{
    private String id;
    private String name;
    private String email;

    public Person(String id, String name) {
        this(id, name, "");
    }

    public Person(String id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }

    /** 
     * A method to get the id of the person. 
     * 
     * @#return String the id of the person
     */
    public String getId() {
        return id;
    }

    /**
     * A method to get the name of the person.
     * 
     * @return name: String the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * A method to get the email address of the person
     *
     * @return String the email address of the person
     */
    public String getEmail() {
        return email;
    }

    /**
     * A method to set the id of the person. The id will be validated using the abstract isValid() method of the child class.
     * 
     * @params id: String the id of the person
     */
    public void setId(String id) {            
        if(!isValidId(id)) {
            throw new IllegalArgumentException("Error: invalid ID.");
        }
        
        this.id = id;      
    }

    /**
     * A method to set the name of the person.
     * 
     * @params name: String the name of the person
     */
    public void setName(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("Error: invalid name passed to Person class. Name cannot be empty.");
        }
        
        this.name = name;
    }

    /**
     * A method to set the email address of the person. I guess we should validate it using regex for an email address.
     * 
     * @params email: String the email address for the person
     */
    public void setEmail(String email) {        
        if(email.isEmpty()) {
            throw new IllegalArgumentException("Error: invalid email address passed to setEmail() method in Person class. Email must not be empty");
        }
        if (!email.toUpperCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$")) {
            throw new IllegalArgumentException("Error: invalid email address passed to setEmail() method in Person class. Please try again with a valid email address");
        }
        
        this.email = email;
    }

    /**
     * An abstract method to check if the id passed is valid. Must be implemented in the child class. 
     */
    public abstract boolean isValidId(String id);

    /**
     * An abstract method. Since we can't create an instance of the Person class, we do not need implementation of this method.
     */
    @Override
    public abstract String toString();
}
