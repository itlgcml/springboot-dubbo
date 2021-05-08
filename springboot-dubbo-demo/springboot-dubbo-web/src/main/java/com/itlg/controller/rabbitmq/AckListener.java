package com.itlg.controller.rabbitmq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Consumer ACK机制：
 * 1. 设置手动签收。acknowledge="manual"
 * 2. 让监听器类实现ChannelAwareMessageListener接口
 * 3. 如果消息成功处理，则调用channel的 basicAck()签收
 * 4. 如果消息处理失败，则调用channel的basicNack()拒绝签收，broker重新发送给consumer
 */


@Component
@Slf4j
public class AckListener implements ChannelAwareMessageListener {
    @Override
    @RabbitListener(queues = "test_queue_confirm")
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
            channel.basicNack(deliveryTag, true, true);
        }
    }
}
