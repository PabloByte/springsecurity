package com.querywithapi.querywithapiexercice.aop;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.querywithapi.querywithapiexercice.dto.BookDtoInsert;
import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanInsertDto;



@Aspect
@Component
public class AuditoryAspect {

private static final Logger logger = LoggerFactory.getLogger(AuditoryAspect.class);




@Before("ServicePointcut.bookInformationPointCut()")
public void bookInformationAspect (JoinPoint joinPoint){

  logger.trace("✅ Aspecto ejecutado antes de método: {}, numero de objetos de entrada :{} ", joinPoint.getSignature().getName(), joinPoint.getArgs().length);

  Object[] args = joinPoint.getArgs();

  if(args.length > 0 && args[0] instanceof BookDtoInsert book) {

    String title = book.getTitle();
    Long author =  book.getAuthorId();

    logger.trace("titulo del libro : {} , ID autor del libro : {}", title, author);

  }

}


@AfterReturning(pointcut="ServicePointcut.totalLoansByUserId()", returning="result")
public void LoanInformationAspect (JoinPoint joinPoint, List<LoanDtoReturn> result){

   logger.trace("✅ Metodo usado: {} , validando prestamos del id: {}", joinPoint.getSignature().getName(), joinPoint.getArgs());


   if(!result.isEmpty()){

    for (LoanDtoReturn loan1 : result) {

      logger.trace("Id del prestamo asociado al id de usuario  :{}, total de libros incluidos en el prestamo asociados: {} ", loan1.getId(), loan1.getBooksOnLoan().size());
      
    }

   }

    
     

}

@AfterThrowing(pointcut="ServicePointcut.createLoanPoa()", throwing="ex")
public void createLoamItemErrorAspect (JoinPoint joinPoint, Throwable ex){

  Object[] args = joinPoint.getArgs();

  if(args.length > 0 && args[0] instanceof LoanInsertDto loan){

    List <Long> idsList = loan.getBooksIdOnLoan();
    Long userId = loan.getUserAccountId();

    logger.error("ERROR PRESENTADO EN LA CREACION DEL LOAN ITEM CON EL ID : {}, ERROR TRATANDO DE CREAR PRESTAMO PARA LA CUENTA CON ID :{}, causa :{}", idsList,userId, ex.getMessage());

  }
}

@Order(1)
@Around("ServicePointcut.executionTimeMethod()")
public Object executionInformation (ProceedingJoinPoint joinPoint ){


  Long initialTime = System.currentTimeMillis();
  String methodName = joinPoint.getSignature().getName();
  Integer argsInTheMethod = joinPoint.getArgs().length;
  Object result;

  try {

    result= joinPoint.proceed();

    Long finalTime = System.currentTimeMillis();

    Long totalTime = finalTime-initialTime;

    logger.info("nombre del metodo : {}, tiempo de ejecucion en milisegundos :{},numero de argumentos recibidos :{}", methodName,totalTime,argsInTheMethod);

    return result;

  } catch (Throwable e) {

      throw new RuntimeException("Error general presentado");

  }


}

@Order(2)
@AfterReturning(pointcut="ServicePointcut.createLoanPoa()", returning="result")
public void LoanInformationAspect (JoinPoint joinPoint , LoanDtoReturn result ){

  Object[] args = joinPoint.getArgs();


  if(args.length > 0 && args[0] instanceof LoanInsertDto loan ){

    Long userId = loan.getUserAccountId();
    List<Long> booksIds = loan.getBooksIdOnLoan();
    LocalDate  loanDate = loan.getLoanDate();
    Integer totalBooks = booksIds.size();
  LocalDate dateOfTheRequest = LocalDate.now();


  logger.info("ID Usuario que desea hacer el prestamo : {}, ids de los items a adquirir : {}, fecha del prestamo : {}, numero total de items a prestar :{}, fecha del requerimiento: {}", userId, booksIds,loanDate,totalBooks,dateOfTheRequest);

  }

}











}
