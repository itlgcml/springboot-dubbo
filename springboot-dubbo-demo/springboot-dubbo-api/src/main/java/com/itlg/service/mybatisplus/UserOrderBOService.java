package com.itlg.service.mybatisplus;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itlg.entity.bo.mybatisplus.UserOrderBO;
import com.itlg.exception.R;

import java.util.List;

public interface UserOrderBOService {
    R<List<UserOrderBO>> allUserOrder();

}
