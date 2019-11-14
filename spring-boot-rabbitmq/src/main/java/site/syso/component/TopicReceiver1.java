package site.syso.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver1 {

    @RabbitListener(queues = "#{queue2.name}")
    public void receive(String message) {
        System.out.println("TopicReceiver1. receive message : " + message);
    }

}
