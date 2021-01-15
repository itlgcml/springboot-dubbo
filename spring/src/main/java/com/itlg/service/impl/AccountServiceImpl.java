package com.itlg.service.impl;

import com.itlg.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了跟新");
    }


    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
