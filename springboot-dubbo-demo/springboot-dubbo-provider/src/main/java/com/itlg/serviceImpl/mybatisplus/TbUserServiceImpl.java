package com.itlg.serviceImpl.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlg.entity.Enum.BoolEnum;
import com.itlg.entity.bo.multithreading.MultithreadingTestBO;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.excepion.R;
import com.itlg.mapper.multithreading.MultithreadingTestMapper;
import com.itlg.mapper.mybatisplus.TbUserMapper;
import com.itlg.service.mybatisplus.TbUserService;
import com.itlg.aop.AopLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

@Service(value = "tbUserService")
@Slf4j
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUserBO> implements TbUserService {
    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private MultithreadingTestMapper multithreadingTestMapper;

    @Override
    @AopLog(bool = BoolEnum.TRUE)
    public R<List<TbUserBO>> findAllUser() {
        int i = 1 / 0;
        List<TbUserBO> tbUserBOList = userMapper.selectList(null);
        return R.success(tbUserBOList);
    }

    @Override
    public R testGrowth() {
        MultithreadingTestBO temp = new MultithreadingTestBO();
        synchronized (MultithreadingTestBO.class) {
            MultithreadingTestBO multithreadingTestBO = multithreadingTestMapper.selectById(1L);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Long id = multithreadingTestBO.getId();
            Long num = multithreadingTestBO.getNum();
            num++;
            temp.setId(id);
            temp.setNum(num);
            multithreadingTestMapper.updateById(temp);
        }
        return R.success(temp);
    }

    @Override
    public R testThreadPoolLatch() {
        final int corePoolSize = 6;
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, corePoolSize, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(200), handler);
        Vector<TbUserBO> resultList = new Vector<>();
        try {
            Vector<TbUserBO> list = new Vector<>();
            for (int i = 0; i < 6; i++) {
                TbUserBO tbUserBO = new TbUserBO();
                tbUserBO.setUsername(i + "a");
                tbUserBO.setPassword(i + "111");
                list.add(tbUserBO);
            }
            final CountDownLatch latch = new CountDownLatch(list.size());
            for (int i = 0; i < list.size(); i++) {
                ThreadPoolTask task = new ThreadPoolTask(list.get(i), resultList);
                executor.execute(task);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return R.success(resultList);
    }

}
