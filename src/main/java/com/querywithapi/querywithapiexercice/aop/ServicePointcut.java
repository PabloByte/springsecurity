package com.querywithapi.querywithapiexercice.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServicePointcut {

  @Pointcut("execution(* com.querywithapi.querywithapiexercice.service.BookServiceImpl.saveBook(..))")
  public void bookInformationPointCut(){}

  @Pointcut("execution(* com.querywithapi.querywithapiexercice.service.LoanServiceImpl.getLoansByUserId(..))")
  public void totalLoansByUserId(){}

  @Pointcut("execution(* com.querywithapi.querywithapiexercice.service.LoanServiceImpl.createLoan(..))")
  public void createLoanPoa (){}

  @Pointcut("execution(* com.querywithapi.querywithapiexercice.service..*(..))")
  public void executionTimeMethod (){}




}
