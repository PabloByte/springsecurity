package com.querywithapi.querywithapiexercice.dto;

import com.querywithapi.querywithapiexercice.model.Loan;



public class LoanItemDtoReturn {

  private Long id;
  private Long bookId;
    private String bookName; 
  private Long loanId;


  public LoanItemDtoReturn(Long id, Long bookId, String bookName, Long loanId) {
    this.id = id;
    this.bookId = bookId;
    this.bookName = bookName;
    this.loanId = loanId;
  }


  public LoanItemDtoReturn() {
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Long getBookId() {
    return bookId;
  }


  public void setBookId(Long bookId) {
    this.bookId = bookId;
  }


  public String getBookName() {
    return bookName;
  }


  public void setBookName(String bookName) {
    this.bookName = bookName;
  }


  public Long getLoanId() {
    return loanId;
  }


  public void setLoanId(Long loanId) {
    this.loanId = loanId;
  }




  














}
