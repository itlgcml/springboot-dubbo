package com.itlg.service.tree;

import com.itlg.entity.vo.TbTreeVO;
import com.itlg.excepion.R;

import java.util.List;

public interface TbTreeOrderBOService {

    /**
     * 获得树的结构
     * @return
     */
    R<List<TbTreeVO>> getTbTree();
}
