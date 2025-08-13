package com.querywithapi.querywithapiexercice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Service;

import com.querywithapi.querywithapiexercice.dto.BookDtoInsert;
import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.dto.bookTitleAndLength;
import com.querywithapi.querywithapiexercice.mapper.OrderMapper;
import com.querywithapi.querywithapiexercice.model.Author;
import com.querywithapi.querywithapiexercice.model.Book;
import com.querywithapi.querywithapiexercice.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {

  private final AuthorServiceImpl authorServiceImpl;
  private final BookRepository bookRepository;
  private final OrderMapper convert;

  public BookServiceImpl(AuthorServiceImpl authorServiceImpl, BookRepository bookRepository, OrderMapper convert) {
    this.authorServiceImpl = authorServiceImpl;
    this.bookRepository = bookRepository;
    this.convert = convert;
  }


  @Override
  public BookDtoReturn saveBook(BookDtoInsert book) {

    Book newBook = new Book();

   Author autor = authorServiceImpl.validateAuthor(book.getAuthorId());

   newBook.setTitle(book.getTitle());
   newBook.setIsbn(book.getIsbn());
  newBook.setPrice(book.getPrice());
  newBook.setPublishedDate(book.getPublishedDate());
  newBook.setCategory(book.getCategory());
  newBook.setAuthor(autor);

  bookRepository.save(newBook);
    
    return convert.bookToBookDtoReturn(newBook);
  }


  @Override
  public List<BookDtoReturn> getAllBooks() {

    List<Book> bookList = bookRepository.findAll();

    return convert.bookListToBookDtoReturnList(bookList);

  }


  @Override
  public BookDtoReturn getBookById(Long id) {

    Book bookFound = bookRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("NO SE ENCONTRO EL LIBRO CON EL ID INDICADO"));

    return convert.bookToBookDtoReturn(bookFound);
  }


  @Override
  public void deleteBookById(Long id) {
    bookRepository.deleteById(id);
  }


  @Override
  public List<BookDtoReturn> filterByCategory(String A, String B) {
    List<Book> books = bookRepository.findByCategoryBetween(A, B);
    return convert.bookListToBookDtoReturnList(books);
  }


  @Override
  public List<BookDtoReturn> findByTitleIgnoreCase(String name) {

    List<Book> list = bookRepository.findByTitleContainingIgnoreCase(name);
    return convert.bookListToBookDtoReturnList(list);

  }


  @Override
  public List<BookDtoReturn> findByPriceGreaterThanEqual(Double price) {

    List<Book> list = bookRepository.findByPriceGreaterThanEqual(price);
   
    return convert.bookListToBookDtoReturnList(list);

  }


  @Override
  public List<String> findDistinctByCategory() {

  return bookRepository.findDistinctByCategoryList();

    

  }


  @Override
  public List<BookDtoReturn> getBooksByCategory(List<String> CategoryList) {

    List<Book> list = bookRepository.getBooksByCategory(CategoryList);
    return convert.bookListToBookDtoReturnList(list);

  }


  @Override
  public List<bookTitleAndLength> getBookTitleLength(Integer titleLong) {

    List<Object[]> listTitleLength = bookRepository.getBookTitleLength(titleLong);

    List<bookTitleAndLength> list = new ArrayList<>();

    for (Object[] arr : listTitleLength) {

      bookTitleAndLength book = new bookTitleAndLength();

      book.setTitle((String) arr[0]);
      book.setTitleLength((Integer) arr[1]);

      list.add(book);
    }

    return list;

  }


  @Override
  public Double priceMin() {

  return bookRepository.priceMin();
  }


  @Override
  public Double priceMax() {
    return bookRepository.priceMax();
  }


  @Override
  public Double priveAvg() {

    return bookRepository.priveAvg();
  
  }


  @Override
  public List<BookDtoReturn> booksWithPricehigherInTheAvg() {

    List<Object[]> ArrayList =  bookRepository.booksWithPricehigherInTheAvg();
    
    List<BookDtoReturn> listReturn = new ArrayList<>();

    for (Object[] arr : ArrayList) {

      BookDtoReturn bookDtoReturn = new BookDtoReturn();

      bookDtoReturn.setId((Long) arr[0]);
      bookDtoReturn.setIsbn((String) arr[1]);
      bookDtoReturn.setPrice((Double) arr[2]);
      bookDtoReturn.setTitle((String) arr[3]);
      bookDtoReturn.setPublishedDate((LocalDate)arr[4]);
      bookDtoReturn.setCategory((String) arr[5]);
      bookDtoReturn.setNameAuthor((String) arr[6]);

      listReturn.add(bookDtoReturn);
      
    }

    return listReturn;

  }




  



  















  

}
