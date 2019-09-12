package site.syso;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.syso.redis.RedisPublisher;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private RedisPublisher publisher;

    @Test
    public void main() {
        publisher.sendMessage("This is a message !");
    }
}