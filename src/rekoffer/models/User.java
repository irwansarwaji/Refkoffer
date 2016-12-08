
package rekoffer.models;

/**
 * @author Damon
 */
public class User {
    
    private int id;
    private String email;
    private String firstName;
    private String lastName;

    public User(int id, String email, String firstName, String lastName, String phone, int type) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.type = type;
    }
    private String phone;
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
         String result = String.format("%-40s %-40s %-40s %-40s", firstName, lastName, email, phone);
        
        return result;
    }
    
    
    
}
