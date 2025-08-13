package com.querywithapi.querywithapiexercice.mapper;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.querywithapi.querywithapiexercice.dto.AuthorDtoReturn;
import com.querywithapi.querywithapiexercice.dto.BookDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanDtoReturn;
import com.querywithapi.querywithapiexercice.dto.LoanItemDtoReturn;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoInsert;
import com.querywithapi.querywithapiexercice.dto.UserAccountDtoReturn;
import com.querywithapi.querywithapiexercice.model.Author;
import com.querywithapi.querywithapiexercice.model.Book;
import com.querywithapi.querywithapiexercice.model.Loan;
import com.querywithapi.querywithapiexercice.model.LoanItem;
import com.querywithapi.querywithapiexercice.model.UserAccount;




@Mapper(componentModel = "spring")
public interface OrderMapper {

  AuthorDtoReturn authorToAuthorDtoReturn (Author author);
  List<AuthorDtoReturn> listAuthorToListAuthorDtoReturns ( List<Author> authores );




  @Mapping(target = "nameAuthor", expression = "java(book.getAuthor().getFirstName())")
  BookDtoReturn bookToBookDtoReturn (Book book);
  List<BookDtoReturn> bookListToBookDtoReturnList (List<Book> books );



  @Mapping(target = "id", ignore = true)
  @Mapping(target = "loan", ignore = true)
  UserAccount userAccountInsertToUserAccount (UserAccountDtoInsert user);
  UserAccountDtoReturn userAccountToUserAccountDtoReturn (UserAccount user);
  List<UserAccountDtoReturn> listUserAccountToUserAccountDtoReturns (List<UserAccount> users);

  


  @Mapping(target = "userAccount", expression = "java(loan.getUserAccount().getId())")
  @Mapping(target = "booksOnLoan", expression = "java(loanItemListToLoanItemDtoReturnsList(loan.getLoanItems()))")
  LoanDtoReturn loanToLoanDtoReturn (Loan loan );
  @Mapping(target= "loanId", expression="java(loan.getId())")
  LoanItemDtoReturn loanItemToLoanIDtoReturn (LoanItem loan );
  List<LoanItemDtoReturn> loanItemListToLoanItemDtoReturnsList (List<LoanItem> loans );
  List<LoanDtoReturn> loanListToLoanDtoReturnsList ( List<Loan> loans );







}
