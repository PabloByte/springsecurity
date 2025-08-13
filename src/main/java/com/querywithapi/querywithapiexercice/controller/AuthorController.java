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

import com.querywithapi.querywithapiexercice.dto.AuthorDtoInsert;
import com.querywithapi.querywithapiexercice.dto.AuthorDtoReturn;
import com.querywithapi.querywithapiexercice.service.AuthorServiceImpl;

@RestController
@RequestMapping("/authorApi")
public class AuthorController {

  private final AuthorServiceImpl authorServiceImpl;

  public AuthorController(AuthorServiceImpl authorServiceImpl) {
    this.authorServiceImpl = authorServiceImpl;
  }


  @PostMapping("/createAuthor")
  public ResponseEntity<?>  createAuthor (@RequestBody AuthorDtoInsert author1 ){

    AuthorDtoReturn author = authorServiceImpl.saveAuthor(author1);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(author);

  }

  @GetMapping("/getAllAuthors")
  public ResponseEntity<?> getAllAuthors (){

    List<AuthorDtoReturn> list = authorServiceImpl.showAllAuthors();
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
  }

   @GetMapping("/getAuthorByiD/{id}")
  public ResponseEntity<?> getAuthorbYiD (@PathVariable Long id){

    AuthorDtoReturn author = authorServiceImpl.getAuthorById(id);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(author);
  }



  @DeleteMapping("/deleteById/{id}")
  public ResponseEntity<?> deleteById(@PathVariable Long id){

    authorServiceImpl.deleteAuthorById(id);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETE SUCESSFULLY");


  }


  @GetMapping("/getAuthorLikeLastName/{likeLastName}")
  public ResponseEntity<?> getAuthorLikeLastName (@PathVariable String likeLastName ){


    List<AuthorDtoReturn> list = authorServiceImpl.getAuthorLikeLastName(likeLastName);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);


  }



  



























}
