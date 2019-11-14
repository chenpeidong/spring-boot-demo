package site.syso.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static site.syso.constant.Queue.QUEUE1;

@Component
public class QueueReceiver1 {

    @RabbitListener(queues = QUEUE1)
    public void receive(String message) {
        System.out.println("QueueReceiver1. receive message : " + message);
    }

}
