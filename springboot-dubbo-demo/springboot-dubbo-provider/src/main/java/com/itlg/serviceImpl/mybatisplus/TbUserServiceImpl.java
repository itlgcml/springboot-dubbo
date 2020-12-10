package com.itlg.serviceImpl.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.exception.R;
import com.itlg.mapper.mybatisplus.TbUserMapper;
import com.itlg.service.mybatisplus.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public R<List<TbUserBO>> findAllUser() {
        return R.success(userMapper.selectList(null));
    }
}
