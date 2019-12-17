package com.pei.liu.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-15 22:53
 * @version: 1.0$
 */

@Component
@RabbitListener(queues = "fanoutA")
public class FanoutReceiverA {


    @RabbitHandler
    public void handle(Map message) {
        System.out.println("收到fanoutA队列消息"+message);
    }

}
