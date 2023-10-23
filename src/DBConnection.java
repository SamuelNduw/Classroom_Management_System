import Authorization.Auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private String password = "";

    ArrayList<TeacherItem> teachers;
    TeacherItem teacher;
    public ArrayList<TeacherItem> retrieveTeacher(){
        teachers = new ArrayList<TeacherItem>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root",password);

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
                System.out.println(firstName);
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

    public void insertStudent(String firstName, String lastName, String email) {
        //String sql = "UPDATE Teacher SET First_Name = ?, Last_Name = ? WHERE Teacher_id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root", password)) {
            // Set the Callable statement
            CallableStatement cstmt = conn.prepareCall("{call insertStudentDetails(?, ?, ?)}");

            // Set the values for the CallableStatement
            cstmt.setString(1, firstName);
            cstmt.setString(2, lastName);
            cstmt.setString(3, email);

            // Execute the insert
            cstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUpTeacher(String firstName, String lastName, String email, String subject, String passwordVal){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root", password)) {
            // Set the Callable statement
            CallableStatement cstmt = conn.prepareCall("{call sp_SignUp(?, ?, ?, ?, ?)}");

            // Set the values for the CallableStatement
            cstmt.setString(1, firstName);
            cstmt.setString(2, lastName);
            cstmt.setString(3, email);
            cstmt.setString(4, subject);
            cstmt.setString(5, passwordVal);

            // Execute the insert
            cstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String getPasswordInfo(String email){
        String passwordRet = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root", password)){
            String sql = "{CALL sp_GetPasswordInfo(?)}";
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                passwordRet = rs.getString("password");
            }

        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return passwordRet;

    }
    public Auth getTeacherData(String emailVal, String passwordVal) {
        Auth auth = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement", "root", password)) {
            String sql = "{CALL sp_TeacherAuth(?, ?)}";
            CallableStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, emailVal);
            stmt.setString(2, passwordVal);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int tID = rs.getInt("teacher_id");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String email = rs.getString("email");

                auth = new Auth(tID, fName, lName, email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return auth;
    }
    public void setThreholdLimit(int teacherID, int thresholdLimit){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classroommanagement","root", password)) {
            // Set the Callable statement
            CallableStatement cstmt = conn.prepareCall("{CALL sp_SetThresholdLimit(?, ?)}");

            // Set the values for the CallableStatement
            cstmt.setString(1, String.valueOf(teacherID));
            cstmt.setString(2, String.valueOf(thresholdLimit));

            // Execute the insert
            cstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
