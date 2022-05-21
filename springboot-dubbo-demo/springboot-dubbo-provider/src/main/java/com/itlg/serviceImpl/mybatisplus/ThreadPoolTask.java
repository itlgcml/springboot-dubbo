package com.itlg.serviceImpl.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.mapper.mybatisplus.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class ThreadPoolTask implements Runnable {

    @Autowired
    private ObjectFactory<T> objectFactory;

    @Autowired
    private TbUserMapper userMapper;
    //插入数据的入参
    @Autowired
    TbUserBO vo;
    //插入成功后返回的数据
    @Autowired
    Vector<TbUserBO> resultList;
    //业务需要的参数

    public ThreadPoolTask( TbUserBO vo, Vector<TbUserBO> resultList) {
        this.vo = vo;
        this.resultList = resultList;
    }


    @Override
    public void run() {
        insert( vo);
    }

    private void insert(TbUserBO vo) {
        try {
            userMapper.insert(vo);
            Long id = vo.getId();
            TbUserBO tbUserBO = userMapper.selectById(id);
            resultList.add(tbUserBO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
