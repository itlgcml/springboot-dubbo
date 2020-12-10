package com.itlg.mapper.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserOrderBOMapper extends BaseMapper<UserOrderBO> {
    List<UserOrderBO> queryUserOrderBOPage();
}
