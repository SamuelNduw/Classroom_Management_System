package Authorization;

public class Auth {
    private int teacherID;
    private String firstName;
    private String lastName;
    private String email;
    public Auth(int teacherID, String firstName, String lastName, String email){
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public int getTeacherID(){
        return teacherID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
}
