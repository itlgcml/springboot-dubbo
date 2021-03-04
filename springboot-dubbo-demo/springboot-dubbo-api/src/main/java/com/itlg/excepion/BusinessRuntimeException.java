package com.itlg.excepion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BusinessRuntimeException extends RuntimeException {
    private CodeMsg codeMsg;
    public BusinessRuntimeException(CodeMsg codeMsg){
        super(codeMsg.getMsg());
    }
}
