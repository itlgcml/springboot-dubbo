package com.itlg.serviceImpl.rabbitMQ;

import com.itlg.config.rabbitmq.MsgConfirm;
import com.itlg.config.rabbitmq.MsgReturn;
import com.itlg.service.rabbitmq.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("rabbitMQService")
@Slf4j
public class RabbitMQServiceImpl implements RabbitMQService {
    @Autowired
    private MsgConfirm msgConfirm;
    @Autowired
    private MsgReturn msgReturn;
    //这种方法会有问题，需要多例
//    @Override
//    public void test(String msg) {
//        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
//            @Override
//            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//                log.info(" 回调id:" + correlationData);
//                if (ack) {
//                    log.info("消息发送成功");
//                } else {
//                    log.info("消息发送失败:" + cause);
//                }
//            }
//        });
//        rabbitTemplate.convertAndSend("test_exchange_confirm", "", msg);
//
//    }

    @Override
    public void testConfirm(String msg) {
        for (int i = 0; i < 10; i++) {
            msgConfirm.convertAndSend("test_exchange_confirm", "", msg + i);
        }
    }

    @Override
    public void testReturn(String msg) {
        msgReturn.convertAndSend("test_exchange_confirm", "", msg);
    }

    @Override
    public void testTTL(String msg) {
        msgConfirm.convertAndSendTtl("test_exchange_ttl", "ttl.123", msg);
    }

    @Override
    public void testDeathInfo(String msg) {
        //消息过期后进入死信队列
        msgConfirm.convertAndSendTtl("test_exchange_dlx", "test.dlx.#", msg);
  /*      //消息长度超过限制后进入死信队列
        for (int i = 0; i < 20; i++) {
            msgConfirm.convertAndSendTtl("test_exchange_dlx", "test.dlx.#", msg + i);
        }*/
        /*//测试消息拒收后消息进入到死信队列。这一种展示监听不关闭无法到死信队列
        msgConfirm.convertAndSendTtl("test_exchange_dlx", "test.dlx.#", msg);*/

    }

    @Override
    public void testOrderInfo(String msg) {
        msgConfirm.convertAndSend("order_exchange", "order.123", msg);
    }
}
