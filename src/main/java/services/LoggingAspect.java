package services;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around(value = "@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("Logging Aspect: Calling the intercepted method.");

        /*
         The proceed method here delegates further in the aspect execution chain.
         It can either call the next aspect or the intercepted method
         */
        Object returnedValue = joinPoint.proceed();

        logger.info("Logging Aspect: Method executed and returned " + returnedValue);

        return returnedValue;
    }

}
