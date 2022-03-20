package reponsitory.Iplm;

import model.Student;
import reponsitory.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements IStudentRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Student> AllStudent() {
        List<Student> studentList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student;
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("code_student"));
                student.setName(resultSet.getString("name_student"));
                student.setBirthday(resultSet.getString("birthday_student"));
                student.setEmail(resultSet.getString("email_student"));
                student.setPoint(resultSet.getDouble("point_student"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("insert into demo_c1021g1.student(code_student,name_student, birthday_student, email_student, point_student) value (?,?,?,?,?)");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getBirthday());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setDouble(5, student.getPoint());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student finByCode(int code) {
        Student student=null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from student where code_student = ?");
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(code);
                student.setName(resultSet.getString("name_student"));
                student.setBirthday(resultSet.getString("birthday_student"));
                student.setEmail(resultSet.getString("email_student"));
                student.setPoint(resultSet.getDouble("point_student"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {
        try {

            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("update student set  name_student = ?,birthday_student = ?,email_student = ?,point_student = ? where code_student = ?");

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getBirthday());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setDouble(4, student.getPoint());
            preparedStatement.setInt(5, student.getId());
            int row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("delete from student where code_student = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> search(String name) {
        List<Student> studentList = new ArrayList<>();
        Student student;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from student where name_student = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("code_student"));
                student.setName(resultSet.getString("name_student"));
                student.setBirthday(resultSet.getString("birthday_student"));
                student.setEmail(resultSet.getString("email_student"));
                student.setPoint(resultSet.getDouble("point_student"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
