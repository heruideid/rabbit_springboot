package com.nostalgia.rabbit_springboot.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="topics",type = "topic"),
                    key = {"user.save","user.*"}

            )
    })
    public void receive1(String msg){
        System.out.println("msg1 = "+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="topics",type = "topic"),
                    key = {"order.save","user.#"}

            )
    })
    public void receive2(String msg){
        System.out.println("msg2 = "+msg);
    }
}
