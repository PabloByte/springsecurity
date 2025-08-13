package com.querywithapi.querywithapiexercice.dto;

public class bookTitleAndLength {

  private int titleLength;
  private String title;

    public bookTitleAndLength(String title, int titleLength) {
        this.title = title;
        this.titleLength = titleLength;
    }

    public bookTitleAndLength() {
    }

    public int getTitleLength() {
      return titleLength;
    }

    public void setTitleLength(int titleLength) {
      this.titleLength = titleLength;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }



}
