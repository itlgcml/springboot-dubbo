package com.itlg.controller.rabbitmq;

import com.itlg.service.rabbitmq.RabbitMQService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping(value = "/rabbitmq")
@Api(tags = "rabbitmq各种知识点集合")
public class RabbitMQController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @GetMapping(value = "/testConfirm")
    @ApiOperation(value = "测试Confirm")
    public void testConfirm(@RequestParam @Valid @NotNull(message = "msg") String msg) {
       rabbitMQService.testConfirm(msg);
    }

    @GetMapping(value = "/testReturn")
    @ApiOperation(value = "测试return")
    public void returnConfirm(@RequestParam @Valid @NotNull(message = "msg不能为空")String msg) {
        rabbitMQService.testReturn(msg);
    }
}
