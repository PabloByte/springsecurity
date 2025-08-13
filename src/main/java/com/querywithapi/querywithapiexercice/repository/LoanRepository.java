package com.querywithapi.querywithapiexercice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {


  @Query("SELECT l.userAccount FROM Loan l GROUP BY l.userAccount HAVING COUNT(l) > ?1")
   List<Object[]> usersWithMoreThanXLoans (Integer Numbersloan);

  // @Query("SELECT l FROM Loan l WHERE l.userAccount.Id =?1")
  List<Loan> findByUserAccountId (Long userId);

















}
