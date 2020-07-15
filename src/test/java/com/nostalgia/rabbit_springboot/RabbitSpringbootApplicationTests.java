package com.nostalgia.rabbit_springboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitSpringbootApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void test() {
        rabbitTemplate.convertAndSend("hello","hello world!");
    }

    @Test
    void testFanout(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("logs","","fanout message"+i);
        }
    }

    @Test
    void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","workQueue message"+i);
        }
    }

    @Test
    void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","info message!");
        rabbitTemplate.convertAndSend("directs","warn","warn message!");

    }

    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save message!");
        rabbitTemplate.convertAndSend("topics","user.save.orz","user.save.orz message!");
        rabbitTemplate.convertAndSend("topics","order.save","order.save message!");
    }
}
