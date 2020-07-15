package com.nostalgia.rabbit_springboot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String msg){
        System.out.println("msg1 = "+msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg){
        System.out.println("msg2 = "+msg);
    }
}
