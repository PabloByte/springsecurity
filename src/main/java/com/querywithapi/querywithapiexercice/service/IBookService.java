package com.querywithapi.querywithapiexercice.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.querywithapi.querywithapiexercice.dto.AuthorDtoInsert;
import com.querywithapi.querywithapiexercice.dto.BookDtoInsert;
import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.dto.bookTitleAndLength;
import com.querywithapi.querywithapiexercice.model.Book;

public interface IBookService {


  public BookDtoReturn saveBook (BookDtoInsert book);

  public List<BookDtoReturn> getAllBooks ();

  public BookDtoReturn getBookById (Long id);
  public void deleteBookById (Long id);

  public List<BookDtoReturn> filterByCategory(String A, String B); 
  public List<BookDtoReturn> findByTitleIgnoreCase(String name); 
  public List<BookDtoReturn> findByPriceGreaterThanEqual(Double price); 
  List<String> findDistinctByCategory ();
  List<BookDtoReturn> getBooksByCategory (List<String> CategoryList);

   List<bookTitleAndLength> getBookTitleLength (Integer titleLong); 

   public Double priceMin ();

  public  Double priceMax ();

   public Double priveAvg ();

   List<BookDtoReturn> booksWithPricehigherInTheAvg ();















}
