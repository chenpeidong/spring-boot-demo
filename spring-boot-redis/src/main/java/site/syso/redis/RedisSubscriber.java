package site.syso.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisSubscriber {

    public void onMessage(String message) {
        System.out.println("接收消息:" + message);
    }

}
