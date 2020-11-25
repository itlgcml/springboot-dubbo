package com.itlg.service.impl.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.mapper.mybatisplus.TbUserMapper;
import com.itlg.service.mybatisplus.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tbUserService")
public class TbUserServiceImpl  implements TbUserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public List<TbUserBO> findAllUser() {
        return userMapper.selectList(null);
    }
}
