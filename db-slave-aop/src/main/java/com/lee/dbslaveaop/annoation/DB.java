package com.lee.dbslaveaop.annoation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DB {
    public String value() default "matserdb";
}
