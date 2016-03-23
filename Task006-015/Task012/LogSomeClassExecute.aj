package Homework1.Task012;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Юра on 21.03.2016.
 */

public aspect LogSomeClassExecute {
    @Around("execution(* *..SomeClass.execute())")
    public Object testMethodExecuteWithSQLReqest(ProceedingJoinPoint pjp) throws Throwable {
        String request = (String) pjp.getArgs()[0];
        Pattern p = Pattern.compile(".*(;? ?(drop|update|select|insert) ?)*.*");
        Matcher m = p.matcher(request.toLowerCase());
        if(m.find()){
            return null;
        }
        return pjp.proceed();
    }
}
