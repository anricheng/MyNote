package com.example.hui.template.ioc.view;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)// FIELD 属性  METHOD方法  TYPE 放在类上
@Retention(RetentionPolicy.RUNTIME)// SOURCE 编译时检测  RUNTIME运行时检测
public @interface ViewById {// @interface annotation 注解
    int value();// 该注解后面可以带值   int
}
