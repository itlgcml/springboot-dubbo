package com.itlg.serviceImpl.aop;

import com.itlg.entity.Enum.BoolEnum;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLog {
    BoolEnum bool();
}
