package com.itlg.service;

/**
 * 账户的业务接口
 */
public interface IAccountService {
    /**
     * 保存账户
     */
    void saveAccount();

    /**
     * 跟新账户
     */
    void updateAccount(int i);

    /**
     * 删除账户
     */
    int deleteAccount();
}
