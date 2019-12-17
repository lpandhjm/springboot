package com.pei.liu.springboot.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description：
 * @author：liupei
 * @create: 2019-12-15 23:01
 * @version: 1.0$
 */
@Component
@RabbitListener(queues = "fanoutC")
public class FanoutReceiverC {

    @RabbitHandler
    public void handle(Map message) {
        System.out.println("fanoutC收到队列消息"+message);
    }

}
