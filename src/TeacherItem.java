public class TeacherItem {
    private String firstName,
            lastName,
            email,
            subject;
    public TeacherItem(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getSubject(){
        return subject;
    }
}
