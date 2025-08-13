package com.querywithapi.querywithapiexercice.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfCategorys {


  List<String> categorys = new ArrayList<>();

  public ListOfCategorys(List<String> categorys) {
    this.categorys = categorys;
  }

  public ListOfCategorys() {
  }

  public List<String> getCategorys() {
    return categorys;
  }

  public void setCategorys(List<String> categorys) {
    this.categorys = categorys;
  }

  






}
