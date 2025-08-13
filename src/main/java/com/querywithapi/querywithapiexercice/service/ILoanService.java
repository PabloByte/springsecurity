package com.querywithapi.querywithapiexercice.service;

import java.util.List;

import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanInsertDto;

public interface  ILoanService {


  LoanDtoReturn createLoan (LoanInsertDto loan);
  LoanDtoReturn GetLoanById  (Long id );

  List<LoanDtoReturn> usersWithMoreThanXLoans (Integer numberLoans);

  List<LoanDtoReturn> getLoansByUserId (Long userId);





}
