package tn.esprit.tp_foyer_ahmed_brahem.configuration;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* tn.esprit.tp_foyer_ahmed_brahem.services.implementation.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }
    @After("execution(* tn.esprit.tp_foyer_ahmed_brahem.services.implementation.*.*(..))")
    public void logMethodAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method with: " + name + " : ");
    }
    @AfterReturning("execution(* tn.esprit.tp_foyer_ahmed_brahem.services.implementation.*.*(..))")
    public void logMethodAfterReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method with Values: " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.tp_foyer_ahmed_brahem.services.implementation.*.*(..))")
    public void logMethodAfterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method with Error: " + name + " : ");
    }

}
