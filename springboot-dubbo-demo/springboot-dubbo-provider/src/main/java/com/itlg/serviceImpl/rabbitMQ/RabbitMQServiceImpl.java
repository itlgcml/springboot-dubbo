package com.itlg.serviceImpl.rabbitMQ;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itlg.config.MsgConfirm;
import com.itlg.config.MsgReturn;
import com.itlg.config.RabbitMQConfig;
import com.itlg.service.rabbitmq.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rabbitMQService")
public class RabbitMQServiceImpl implements RabbitMQService {
    @Autowired
    private MsgConfirm msgConfirm;

    @Autowired
    private MsgReturn msgReturn;

    @Override
    public void testConfirm(String msg) {
        msgConfirm.convertAndSend("test_exchange_confirm","test_queue_confirm",msg);
    }

    @Override
    public void testReturn(String msg) {
        msgReturn.convertAndSend("test_exchange_confirm","test_queue_confirm",msg);
    }
}
