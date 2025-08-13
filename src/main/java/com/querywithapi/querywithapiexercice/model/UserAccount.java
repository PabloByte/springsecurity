package com.querywithapi.querywithapiexercice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UserAccount {


  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String userName;

  private String email;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate registeredAt;

  @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
  private List<Loan> loan= new ArrayList<>();

  public UserAccount(Long id, String userName, String email, LocalDate registeredAt, List<Loan> loan) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.registeredAt = registeredAt;
    this.loan = loan;
  }

  public UserAccount() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getRegisteredAt() {
    return registeredAt;
  }

  public void setRegisteredAt(LocalDate registeredAt) {
    this.registeredAt = registeredAt;
  }

  public List<Loan> getLoan() {
    return loan;
  }

  public void setLoan(List<Loan> loan) {
    this.loan = loan;
  }




  

  


 
  

















}
