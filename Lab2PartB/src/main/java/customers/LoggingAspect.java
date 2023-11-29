package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    @After("execution(* customers.EmailSenderImpl.sendEmail(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(LocalDateTime.now() + " method = " + joinPoint.getSignature().getName());
        System.out.println("address = " + joinPoint.getArgs()[0] + " message = " + joinPoint.getArgs()[1]);
        EmailSenderImpl emailSender = (EmailSenderImpl)joinPoint.getTarget();
        if(emailSender != null){
            System.out.println("mail server = "+ emailSender.getOutgoingMailServer());
        }
    }

    @Around("execution(* customers.CustomerRepository.save(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(joinPoint.getSignature().getName());
        Object retVal = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("Execution time of " + joinPoint.getSignature().getName() + "operation is " + stopWatch.getTotalTimeMillis() + "ms");
        return retVal;
    }
}
