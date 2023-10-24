public class StudentItem {
    private int studentNumber;
    private String firstName, lastName;
    private int thresholdValue;
    StudentItem(int studentNumber, String firstName, String lastName, int thresholdValue){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thresholdValue = thresholdValue;
    }
    public int getStudentNumber(){
        return studentNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getThresholdValue(){
        return thresholdValue;
    }
}
