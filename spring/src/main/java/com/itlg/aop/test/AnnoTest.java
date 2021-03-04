package com.itlg.aop.test;

import com.itlg.aop.entity.Person;
import com.itlg.aop.util.Sout;

/**
 * 获取注解所给的值
 */
@Sout(age = 16, method = "show",person = Person.p1,array = {"123","321"})
public class AnnoTest {
    public static void main(String[] args) {
        Class<AnnoTest> annoTestClass = AnnoTest.class;
        Sout out = annoTestClass.getAnnotation(Sout.class);
        int  age = out.age();
        System.out.println(age);
    }
}
