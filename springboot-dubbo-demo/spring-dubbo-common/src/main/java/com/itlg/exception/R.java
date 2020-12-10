package com.itlg.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class R<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public R(CodeMsg statusMsg, T data) {
        this.status = statusMsg.getCode();
        this.message = statusMsg.getMsg();
        this.data = data;
    }

    public R(CodeMsg statusMsg) {
        this.status = statusMsg.getCode();
        this.message = statusMsg.getMsg();
        this.data = null;
    }

    public R(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public static <E> R<E> success(E data) {
        return new R(CodeMsg.SUCCESS, data);
    }

    public static <E> R<E> fail(CodeMsg statusMsg) {
        statusMsg = ObjectUtils.isEmpty(statusMsg) ? CodeMsg.ERROR : statusMsg;
        return new R(statusMsg);
    }

    public static <E> R<E> fail() {
        return new R(CodeMsg.ERROR.getCode(), CodeMsg.ERROR.getMsg());
    }
}
