//package com.pei.liu.springboot.rabbitmq.fanout;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @description：
// * @author：liupei
// * @create: 2019-12-15 22:43
// * @version: 1.0$
// */
//@Configuration
//public class FanoutRabbitConfig {
////    队列
//
//    @Bean
//    public Queue fanoutQueueA(){
//        return  new Queue("fanoutA");
//    }
//    @Bean
//    public Queue fanoutQueueB(){
//        return  new Queue("fanoutB");
//    }
//
//    @Bean
//    public Queue fanoutQueueC(){
//        return  new Queue("fanoutC");
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return  new FanoutExchange("fanoutExchange");
//    }
//
//    @Bean
//    Binding bindingA() {
//        return BindingBuilder.bind(fanoutQueueA()).to(fanoutExchange());
//    }
//    @Bean
//    Binding bindingB() {
//        return BindingBuilder.bind(fanoutQueueB()).to(fanoutExchange());
//    }
//    @Bean
//    Binding bindingC() {
//        return BindingBuilder.bind(fanoutQueueC()).to(fanoutExchange());
//    }
//
//
//}
