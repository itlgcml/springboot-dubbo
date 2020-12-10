package com.itlg.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessRunTimeException extends RuntimeException  {

    private CodeMsg codeMsg;

    public BusinessRunTimeException(CodeMsg codeMsg ) {
        super(codeMsg.getMsg());
        this.codeMsg = codeMsg;
    }

    public BusinessRunTimeException(CodeMsg codeMsg, String msg ) {
        super(msg);
        codeMsg.setMsg(msg);
        this.codeMsg = codeMsg;
    }
}
