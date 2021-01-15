package com.itlg.service.tree;

import com.itlg.entity.vo.TbTreeVO;
import com.itlg.exception.R;

import java.util.List;

public interface TbTreeOrderBOService {

    R<List<TbTreeVO>> getTbTree();
}
