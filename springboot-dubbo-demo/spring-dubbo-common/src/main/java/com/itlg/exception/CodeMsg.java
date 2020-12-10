package com.itlg.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeMsg implements Serializable {
    public static final CodeMsg SUCCESS = new CodeMsg(200,"ok");
    public static final CodeMsg ERROR = new CodeMsg(501,"服务器异常1");

    private int code;
    private String msg;
}
