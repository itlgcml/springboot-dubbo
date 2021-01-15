package com.itlg.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.exception.R;

import java.util.List;

public interface TbUserService extends IService<TbUserBO> {
    R<List<TbUserBO>> findAllUser();
}
