package com.querywithapi.querywithapiexercice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querywithapi.querywithapiexercice.dto.AuthorDtoInstance;
import com.querywithapi.querywithapiexercice.model.Author;
import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

  @Query("SELECT a from Author a WHERE LOWER(a.lastName) LIKE LOWER(CONCAT('%', ?1, '%'))")
  List<Author> getAuthorLikeLastName (String lastName);










}
