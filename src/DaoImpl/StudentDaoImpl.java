package DaoImpl;

import connection.ConnectionFactory;
import interfaceDao.StudentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDaoImpl implements StudentDao {

    Student s;

    Connection conn = ConnectionFactory.getConnection();

    PreparedStatement ps;

    ResultSet rs;

    public StudentDaoImpl() {

    }

    @Override
    public void create(Student s) {

        try {
            String query = "INSERT INTO student (id, firstname, lastname) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(query);

            ps.setInt(1, s.getId());
            ps.setString(2, s.getFirstname());
            ps.setString(3, s.getLastname());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Student s) {

        try {
            String query = "UPDATE student SET firstname = ?, lastname = ? WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, s.getFirstname());
            ps.setString(2,s.getLastname());
            ps.setInt(3, s.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {

        try {
            String query = "DELETE FROM student WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> findAll() {

        List<Student> sList = new ArrayList<>();

        try {
            String query = "SELECT * FROM student ORDER BY id";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Student();
                s.setId(rs.getInt("id"));
                s.setFirstname(rs.getString("firstname"));
                s.setLastname(rs.getString("lastname"));
                sList.add(s);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sList;

    }

    @Override
    public Student findById(int id) {

        try {
            String query = "SELECT * FROM student WHERE id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.next();
            s = new Student();
            s.setId(rs.getInt("id"));
            s.setFirstname(rs.getString("firstname"));
            s.setLastname(rs.getString("lastname"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;

    }

}
