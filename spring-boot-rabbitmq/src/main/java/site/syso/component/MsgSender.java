package site.syso.component;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static site.syso.constant.Queue.QUEUE1;

@Component
public class MsgSender {

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void queue(String message) {
        rabbitTemplate.convertAndSend(QUEUE1, message);
    }

    public void topic(String message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
    }

}
