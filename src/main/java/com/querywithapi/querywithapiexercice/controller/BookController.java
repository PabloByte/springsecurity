package com.querywithapi.querywithapiexercice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querywithapi.querywithapiexercice.dto.BookDtoInsert;
import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.dto.CategoryFilterDto;
import com.querywithapi.querywithapiexercice.dto.ListOfCategorys;
import com.querywithapi.querywithapiexercice.dto.bookTitleAndLength;
import com.querywithapi.querywithapiexercice.dto.findByTitleIgnoreCase;
import com.querywithapi.querywithapiexercice.service.BookServiceImpl;

@RequestMapping("/bookApi")
@RestController
public class BookController {
  
  private final BookServiceImpl bookServiceImpl;

  public BookController(BookServiceImpl bookServiceImpl) {
    this.bookServiceImpl = bookServiceImpl;
  }

  @PostMapping("/create")
  public ResponseEntity<?> createBook (@RequestBody BookDtoInsert book){

    BookDtoReturn book1 = bookServiceImpl.saveBook(book);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(book1);

  }

  @GetMapping("/getAllBooks")
  public ResponseEntity<?> getAllBooks (){

    List<BookDtoReturn> bookList = bookServiceImpl.getAllBooks();

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookList);

  }

  @GetMapping("/getBookById/{id}")
  public ResponseEntity<?> getBookById (@PathVariable Long id){

    BookDtoReturn book = bookServiceImpl.getBookById(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
  }


  @DeleteMapping("/deleteBookById/{id}")
  public ResponseEntity<?> deleteById (@PathVariable Long id){

    bookServiceImpl.deleteBookById(id);
    return ResponseEntity.status(HttpStatus.FOUND).body("DELETE SUCESSFULLY");

  }


  @GetMapping("/filterByCategory")
  public ResponseEntity<?> filterByCategory(@RequestBody CategoryFilterDto category){

    List<BookDtoReturn> books = bookServiceImpl.filterByCategory(category.getCategoryA(), category.getCategoryB());

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(books);
  }


  @GetMapping("/findByTitleIgnoreCase")
  public ResponseEntity<?> findByTitleIgnoreCase (@RequestBody findByTitleIgnoreCase book){

    List<BookDtoReturn> list = bookServiceImpl.findByTitleIgnoreCase(book.getNameOfBookToFind());

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);

  }

  @GetMapping("/findByPriceGreaterThanEqual/{price}")
  public ResponseEntity<?> findByPriceGreaterThanEqual (@PathVariable Double price ){

    List<BookDtoReturn> list = bookServiceImpl.findByPriceGreaterThanEqual(price);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }

  @GetMapping("/findDistinctByCategory")
  public ResponseEntity<?> findDistinctByCategory ( ){

    List<String> list = bookServiceImpl.findDistinctByCategory();

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }

   @GetMapping("/getBooksByCategory")
  public ResponseEntity<?> getBooksByCategory (@RequestBody ListOfCategorys listOfCategorys ){

    List<BookDtoReturn> list = bookServiceImpl.getBooksByCategory(listOfCategorys.getCategorys());

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }



  @GetMapping("/getBookTitleLength/{titleLong}")
  public ResponseEntity<?> getBookTitleLength (@PathVariable Integer titleLong){

    List<bookTitleAndLength> list = bookServiceImpl.getBookTitleLength(titleLong);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
 }


 @GetMapping("/priceMin")
 public ResponseEntity<?> priceMin (){

  Double min = bookServiceImpl.priceMin();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(min);
 }

  @GetMapping("/priceMax")
 public ResponseEntity<?> priceMax (){

  Double max = bookServiceImpl.priceMax();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(max);
 }

  @GetMapping("/priceAvg")
 public ResponseEntity<?> priceAvg (){

  Double avg = bookServiceImpl.priveAvg();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(avg);
 }

 @GetMapping("/booksWithPricehigherInTheAvg")
 public ResponseEntity<?> booksWithPricehigherInTheAvg (){
  List<BookDtoReturn> list = bookServiceImpl.booksWithPricehigherInTheAvg();

  return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);

 }

 





























}
