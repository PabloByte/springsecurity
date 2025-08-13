package com.querywithapi.querywithapiexercice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanInsertDto;
import com.querywithapi.querywithapiexercice.service.LoanServiceImpl;

import jakarta.servlet.http.HttpServletRequest;



@RequestMapping("/apiLoan")
@RestController
public class LoanController {

  private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

  private final LoanServiceImpl loanServiceImpl;

  public LoanController(LoanServiceImpl loanServiceImpl) {
    this.loanServiceImpl = loanServiceImpl;
    
  }


  @PostMapping("/createLoan")
  public ResponseEntity<?> createLoan (@RequestBody LoanInsertDto loan, HttpServletRequest request){

    logger.trace("Metodo usado{}, informacion entrante{}",request.getMethod(), loan);
   
    LoanDtoReturn newLoan = loanServiceImpl.createLoan(loan);

     logger.info("Prestamo creado exitosamente. fecha creacion : {} Cuenta asociada : {}",loan.getLoanDate(), loan.getUserAccountId());

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(newLoan);

    
  }


  @GetMapping("/getLoanById/{id}")
  public ResponseEntity<?> getLoanById (@PathVariable Long id ){

    LoanDtoReturn loan = loanServiceImpl.GetLoanById(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(loan);

  }

   @GetMapping("/getAllLoans")
  public ResponseEntity<?> getAllLoans (  ){

    

   List <LoanDtoReturn> list = loanServiceImpl.getAllLoans();

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);

  }

  @DeleteMapping("/deleteById/{id}")
  public ResponseEntity<?> deleteById (@PathVariable Long id, HttpServletRequest request){

    logger.trace("Metodo usado{}, informacion ingresada{}", request.getMethod(), id);

    loanServiceImpl.deleteLoanByid(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETE SUCESSFULLY ID "+ id);

  } 


  @GetMapping("/usersWithMoreThanXLoans/{numberLoans}")
  public ResponseEntity<?>  usersWithMoreThanXLoans (@PathVariable Integer numberLoans){
    List<LoanDtoReturn> list = loanServiceImpl.usersWithMoreThanXLoans(numberLoans);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }


  @GetMapping("/findLoansByUserAccountId/{userId}")
  public ResponseEntity<?> findLoansByUserAccountId (@PathVariable Long userId){

    List<LoanDtoReturn> list = loanServiceImpl.getLoansByUserId(userId);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);

  }

  

  

















}
