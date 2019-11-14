package site.syso.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver2 {

    @RabbitListener(queues = "#{queue3.name}")
    public void receive(String message) {
        System.out.println("TopicReceiver2. receive message : " + message);
    }

}
