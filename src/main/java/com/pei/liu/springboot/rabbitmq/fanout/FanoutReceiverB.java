package com.pei.liu.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-15 22:57
 * @version: 1.0$
 */
//@Component
//@RabbitListener(queues = "fanoutB")
public class FanoutReceiverB {

    @RabbitHandler
    public void handle(Map message) {
        System.out.println("fanoutB收到队列消息"+message);
    }
}
