import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {

    ArrayList<TeacherItem> teachers;
    TeacherItem teacher;
    public ArrayList<TeacherItem> retrieveTeacher(){
        teachers = new ArrayList<TeacherItem>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root","");

            // Create a statement object
            Statement stmt = conn.createStatement();

            System.out.println("hello");
            // Execute a query and get the result set
            ResultSet rs = stmt.executeQuery("CALL GetTeacherAndSubject");

            // Process the result set and extract data
            while (rs.next()) {
                //int food_id = rs.getInt("food_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String subject = rs.getString("subject");

                // Do something with the data
                teacher = new TeacherItem(firstName, lastName, subject);
                teachers.add(teacher);
            }

            // Close the result set, statement, and connection objects
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }





}
