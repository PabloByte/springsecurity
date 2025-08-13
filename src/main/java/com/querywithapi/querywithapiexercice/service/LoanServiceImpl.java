package com.querywithapi.querywithapiexercice.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.sqm.tree.expression.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanInsertDto;
import com.querywithapi.querywithapiexercice.handlerexception.InvalidLoanItemIdException;
import com.querywithapi.querywithapiexercice.handlerexception.LoanIdNotFoundException;
import com.querywithapi.querywithapiexercice.mapper.OrderMapper;
import com.querywithapi.querywithapiexercice.model.Book;
import com.querywithapi.querywithapiexercice.model.Loan;
import com.querywithapi.querywithapiexercice.model.LoanItem;
import com.querywithapi.querywithapiexercice.model.UserAccount;
import com.querywithapi.querywithapiexercice.repository.BookRepository;
import com.querywithapi.querywithapiexercice.repository.LoanItemRepository;
import com.querywithapi.querywithapiexercice.repository.LoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {

  private final LoanRepository loanRepository;
  private final LoanItemRepository loanItemRepository;
  private final UserAccountImpl userAccountImpl;
  private final  BookRepository bookRepository;
  private final OrderMapper convert;


  public LoanServiceImpl(LoanRepository loanRepository, LoanItemRepository loanItemRepository,
      UserAccountImpl userAccountImpl, BookRepository bookRepository, OrderMapper convert) {
    this.loanRepository = loanRepository;
    this.loanItemRepository = loanItemRepository;
    this.userAccountImpl = userAccountImpl;
    this.bookRepository = bookRepository;
    this.convert = convert;
  }


  @Override
  public LoanDtoReturn createLoan(LoanInsertDto loan) {

Loan newLoan = new Loan();

newLoan.setLoanDate(loan.getLoanDate());
newLoan.setReturnDate(loan.getReturnDate());
newLoan.setStatus(loan.getStatus());

UserAccount userAccount = userAccountImpl.validateUserAccount(loan.getUserAccountId());

newLoan.setUserAccount(userAccount);

 List<LoanItem> booksInTheLoan = new ArrayList<>();

for (Long  booksId  : loan.getBooksIdOnLoan() ) {

  Book book = bookRepository.findById(booksId).orElseThrow(()-> new RuntimeException("NO SE ENCONTRO EL item con el id enviado PARA AGREGAR AL PRESTAMO"));

  LoanItem newLoanItem = new LoanItem();

  newLoanItem.setBookId(book.getId());
  newLoanItem.setBookName(book.getTitle());

  booksInTheLoan.add(newLoanItem);
  newLoanItem.setLoan(newLoan);
 

}

newLoan.setLoanItems(booksInTheLoan);
loanRepository.save(newLoan);

return convert.loanToLoanDtoReturn(newLoan);

  }



  @Override
  public LoanDtoReturn GetLoanById(Long id) {

    Loan loanFound = loanRepository.findById(id).orElseThrow(()-> new LoanIdNotFoundException("NO SE ENCONTRO EL ID SOLICITADO"));
    
    return convert.loanToLoanDtoReturn(loanFound);
  
  }

  public List<LoanDtoReturn> getAllLoans (){
    List<Loan> list = loanRepository.findAll();

    return convert.loanListToLoanDtoReturnsList(list);
  }

  public  void deleteLoanByid (Long id){
    loanItemRepository.deleteById(id);
  }


  @Override
  public List<LoanDtoReturn> usersWithMoreThanXLoans(Integer numberLoans) {

    List<Object[]> list = loanRepository.usersWithMoreThanXLoans(numberLoans);

    List<LoanDtoReturn> listReturn = new ArrayList<>();

    for (Object[] arr : list) {

      LoanDtoReturn loan = new LoanDtoReturn();

      loan.setUserAccount((Long) arr[0]);
      listReturn.add(loan);
      
    }
    return listReturn;

  }


  @Override
  public List<LoanDtoReturn> getLoansByUserId (Long userId) {
    List<Loan> list = loanRepository.findByUserAccountId(userId);
    return convert.loanListToLoanDtoReturnsList(list);
  }













}
