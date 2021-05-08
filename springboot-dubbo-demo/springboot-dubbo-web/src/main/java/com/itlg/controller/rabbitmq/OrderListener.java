package com.itlg.controller.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 延时队列监听
 */


@Component
@Slf4j
public class OrderListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //1.接收转换消息
            log.info(new String(message.getBody()));
            //2. 处理业务逻辑
            log.info("处理业务逻辑...");
            //3. 手动签收
            channel.basicAck(deliveryTag, true);
        } catch (IOException e) {
            //e.printStackTrace();
            //4.拒绝签收
            //第三个参数：requeue：重回队列。如果设置为true，则消息重新回到queue，broker会重新发送该消息给消费端
            log.info("出现异常拒绝签收！");
            //不重回队列，才能路由到死信队列中
            channel.basicNack(deliveryTag, true, false);
        }
    }
}
