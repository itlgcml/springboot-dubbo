package com.itlg.service.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;

import java.util.List;
public interface TbUserService   {
    List<TbUserBO> findAllUser();
}
