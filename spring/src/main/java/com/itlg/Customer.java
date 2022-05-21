package com.itlg;

import org.springframework.stereotype.Component;

@Component
public class Customer implements Check{
    @Override
    public void check(Integer type) {
        System.out.println("客户校验");
    }
}
