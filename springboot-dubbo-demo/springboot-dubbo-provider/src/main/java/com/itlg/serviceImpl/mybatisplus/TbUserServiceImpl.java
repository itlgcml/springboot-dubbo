package com.itlg.serviceImpl.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itlg.entity.Enum.BoolEnum;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.excepion.R;
import com.itlg.mapper.mybatisplus.TbUserMapper;
import com.itlg.service.mybatisplus.TbUserService;
import com.itlg.aop.AopLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "tbUserService")
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUserBO> implements TbUserService {
    @Autowired
    private TbUserMapper userMapper;

    @Override
    @AopLog(bool = BoolEnum.TRUE)
    public R<List<TbUserBO>> findAllUser() {
        return R.success(userMapper.selectList(null));
    }
}
