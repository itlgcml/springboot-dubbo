package com.itlg.excepion;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class R<T> implements Serializable {
    private int code;
    private String msg = "ok";
    private T data;

    public R() {
        this.code = CodeMsg.SUCCESS.getCode();
    }

    public R(CodeMsg codeMsg, T data, String msg) {
        this.code = null == codeMsg ? CodeMsg.SUCCESS.getCode() : codeMsg.getCode();
        this.data = data;
        this.msg = msg;
    }

    public static <E> R<E> success(E data) {
        return new R<>(CodeMsg.SUCCESS, data, "ok");
    }

    public static R<Boolean> success() {
        return new R<>(CodeMsg.SUCCESS, true, "ok");
    }

    public static <E> R<E> fail(CodeMsg codeMsg) {
        return new R(codeMsg, false, "error");
    }

    public static R fail() {
        return new R<>(CodeMsg.FAIL, null, "error");
    }

    public static R fail(String msg) {
        return new R<>(CodeMsg.FAIL, null, msg);
    }

    public static R fail(Exception exception) {
        return new R<>(CodeMsg.FAIL, exception, "error");
    }

}
