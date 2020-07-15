package com.nostalgia.rabbit_springboot.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="directs",type = "direct"),
                    key = {"info","error","warn"}
            )
    })
    public void receive1(String msg){
        System.out.println("msg1 = "+msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name="directs",type = "direct"),
                    key = {"warn"}
            )
    })
    public void receive2(String msg){
        System.out.println("msg2 = "+msg);
    }
}
