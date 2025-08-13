package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthorDtoInsert {


 private String firstName ;
  private String lastName  ;

   @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate birthDate;
  
   public AuthorDtoInsert(String firstName, String lastName, LocalDate birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }


   public AuthorDtoInsert() {
   }


   public String getFirstName() {
     return firstName;
   }


   public void setFirstName(String firstName) {
     this.firstName = firstName;
   }


   public String getLastName() {
     return lastName;
   }


   public void setLastName(String lastName) {
     this.lastName = lastName;
   }


   public LocalDate getBirthDate() {
     return birthDate;
   }


   public void setBirthDate(LocalDate birthDate) {
     this.birthDate = birthDate;
   }

   

  










}
