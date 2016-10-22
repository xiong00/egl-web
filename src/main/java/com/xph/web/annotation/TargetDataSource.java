package com.xph.web.annotation;

import java.lang.annotation.*;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
@Documented
@Inherited  // 声明注解可继承
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TargetDataSource {
    String value() default "";
}
