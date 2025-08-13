package com.querywithapi.querywithapiexercice.dto;

public class findByTitleIgnoreCase {

  private String nameOfBookToFind;

  public findByTitleIgnoreCase(String nameOfBookToFind) {
    this.nameOfBookToFind = nameOfBookToFind;
  }

  public findByTitleIgnoreCase() {
  }

  public String getNameOfBookToFind() {
    return nameOfBookToFind;
  }

  public void setNameOfBookToFind(String nameOfBookToFind) {
    this.nameOfBookToFind = nameOfBookToFind;
  }

  

}
