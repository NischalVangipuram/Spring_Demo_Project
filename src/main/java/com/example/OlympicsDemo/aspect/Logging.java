package com.example.OlympicsDemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class Logging {
    private  static Logger logger=Logger.getLogger(Logging.class.getName());
//slf4j logger
    @Before("com.example.OlympicsDemo.aspect.Expressions.find()")
    public void beforeFinding()
    {
        logger.info("\n====> Finding from the service layer ");
    }
    @After("com.example.OlympicsDemo.aspect.Expressions.find()")
    public void afterFinding()
    {
        logger.info("\n====> Found from the service layer ");
    }
    @Before("com.example.OlympicsDemo.aspect.Expressions.save()")
    public void beforeSaving()
    {
        logger.info("\n====> Saving to the database  ");
    }
    @Before("com.example.OlympicsDemo.aspect.Expressions.delete()")
    public void beforeDelete()
    {
        logger.info("\n====> Deleting from the database  ");
    }
}
