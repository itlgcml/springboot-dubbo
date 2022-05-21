package com.itlg;

import org.springframework.stereotype.Component;

@Component
public class Clue implements Check {
    @Override
    public void check(Integer type) {
        System.out.println("线索校验");
    }
}
