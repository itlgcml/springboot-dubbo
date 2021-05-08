package com.itlg.service.mybatisplus;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itlg.entity.bo.mybatisplus.TbUserBO;
import com.itlg.excepion.R;

import java.util.List;

public interface TbUserService extends IService<TbUserBO> {
    /**
     * 查询所有用户
     * @return
     */
    R<List<TbUserBO>> findAllUser();

    R testGrowth();
}
