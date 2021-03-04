package com.itlg.excepion;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CodeMsg implements Serializable {

    SUCCESS(0,"成功"),
    FAIL(500,"操作失败"),
    ;

    private int code;
    private String msg;


}
