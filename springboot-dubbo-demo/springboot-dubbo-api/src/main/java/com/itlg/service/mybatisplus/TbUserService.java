package com.itlg.service.mybatisplus;

import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.exception.R;

import java.util.List;
public interface TbUserService   {
    R<List<TbUserBO>> findAllUser();
}
