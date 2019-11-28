package site.syso.component;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.syso.bean.Student;
import site.syso.repository.StudentRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentComponentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void save() {
        Student stu = new Student();
        stu.setId(4L);
        stu.setName("Bob");
        stu.setHobby("biu biu biu~~");
        stu.setBirthday(new Date());
        studentRepository.save(stu);
    }

    @Test
    public void findById() {
        Student stu = studentRepository.findById(1L).orElse(null);
        System.out.println(stu);
    }

    @Test
    public void findByName() {
        List<Student> bob = studentRepository.findByName("Bob");
        bob.forEach(System.out::println);
    }

    @Test
    public void delete() {
        studentRepository.delete(new Student().setId(3L));
    }
}