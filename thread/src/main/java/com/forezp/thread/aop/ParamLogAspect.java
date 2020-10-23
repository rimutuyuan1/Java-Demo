package com.forezp.thread.aop;

import com.forezp.thread.aop.proxy.ProxyFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 王鑫涛
 * @Description PRC接口入参/出参日志打印切面
 * @Date 2020/9/3 23:13 下午
 **/
@Aspect
@Component
public class ParamLogAspect {

    @Pointcut("@annotation(com.forezp.thread.aop.ParamLog)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        IUserInterface target = new UserServiceImpl();
        ProceedingJoinPoint proxy = (ProceedingJoinPoint) new ProxyFactory(target).getProxyInstance();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        ParamLog paramLog = method.getAnnotation(ParamLog.class);
        if (paramLog != null) {
            System.out.println("request input param : -----");
            Object outputParam = proxy.proceed();
            System.out.println("response output param : ------");
            return outputParam;
        }
        return null;
    }

}
