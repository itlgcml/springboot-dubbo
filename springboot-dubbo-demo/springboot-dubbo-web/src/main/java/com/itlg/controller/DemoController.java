package com.itlg.controller;

import com.itlg.entity.bo.Message;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.service.DemoService;
import com.itlg.service.mybatisplus.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private TbUserService tbuserService;


    @RequestMapping(value = "/query")
    public List<Message> demo() {
         return demoService.findMessage();
    }

    @RequestMapping(value = "/e")
    public List<TbUserBO> demo1() {
        return tbuserService.findAllUser();
    }

}
