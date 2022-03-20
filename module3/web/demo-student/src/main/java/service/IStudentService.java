package service;

import model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> AllStudent();

    List<String> saveStudent(Student student);

    Student findByCode(int code);

    void updateStudent(Student student);

    void remove(int id);

    List<Student> search(String name);
}
