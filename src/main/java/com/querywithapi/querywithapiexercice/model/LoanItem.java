package com.querywithapi.querywithapiexercice.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LoanItem {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private Long bookId;

  private String bookName;
  

  @ManyToOne
  @JoinColumn(name="loan_id", nullable=false)
  private Loan loan;

  

  public LoanItem(Long id, Long bookId, String bookName, Loan loan) {
    this.id = id;
    this.bookId = bookId;
    this.bookName = bookName;
    this.loan = loan;
  }

  public LoanItem() {
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

  public Loan getLoan() {
    return loan;
  }

  public void setLoan(Loan loan) {
    this.loan = loan;
  }

  









}
