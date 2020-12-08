package com.itlg.service.mybatisplus;

import com.baomidou.mybatisplus.extension.api.R;
import com.itlg.entity.bo.mybatisplus.TbUserBO;

import java.util.List;
public interface TbUserService   {
    R<List<TbUserBO>> findAllUser();
}
