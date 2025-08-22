package com.querywithapi.querywithapiexercice.handlerexception;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

  private static final  Logger logger  = LoggerFactory.getLogger(GlobalHandlerException.class); 


  @ExceptionHandler(LoanIdNotFoundException.class)
  public ResponseEntity<?> LoanIdNotFoundException (LoanIdNotFoundException ex){

    logger.warn("Consulta a un id de prestamo inexistente : {}",ex.getMessage());
    return buildResponse(HttpStatus.BAD_REQUEST, "Not Loan Found With the ID provided", ex.getMessage() );


  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> unexpectectErrorException (Exception ex){

return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error,  unexpectect request", ex.getMessage());

  }

  @ExceptionHandler(InvalidLoanItemIdException.class)
  public ResponseEntity<?> InvalidLoanItemIdException (InvalidLoanItemIdException ex){

    logger.error("Tratando de agregar un item inexistente al prestamo :{}",ex.getMessage());
    return buildResponse(HttpStatus.BAD_REQUEST, "Invalid id, not book found with the id privided", ex.getMessage());

  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> handleRuntime (RuntimeException ex){ 

    return buildResponse(HttpStatus.BAD_REQUEST, "Error en la solicitud enviada", ex.getMessage());


  }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }
















public ResponseEntity<?> buildResponse (HttpStatus status, String error , String message ){

  return ResponseEntity.status(status).body(Map.of(

    "error",error,
    "message",message,
    "timestamp",LocalTime.now()

  ));
}




}
