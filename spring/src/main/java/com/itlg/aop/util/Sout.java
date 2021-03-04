package com.itlg.aop.util;

import com.itlg.aop.entity.Person;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
自定义注解
        格式
        元注解
        Public @interface 注解名称{}
本质上，注解实际就是一个接口，该接口默认继承annotation接口
    属性：
        接口中的抽象方法
    要求：
        1_属性的返回值类型只能是一些类型
            基本数据类型
            String
            枚举
            注解
            以上类型的数组
        2_定义了属性，在使用时就需要给属性复制，默认可以用default
*/

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sout {
    int age();

    String method();

    Person person();

    String[] array();

}
