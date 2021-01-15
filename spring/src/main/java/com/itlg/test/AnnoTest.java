package com.itlg.test;

import com.itlg.entity.Person;
import com.itlg.util.Sout;

import java.lang.annotation.Annotation;

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
