package site.syso.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import site.syso.bean.Student;
import site.syso.repository.StudentRepository;

@Component
public class StudentComponent {

    @Autowired
    private StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public void delete(Long id) {
        studentRepository.delete(new Student().setId(id));
    }

}
