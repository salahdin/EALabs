package bank.service.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class StopWatchAdvice {
    @Autowired
    private Logger logger;
    @Around("execution(* bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object retVal = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution time of " + joinPoint.getSignature().getName() + "operation is " + (end - start) + "ms");
        logger.log("Execution time of " + joinPoint.getSignature().getName() + "operation is " + (end - start) + "ms");
        return retVal;
    }
}
