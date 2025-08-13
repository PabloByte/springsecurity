package com.querywithapi.querywithapiexercice.dto;

public class AuthorDtoInstance {



  private String completeName;
  private Integer totalBooks;
  private Double booksAvgPrice ;
  public AuthorDtoInstance(String completeName, Integer totalBooks, Double booksAvgPrice) {
    this.completeName = completeName;
    this.totalBooks = totalBooks;
    this.booksAvgPrice = booksAvgPrice;
  }
  public AuthorDtoInstance() {
  }
  public String getCompleteName() {
    return completeName;
  }
  public void setCompleteName(String completeName) {
    this.completeName = completeName;
  }
  public Integer getTotalBooks() {
    return totalBooks;
  }
  public void setTotalBooks(Integer totalBooks) {
    this.totalBooks = totalBooks;
  }
  public Double getBooksAvgPrice() {
    return booksAvgPrice;
  }
  public void setBooksAvgPrice(Double booksAvgPrice) {
    this.booksAvgPrice = booksAvgPrice;
  }

  






}
