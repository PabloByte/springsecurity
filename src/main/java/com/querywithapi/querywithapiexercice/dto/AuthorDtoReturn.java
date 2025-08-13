package com.querywithapi.querywithapiexercice.dto;

import java.util.List;

import com.querywithapi.querywithapiexercice.model.Book;

public class AuthorDtoReturn {


private Long id;
 private String firstName ;
  private String lastName  ;

  private  List<Book> authorList;

  public AuthorDtoReturn(Long id, String firstName, String lastName, List<Book> authorList) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.authorList = authorList;
  }

  public AuthorDtoReturn() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public List<Book> getAuthorList() {
    return authorList;
  }

  public void setAuthorList(List<Book> authorList) {
    this.authorList = authorList;
  }

  








}
