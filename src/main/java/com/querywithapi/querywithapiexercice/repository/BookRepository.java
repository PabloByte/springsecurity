package com.querywithapi.querywithapiexercice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


  @Query("SELECT b FROM Book b WHERE b.category BETWEEN 'A' and 'B'")
  List<Book> findByCategoryBetween(String A, String B);

  List<Book> findByTitleContainingIgnoreCase(String name );
  List<Book> findByPriceGreaterThanEqual(Double price );

  @Query("SELECT DISTINCT(b.category) FROM Book b")
  List<String> findDistinctByCategoryList ();

  @Query("SELECT b FROM Book b WHERE b.category in ?1")
  List<Book> getBooksByCategory (List<String> CategoryList);


  @Query("SELECT b.title, length(b.title) FROM Book b WHERE length(b.title) >= ?1")
  List<Object[]> getBookTitleLength (Integer  titleLong ); 

   @Query("SELECT MIN(b.price) FROM Book b")
   Double priceMin ();

   @Query("SELECT MAX(b.price) FROM Book b")
   Double priceMax ();


   @Query("SELECT AVG(b.price) FROM Book b")
   Double priveAvg ();


   @Query("SELECT b.id, b.isbn, b.price, b.title, b.publishedDate, b.category, b.author.firstName FROM Book b WHERE b.price > (SELECT AVG(b2.price) FROM Book b2 WHERE b2.category = b.category)")
   List<Object[]> booksWithPricehigherInTheAvg ();



  

















  

}
