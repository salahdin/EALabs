package bank.service.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class DAOLogAdvice {
    @Autowired
    private Logger logger;
    @After("execution(* bank.repository.AccountRepository.*(..))")
    public void LogDAOCall(JoinPoint joinPoint) {
        System.out.println(LocalDateTime.now() + " method = " + joinPoint.getSignature().getName());
        logger.log("method = " + joinPoint.getSignature().getName());
    }
}
