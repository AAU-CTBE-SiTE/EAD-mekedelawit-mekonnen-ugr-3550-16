package com.site.actor_managment.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationAspect {

    @Pointcut("@annotation(com.site.actor_managment.annotation.TrackExecution)")
    public void annotatedMethodPointcut() {}

    @Around("annotatedMethodPointcut()")
    public Object trackCustomAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP] >>> Entering annotated method: " + methodName);

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;

        System.out.println("[AOP] <<< Exiting " + methodName + " | Execution Time: " + duration + "ms");
        return result;
    }
}
