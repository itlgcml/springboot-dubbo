package com.itlg.service.mybatisplus;


import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.excepion.R;

import java.util.List;

public interface UserOrderBOService {
    /**
     * mybatis一对多
     * @return
     */
    R<List<UserOrderBO>> allUserOrder();

}
