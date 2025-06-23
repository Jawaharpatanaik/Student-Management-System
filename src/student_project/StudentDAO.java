package student_project;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Jawahar@123456");
    }

    public void addStudent(Student s) throws SQLException {
        String sql = "INSERT INTO student(rnumber,sname,branch,yearOfstudy,grade,phonenum) VALUES (?,?,?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getRnumber());
            stmt.setString(2, s.getSname());
            stmt.setString(3, s.getBranch());
            stmt.setInt(4, s.getYearOfstudy());
            stmt.setString(5, s.getGrade());
            stmt.setLong(6, s.getPhonenum());
            stmt.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setRnumber(rs.getInt("rnumber"));
                s.setSname(rs.getString("sname"));
                s.setBranch(rs.getString("branch"));
                s.setYearOfstudy(rs.getInt("yearOfstudy"));
                s.setGrade(rs.getString("grade"));
                s.setPhonenum(rs.getLong("phonenum"));
                list.add(s);
            }
        }
        return list;
    }

    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id=?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void updateStudent(Student s) throws SQLException {
        String sql = "UPDATE student SET name=?, roll_no=?, course=?, grade=? WHERE id=?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setInt(1, s.getRnumber());
        	stmt.setString(2, s.getSname());
            stmt.setString(3, s.getBranch());
            stmt.setInt(4, s.getYearOfstudy());
            stmt.setString(5, s.getGrade());
            stmt.setLong(6, s.getPhonenum());
            
            
            stmt.executeUpdate();
        }
    }
}
