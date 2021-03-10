package com.itlg.serviceImpl.rabbitMQ;

import com.itlg.config.MsgConfirm;
import com.itlg.config.MsgReturn;
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


    /*这种方法会有问题，需要多例
      @Override
        public void testConfirm(String msg) {
            rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback()  {
                @Override
                public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                    log.info(" 回调id:" + correlationData);
                    if (ack) {
                        log.info("消息发送成功");
                    } else {
                        log.info("消息发送失败:" + cause);
                    }
                }
            });
            rabbitTemplate.convertAndSend("test_exchange_confirm","",msg);

        }*/
    @Override
    public void testConfirm(String msg) {
        for (int i = 0; i < 10; i++) {
            msgConfirm.convertAndSend("test_exchange_confirm", "", msg + i);
        }
    }

    @Override
    public void testReturn(String msg) {
        msgReturn.convertAndSend("test_exchange_confirm", "2222", msg);
    }

    @Override
    public void testTTL(String msg) {
        msgConfirm.convertAndSendTtl("test_exchange_ttl", "ttl.123", msg);
    }
}
