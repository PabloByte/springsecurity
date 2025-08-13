package com.querywithapi.querywithapiexercice.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.querywithapi.querywithapiexercice.model.Author;

public class BookDtoInsert {

  private String title;
  private String isbn;

  private Double price;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
  private LocalDate publishedDate;

   private String category;

   private Long authorId;

   public BookDtoInsert(String title, String isbn, Double price, LocalDate publishedDate, String category,
      Long authorId) {
    this.title = title;
    this.isbn = isbn;
    this.price = price;
    this.publishedDate = publishedDate;
    this.category = category;
    this.authorId = authorId;
   }

   public BookDtoInsert() {
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

   public Long getAuthorId() {
     return authorId;
   }

   public void setAuthorId(Long authorId) {
     this.authorId = authorId;
   }

   




















}
