package com.itlg.config;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MsgConfirm implements RabbitTemplate.ConfirmCallback {

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;

    /**
     * 构造方法注入rabbitTemplate
     */
    @Autowired
    public MsgConfirm(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //需要调用回调的话，则需要此行
    }

    public void convertAndSend(String exchange, String routeKey, String content) {
        CorrelationData correlationId = new CorrelationData(String.valueOf(IdWorker.getId()));
        //把消息放入exchange交换机中，对应key为queue
        rabbitTemplate.convertAndSend(exchange, routeKey, content, correlationId);
    }

    /**
     * 添加延时的
     *
     * @param exchange
     * @param routingKey
     * @param content
     */
    public void convertAndSendTtl(String exchange, String routingKey, String content) {
        CorrelationData correlationId = new CorrelationData(String.valueOf(IdWorker.getId()));
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //1.设置message的信息
                message.getMessageProperties().setExpiration("5000");//消息的过期时间
                //2.返回该消息
                return message;
            }
        };
        rabbitTemplate.convertAndSend(exchange, routingKey, content, messagePostProcessor, correlationId);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调id:" + correlationData);
        if (ack) {
            log.info("消息发送成功");
        } else {
            log.info("消息发送失败:" + cause);
        }

    }
}
