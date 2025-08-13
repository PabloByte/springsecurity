package com.querywithapi.querywithapiexercice.service;

import java.util.List;
import java.util.Optional;

import com.querywithapi.querywithapiexercice.dto.AuthorDtoInsert;
import com.querywithapi.querywithapiexercice.dto.AuthorDtoReturn;
import com.querywithapi.querywithapiexercice.model.Author;

public interface IAuthorService {



 public AuthorDtoReturn saveAuthor (AuthorDtoInsert author);
 public List<AuthorDtoReturn> showAllAuthors ();
 public AuthorDtoReturn getAuthorById (Long id);
 public void deleteAuthorById (Long id);
 public Author validateAuthor(Long id);

 List<AuthorDtoReturn> getAuthorLikeLastName(String likeLastName);


 




  



}
