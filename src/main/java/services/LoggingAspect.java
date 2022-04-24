package services;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    /*
       - The AspectJ pointcut expression specifies which methods this aspect logic weaves to.
       - Optionally, when you use @AfterReturning, you can get the value returned by the intercepted method.
       In this case, we add the “returning” attribute with a value that corresponds to the name of
       the method’s parameter where this value will be provided.
     */
    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    /*
       The parameter name should be the same as the value of the “returning” attribute of the annotation
       or missing if we don’t need to use the returned value
     */
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);
    }

}
