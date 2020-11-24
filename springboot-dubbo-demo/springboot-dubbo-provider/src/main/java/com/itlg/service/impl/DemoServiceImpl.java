package com.itlg.service.impl;

import com.itlg.entity.po.Message;
import com.itlg.mapper.DemoMapper;
import com.itlg.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Message> findMessage() {
        return demoMapper.findMessage();
    }

}
