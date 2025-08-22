package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.validations.ExistsByEmail;


import jakarta.persistence.Transient;

public class UserAccountDtoInsert {

    private String userName;

  @ExistsByEmail
  private String email;

   
  private String password;

   @Transient
  private boolean admin;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate registeredAt;

 

  public UserAccountDtoInsert(String userName, String email, String password, boolean admin, LocalDate registeredAt) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.admin = admin;
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

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  

  

}
