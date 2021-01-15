package com.itlg.serviceImpl.mybatisplus;

import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.exception.R;
import com.itlg.mapper.mybatisplus.UserOrderBOMapper;
import com.itlg.service.mybatisplus.UserOrderBOService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service("userOrderBOService")
public class UserOrderBOServiceImpl implements UserOrderBOService {


    @Autowired
    private UserOrderBOMapper userOrderBOMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<UserOrderBO>> allUserOrder() {
        return R.success(userOrderBOMapper.queryUserOrderBOPage());
    }
}
