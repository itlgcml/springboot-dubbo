/*
package com.itlg.controller.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//最简单的模式，暂已不用
@Component
public class RabbitMQListener {
    @RabbitListener(queues = "test_queue_confirm")
    public void listenerQueue(Message message){
        System.out.println(message.toString());
    }
}
*/
