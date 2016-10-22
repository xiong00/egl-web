package com.xph.web.config.datasource;


import com.xph.web.annotation.TargetDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.lang.reflect.Method;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by huipei.x on 2016/10/19 0019.
 */
@Component
@Aspect
@Order(-1)
public class TargetDataSourceAspect {

    /**
     * 任何public方法
     */
    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {}

    /**
     * 任何标记了注解的类
     * @param targetDataSource
     */
    @Pointcut(value = "@within(targetDataSource)", argNames = "targetDataSource")
    public void annotationOnClass(TargetDataSource targetDataSource){}

    @Around(
            value = "anyPublicMethod() && annotationOnClass(targetDataSource)",
            argNames = "proceedingJoinPoint,targetDataSource"
    )
    public Object methodInvoke(
            ProceedingJoinPoint proceedingJoinPoint,
            TargetDataSource targetDataSource) throws Throwable {
        checkNotNull(targetDataSource,"@TargetDataSource为空");
        String dbKey = null;
        MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = ms.getMethod();

        // 方法是否标注了注解 TargetDataSource
       if(method.isAnnotationPresent(TargetDataSource.class)){
            targetDataSource = method.getAnnotation(TargetDataSource.class);
        }


        dbKey = targetDataSource.value();
        if (!StringUtils.hasText(dbKey)) {
            dbKey = DbKey.DEFAULT;
        }
        DataSourceContextHolder.initDbContext(dbKey);
        Object result = proceedingJoinPoint.proceed();
        DataSourceContextHolder.destroyDbContext();
        return result;
    }
}
