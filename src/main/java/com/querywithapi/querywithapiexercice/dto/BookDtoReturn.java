package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.model.Author;

public class BookDtoReturn {

    private Long id;

  private String title;
  private String isbn;

  private Double price;
  
  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate publishedDate;
  
  private String category;

  private String nameAuthor;

  public BookDtoReturn(Long id, String title, String isbn, Double price, LocalDate publishedDate, String category,
      String nameAuthor) {
    this.id = id;
    this.title = title;
    this.isbn = isbn;
    this.price = price;
    this.publishedDate = publishedDate;
    this.category = category;
    this.nameAuthor = nameAuthor;
  }

  public BookDtoReturn() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public LocalDate getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDate publishedDate) {
    this.publishedDate = publishedDate;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getNameAuthor() {
    return nameAuthor;
  }

  public void setNameAuthor(String nameAuthor) {
    this.nameAuthor = nameAuthor;
  }

  

 















}
