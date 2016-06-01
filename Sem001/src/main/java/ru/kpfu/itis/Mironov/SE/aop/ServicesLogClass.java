package ru.kpfu.itis.Mironov.SE.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Юра on 12.05.2016.
 */
@Aspect
public class ServicesLogClass {
    private static Logger serviceLogger = Logger.getLogger(ServicesLogClass.class);

    @Before("execution(* ru.kpfu.itis.Mironov.SE.services.*.*(..))")
    public void logForServiceInfo(JoinPoint jp) {
        final String INFO = new Date()
                + " Service method "
                + jp.getTarget().getClass().getSimpleName()
                + "."
                + jp.getSignature().getName()
                + "() invoke with parameters:"
                + Arrays.toString(jp.getArgs());
        serviceLogger.info(INFO);

    }
    @Around("execution(* ru.kpfu.itis.Mironov.SE.services.*.*(..))")
    public Object logToServiceWorkTimeInfo(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object method = pjp.proceed();
        long finish = System.currentTimeMillis();
        long result = finish - start;
        final String INFO = "End invocation of service method: " + result + "ms";
        serviceLogger.info(INFO);
        return method;
    }
}
