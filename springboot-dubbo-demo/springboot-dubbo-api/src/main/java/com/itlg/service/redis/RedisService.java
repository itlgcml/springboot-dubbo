package com.itlg.service.redis;

import com.itlg.excepion.R;

/**
 * redis相关操作
 */
public interface RedisService {
    R<Long> redisSinceGrowth();
}
