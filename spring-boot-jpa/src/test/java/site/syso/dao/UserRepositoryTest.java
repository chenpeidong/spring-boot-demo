package site.syso.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.syso.bean.User;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);

        // 添加
        userRepository.save(user);

        // 查询
        User userByName = userRepository.findUserByName("张三");
        System.out.println(userByName);

        // 修改
        userByName.setName("李四");
        userRepository.save(userByName);
        User userById = userRepository.findUserById(userByName.getId());
        System.out.println(userById);

        // 删除
        userRepository.deleteUserById(userById.getId());
        System.out.println(userRepository.findUserById(userById.getId()));
    }

}