package com.ryeisaig.tech.annotation;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("@annotation(LogStartEnd)")
    public void logMethodCallBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = methodSignature.getParameterNames();
        List<String> transformedArgs = transformArgs(paramNames, args);
        log.info("Started calling {} with args: {}", methodName, transformedArgs);
    }

    @AfterReturning(value="@annotation(LogStartEnd)", returning="result")
    public void logMethodCallAfter(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] paramNames = methodSignature.getParameterNames();
        List<String> transformedArgs = transformArgs(paramNames, args);
        log.info("Finished calling {} with args: {} and result: {}", methodName, transformedArgs, result);
    }
    
    private List<String> transformArgs(String[] params, Object[] args) {
    	 List<String> transformedArgs = new ArrayList<>();
         int i = 0; 
         for(String param : params) {
         	transformedArgs.add(new StringBuilder().append(param).append("=").append(args[i]).toString());
         	i++;
         }         
         return transformedArgs;
    }
}
