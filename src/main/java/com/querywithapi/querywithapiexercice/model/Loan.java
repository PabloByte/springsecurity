package com.querywithapi.querywithapiexercice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Loan {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate loanDate;
  
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate returnDate ;
  
  @Enumerated(EnumType.STRING)
  private LoanStatus status;

  @ManyToOne
  @JoinColumn(name= "UserAccount_id", nullable= false)
  private UserAccount userAccount;


  @OneToMany(mappedBy="loan", cascade= CascadeType.ALL)
  private List<LoanItem> loanItems=new ArrayList<>();


  public Loan(Long id, LocalDate loanDate, LocalDate returnDate, LoanStatus status, UserAccount userAccount,
      List<LoanItem> loanItems) {
    this.id = id;
    this.loanDate = loanDate;
    this.returnDate = returnDate;
    this.status = status;
    this.userAccount = userAccount;
    this.loanItems = loanItems;
  }


  public Loan() {
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


  public LoanStatus getStatus() {
    return status;
  }


  public void setStatus(LoanStatus status) {
    this.status = status;
  }


  public UserAccount getUserAccount() {
    return userAccount;
  }


  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }


  public List<LoanItem> getLoanItems() {
    return loanItems;
  }


  public void setLoanItems(List<LoanItem> loanItems) {
    this.loanItems = loanItems;
  }

  


  








}
