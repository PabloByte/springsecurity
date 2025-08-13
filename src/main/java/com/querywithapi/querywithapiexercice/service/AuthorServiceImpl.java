package com.querywithapi.querywithapiexercice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.querywithapi.querywithapiexercice.dto.AuthorDtoInsert;
import com.querywithapi.querywithapiexercice.dto.AuthorDtoReturn;
import com.querywithapi.querywithapiexercice.mapper.OrderMapper;
import com.querywithapi.querywithapiexercice.model.Author;
import com.querywithapi.querywithapiexercice.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements  IAuthorService {

  private final AuthorRepository authorRepository;
  private final OrderMapper convert;

  public AuthorServiceImpl(AuthorRepository authorRepository, OrderMapper convert) {
    this.authorRepository = authorRepository;
    this.convert = convert;
  }

  @Override
  public AuthorDtoReturn saveAuthor(AuthorDtoInsert author) {

    Author newAuthor = new Author();

    newAuthor.setFirstName(author.getFirstName());
    newAuthor.setLastName(author.getLastName());
    newAuthor.setBirthDate(author.getBirthDate());
    
    authorRepository.save(newAuthor);

    return convert.authorToAuthorDtoReturn(newAuthor);

  }

  @Override
  public List<AuthorDtoReturn> showAllAuthors() {

    List<Author> list = authorRepository.findAll();

    return convert.listAuthorToListAuthorDtoReturns(list);
  }

  @Override
  public AuthorDtoReturn getAuthorById(Long id) {

    Author authorById = authorRepository.findById(id)
    .orElseThrow(()-> new RuntimeException("NO SE ENCONTRO EL AUTOR CON EL ID INGRESADO"));

    return convert.authorToAuthorDtoReturn(authorById);

  }

  @Override
  public void deleteAuthorById(Long id) {

     authorRepository.deleteById(id);


     
  }

  @Override
  public Author validateAuthor(Long id) {
    Author validarAutor = authorRepository.findById(id).orElseThrow(()-> new RuntimeException ("NO SE ENCONTRO EL AUTOR CON EL ID INDICADO, POR FAVOR CREELO "));
   return validarAutor;
  }

  @Override
  public List<AuthorDtoReturn> getAuthorLikeLastName(String likeLastName) {

    List<Author>  list = authorRepository.getAuthorLikeLastName(likeLastName);

    return convert.listAuthorToListAuthorDtoReturns(list);

  }

















}
