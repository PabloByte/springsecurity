package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserAccountDtoInsert {

    private String userName;

  private String email;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate registeredAt;

  public UserAccountDtoInsert(String userName, String email, LocalDate registeredAt) {
    this.userName = userName;
    this.email = email;
    this.registeredAt = registeredAt;
  }

  public UserAccountDtoInsert() {
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

  

}
