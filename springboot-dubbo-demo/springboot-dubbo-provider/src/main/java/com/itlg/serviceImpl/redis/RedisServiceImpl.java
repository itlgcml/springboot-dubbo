package com.itlg.serviceImpl.redis;

import com.itlg.excepion.R;
import com.itlg.service.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    private static final String redisSinceGrowth = "test_sinceGrowth_num";

    @Override
    public R<Long> redisSinceGrowth() {
        Long increment = redisTemplate.boundValueOps(redisSinceGrowth).increment(1);
        return R.success(increment);
    }
}
