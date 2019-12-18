package com.pei.liu.springboot.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @description：
 * @author：liupei
 * @create: 2019-12-15 21:19
 * @version: 1.0$
 */
//@Component
//@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("DirectReceiver消费者收到消息  : " + map.toString());
    }

}


