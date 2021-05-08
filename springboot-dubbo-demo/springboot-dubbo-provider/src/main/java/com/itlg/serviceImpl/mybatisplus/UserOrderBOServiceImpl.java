package com.itlg.serviceImpl.mybatisplus;

import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.excepion.BusinessRuntimeException;
import com.itlg.excepion.CodeMsg;
import com.itlg.excepion.R;
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
        //int i = 1/0;
        return R.success(userOrderBOMapper.queryUserOrderBOPage());
    }
}
