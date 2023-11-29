package bank.service.aop;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    @Autowired
    private Logger logger;
    @After("execution(* bank.integration.jms.*.*(..))")
    public void logJMS(JoinPoint joinPoint) {
        System.out.println("JMS message sent");
        logger.log("JMS message sent" + joinPoint.getSignature().getName());
    }
}
