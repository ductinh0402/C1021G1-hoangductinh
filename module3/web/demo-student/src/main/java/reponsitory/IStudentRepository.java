package reponsitory;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> AllStudent();

    void saveStudent(Student student);

    Student finByCode(int code);

    void updateStudent(Student student);

    void remove(int id);

    List<Student> search(String name);
}
