package com.querywithapi.querywithapiexercice.dto;

public class CategoryFilterDto {


  private String categoryA;
  private String categoryB;
  
  public CategoryFilterDto(String categoryA, String categoryB) {
    this.categoryA = categoryA;
    this.categoryB = categoryB;
  }
  public CategoryFilterDto() {
  }
  public String getCategoryA() {
    return categoryA;
  }
  public void setCategoryA(String categoryA) {
    this.categoryA = categoryA;
  }
  public String getCategoryB() {
    return categoryB;
  }
  public void setCategoryB(String categoryB) {
    this.categoryB = categoryB;
  }

  


}
