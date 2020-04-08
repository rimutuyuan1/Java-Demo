package com.forezp.thread.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @desc:技术统计
 * @author: CSH
 **/
@Aspect
@Component
public class GameDataAspect {

    private static final Logger logger = LoggerFactory.getLogger(GameDataAspect.class);

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.forezp.thread.aop.aopController.*(..))")
    public void GameDataAspect(){

    }

    /**
     * @description  使用环绕通知
     */
    @Around("GameDataAspect()")
    public void doAroundGameData(ProceedingJoinPoint joinPoint) {
        try{
            joinPoint.proceed();
            Object[] args = joinPoint.getArgs();
            logger.info("around args is : ", args);
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            logger.info("around MethodSignature is {}", signature);
            Method method = signature.getMethod();
            logger.info("around Method is {}", method);
            Class<?> clazz = method.getDeclaringClass();
            boolean isIgnoreLog = clazz.isAnnotationPresent(IgnoreLog.class);
            if (!isIgnoreLog) {
                logger.info("this method be used the annotation : 【IgnoreLog】");
            }
        }
        catch(Throwable e){
            logger.error(e.getMessage(), e);
        }
    }
}