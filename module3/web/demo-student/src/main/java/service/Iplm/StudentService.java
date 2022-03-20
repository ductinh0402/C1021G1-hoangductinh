package service.Iplm;
import model.Student;
import reponsitory.IStudentRepository;
import reponsitory.Iplm.StudentRepository;
import service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private static final String REGEX_BIRTHDAY = "^[0-9]{1,2}(/)[0-9]{1,2}(/)(20|19)[0-9]{2}$";
    private static IStudentRepository iStudentRepository=new StudentRepository();

    @Override
    public List<Student> AllStudent() {
        List<Student> studentList=iStudentRepository.AllStudent();
     if (studentList.size()==0){
         return null;
     }else {
         return iStudentRepository.AllStudent();
     }
    }

    @Override
    public List<String> saveStudent(Student student) {
        boolean isStatus=true;
        List<String> error=new ArrayList<>();
        if (!student.getBirthday().matches(REGEX_BIRTHDAY)){
            error.add("Ngày tháng năm k phù hơp ok");
            isStatus=false;
        }
        if (isStatus){
            iStudentRepository.saveStudent(student);
        }
        return error;
    }

    @Override
    public Student findByCode(int code) {
        return iStudentRepository.finByCode(code);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.updateStudent(student);
    }

    @Override
    public void remove(int id) {
        iStudentRepository.remove(id);
    }

    @Override
    public List<Student> search(String name) {
        return iStudentRepository.search(name);
    }
}
