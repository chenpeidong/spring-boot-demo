package site.syso.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MsgSenderTest {

    @Autowired
    private MsgSender msgSender;

    @Test
    public void send() {
        msgSender.queue("test1 . message");
    }
}