package Homework1.Task011;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Юра on 09.03.2016.
 */
@Aspect
public class LogGame {
    @Before("execution(* *..ClientForm.sendData())")
    //Ловим попытки пользователя отправить данные на сервер
    public void logSend(JoinPoint jp) {
        System.out.println("User is trying to send data to the server");
    }

    @Around("execution(* *..Connection.stap())")
    //проверяем, не передали на вход метода null-объекты
    public Object logingGame(ProceedingJoinPoint pjp) throws Throwable {
        boolean flag = false;
        try {
            for (Object o : pjp.getArgs()) {
                flag &= o.equals(null);
            }
        } catch (NullPointerException npe) {
            flag = false;
        }
        if (!flag) {
            System.out.println("Entering data is empty");
            return null;
        }
        return pjp.proceed();
    }


}
