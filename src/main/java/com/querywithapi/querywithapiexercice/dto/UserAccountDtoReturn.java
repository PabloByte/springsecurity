package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.model.Loan;



public class UserAccountDtoReturn {

    private Long id;

  private String userName;

  private String email;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate registeredAt;

  private List<Loan> loan;

  public UserAccountDtoReturn(Long id, String userName, String email, LocalDate registeredAt, List<Loan> loan) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.registeredAt = registeredAt;
    this.loan = loan;
  }

  public UserAccountDtoReturn() {
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
