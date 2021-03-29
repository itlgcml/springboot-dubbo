package com.itlg.controller.redis;

import com.itlg.excepion.R;
import com.itlg.service.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/redis")
@Api(tags = "redis各种知识点集合")
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping(value = "/redisSinceGrowth")
    @ApiOperation(value = "测试redis自增长")
    public R<Long> redisSinceGrowth() {
        return redisService.redisSinceGrowth();
    }
}
