package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.model.LoanStatus;



public class LoanInsertDto {
 
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate loanDate;

  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate returnDate ;
  
  private LoanStatus status;
  private Long userAccountId;

  List<Long> booksIdOnLoan=new ArrayList<>();

  public LoanInsertDto(LocalDate loanDate, LocalDate returnDate, LoanStatus status, Long userAccountId,
      List<Long> booksIdOnLoan) {
    this.loanDate = loanDate;
    this.returnDate = returnDate;
    this.status = status;
    this.userAccountId = userAccountId;
    this.booksIdOnLoan = booksIdOnLoan;
  }

  public LoanInsertDto() {
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

  public LoanStatus getStatus() {
    return status;
  }

  public void setStatus(LoanStatus status) {
    this.status = status;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }

  public List<Long> getBooksIdOnLoan() {
    return booksIdOnLoan;
  }

  public void setBooksIdOnLoan(List<Long> booksIdOnLoan) {
    this.booksIdOnLoan = booksIdOnLoan;
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoanInsertDto :");
        sb.append("loanDate=").append(loanDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", status=").append(status);
        sb.append(", userAccountId=").append(userAccountId);
        sb.append(", booksIdOnLoan=").append(booksIdOnLoan);
        return sb.toString();
    }

  



}
