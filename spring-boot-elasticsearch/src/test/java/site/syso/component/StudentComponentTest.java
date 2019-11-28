package site.syso.component;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.syso.bean.Student;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentComponentTest {

    @Autowired
    private StudentComponent studentComponent;

    @Test
    public void save() {
        Student stu = new Student();
        stu.setId(4L);
        stu.setName("Bob");
        stu.setHobby("biu biu biu~~");
        stu.setBirthday(new Date());
        studentComponent.save(stu);
    }

    @Test
    public void findById() {
        Student stu = studentComponent.findById(1L);
        System.out.println(stu);
    }

    @Test
    public void findByName() {
        List<Student> bob = studentComponent.findByName("Bob");
        bob.forEach(System.out::println);
    }

    @Test
    public void delete() {
        studentComponent.delete(3L);
    }
}