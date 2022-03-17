package customermanagement.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* customermanagement.controller.CustomerController.showCreateForm(..))")
    public void allMethodPointCut() {
    }
    @Before("allMethodPointCut()")
    public void beforeAction(JoinPoint joinPoint){
        System.err.println("Tịnh chưa đến" +joinPoint.getSignature().getName() +" Time: "+ LocalDate.now());
    }
    @AfterReturning("allMethodPointCut()")
    public void afterReturning(JoinPoint joinPoint){
        System.err.println("Tịnh đã đến đây đã đấy xong"+joinPoint.getSignature().getName() +" Time: "+ LocalDate.now());
    }

}
