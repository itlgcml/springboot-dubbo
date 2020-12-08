package com.itlg.controller;

import com.itlg.entity.bo.Message;
import com.itlg.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/query")
    public List<Message> demo() {
         return demoService.findMessage();
    }



}
