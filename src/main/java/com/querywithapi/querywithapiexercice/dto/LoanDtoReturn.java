package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.model.LoanItem;
import com.querywithapi.querywithapiexercice.model.LoanStatus;
import com.querywithapi.querywithapiexercice.model.UserAccount;


public class LoanDtoReturn {

  private Long id;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate loanDate;
  
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate returnDate ;
  
  
  private String status;
  private Long userAccount;

  private List<LoanItemDtoReturn> booksOnLoan=new ArrayList<>();



  public LoanDtoReturn(Long id, LocalDate loanDate, LocalDate returnDate, String status, Long userAccount,
      List<LoanItemDtoReturn> booksOnLoan) {
    this.id = id;
    this.loanDate = loanDate;
    this.returnDate = returnDate;
    this.status = status;
    this.userAccount = userAccount;
    this.booksOnLoan = booksOnLoan;
  }

  public LoanDtoReturn() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(LocalDate loanDate) {
    this.loanDate = loanDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(Long userAccount) {
    this.userAccount = userAccount;
  }

  public List<LoanItemDtoReturn> getBooksOnLoan() {
    return booksOnLoan;
  }

  public void setBooksOnLoan(List<LoanItemDtoReturn> booksOnLoan) {
    this.booksOnLoan = booksOnLoan;
  }



  







}
