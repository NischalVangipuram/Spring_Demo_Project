package com.example.OlympicsDemo.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Expressions {
    @Pointcut("execution(* com.example.OlympicsDemo.service.*.find*(..))")
    public void find()
    {

    }
    @Pointcut("execution(* com.example.OlympicsDemo.service.*.save*(..))")
    public void save()
    {

    }
    @Pointcut("execution(* com.example.OlympicsDemo.service.*.delete*(..))")
    public void delete()
    {

    }
}
