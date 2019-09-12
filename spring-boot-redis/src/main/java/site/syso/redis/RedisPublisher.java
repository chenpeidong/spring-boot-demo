package site.syso.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisPublisher {

    @Value("${topic}")
    private String subChannel;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void sendMessage(String message) {
        System.out.println("发布消息:" + message);
        redisTemplate.convertAndSend(subChannel, message);
    }

}
